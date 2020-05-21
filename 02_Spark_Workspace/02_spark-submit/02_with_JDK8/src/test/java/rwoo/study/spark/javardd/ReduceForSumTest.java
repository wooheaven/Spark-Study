package rwoo.study.spark.javardd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReduceForSumTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private Integer sum;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.reduce");
        rddA = sc.parallelize(Arrays.asList(2, 4, 10));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(2, 4, 10), rddA.collect());
        assertEquals(16, sum, 0.0);
        sc.close();
    }

    @Test
    public void testSum() {
        Func2 func = new Func2();
        sum = rddA.reduce(func);
//        sum = rddA.reduce(new Function2<Integer, Integer, Integer>() {
//            @Override
//            public Integer call(Integer a, Integer b) throws Exception {
//                return a + b;
//            }
//        }); org.apache.spark.SparkException: Task not serializable
    }

    static class Func2 implements Function2<Integer, Integer, Integer> {
        @Override
        public Integer call(Integer a, Integer b) throws Exception {
            return a + b;
        }
    }
}
