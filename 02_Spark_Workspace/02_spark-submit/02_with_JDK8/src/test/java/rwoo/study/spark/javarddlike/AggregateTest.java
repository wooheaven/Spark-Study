package rwoo.study.spark.javarddlike;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AggregateTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDDLike.aggregate");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 3);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), rddA.collect());
        sc.close();
    }

    @Test
    public void testAggregate_by_Tuple2() {
        Tuple2<Integer, Integer> zeroValue = new Tuple2<>(0, 1);
        Function2<Tuple2<Integer, Integer>, Integer, Tuple2<Integer, Integer>> seqOp =
                (aggregated, value) -> new Tuple2<>(aggregated._1() + value, aggregated._2() * value);

        Function2<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Tuple2<Integer, Integer>> combOp =
                (a, b) -> new Tuple2<>(a._1() + b._1(), a._2() * b._2());
        Tuple2<Integer, Integer> result = rddA.aggregate(zeroValue, seqOp, combOp);
        assertEquals(new Tuple2<Integer, Integer>(45, 362880), result);
    }

    @Test
    public void testAggregate_by_CustomClass() {
        SumProduct zeroValue = new SumProduct(0, 1);
        Function2<SumProduct, Integer, SumProduct> seqOp =
                (aggregated, value) -> {
                    aggregated.setSum(aggregated.getSum() + value);
                    aggregated.setProduct(aggregated.getProduct() * value);
                    return aggregated;
                };
        Function2<SumProduct, SumProduct, SumProduct> combOp =
                (a, b) -> {
                    a.setSum(a.getSum() + b.getSum());
                    a.setProduct(a.getProduct() * b.getProduct());
                    return a;
                };
        SumProduct result = rddA.aggregate(zeroValue, seqOp, combOp);
        assertEquals(45, result.getSum());
        assertEquals(362880, result.getProduct());
    }

    static class SumProduct implements Serializable {
        int sum, product;

        public SumProduct(int sum, int product) {
            this.sum = sum;
            this.product = product;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public int getProduct() {
            return product;
        }

        public void setProduct(int product) {
            this.product = product;
        }
    }
}
