package rwoo.study.spark.javarddlike;

import org.apache.commons.collections4.ListUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AggregateKeepValuesTest {
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
        Tuple2<List<Integer>, Integer> zeroValue = new Tuple2<>(Arrays.asList(), 0);
        Function2<Tuple2<List<Integer>, Integer>, Integer, Tuple2<List<Integer>, Integer>> seqOp =
                (aggregated, value) -> new Tuple2<>(ListUtils.union(aggregated._1, Arrays.asList(value)), aggregated._2() + value);

        Function2<Tuple2<List<Integer>, Integer>, Tuple2<List<Integer>, Integer>, Tuple2<List<Integer>, Integer>> combOp =
                (a, b) -> new Tuple2<>(ListUtils.union(a._1(), b._1()), a._2() + b._2());
        Tuple2<List<Integer>, Integer> result = rddA.aggregate(zeroValue, seqOp, combOp);
        assertTrue(customSetAssert(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), result._1()));
        assertEquals(45, result._2(), 0.0);
    }

    @Test
    public void testAggregate_by_CustomClass() {
        ValuesSum initialValue = new ValuesSum(Arrays.asList(), 0);
        Function2<ValuesSum, Integer, ValuesSum> seqOp =
                (aggregated, value) -> {
                    aggregated.setList(ListUtils.union(aggregated.getList(), Arrays.asList(value)));
                    aggregated.setSum(aggregated.getSum() + value);
                    return aggregated;
                };
        Function2<ValuesSum, ValuesSum, ValuesSum> combOp =
                (a, b) -> {
                    a.setList(ListUtils.union(a.getList(), b.getList()));
                    a.setSum(a.getSum() + b.getSum());
                    return a;
                };
        ValuesSum result = rddA.aggregate(initialValue, seqOp, combOp);
        assertTrue(customSetAssert(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), result.getList()));
        assertEquals(45, result.getSum());
    }

    private boolean customSetAssert(List<Integer> listA, List<Integer> listB) {
        boolean result = true;
        String listBStr = listB.toString();
        for (int i = 0; i < listA.size(); i++) {
            if (!listBStr.contains(listA.get(i).toString())) {
                result = false;
                break;
            }
        }
        String listAStr = listA.toString();
        for (int i = 0; i < listB.size(); i++) {
            if (!listAStr.contains(listB.get(i).toString())) {
                result = false;
                break;
            }
        }
        return result;
    }

    static class ValuesSum implements Serializable {
        List<Integer> list;
        int sum;

        public ValuesSum(List<Integer> list, int sum) {
            this.list = list;
            this.sum = sum;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }
}
