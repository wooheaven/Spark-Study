package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReduceTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private int result1 = 0;
    private int result2 = 0;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaRDD.reduce");
        rddA = sc.parallelize(Arrays.asList(1, 3, 5));
    }

    @After
    public void after() {
        assertEquals(9, result1);
        assertEquals(15, result2);
        sc.close();
    }

    @Test
    public void testReduce_with_IMplicit() {
        result1 = rddA.reduce((a, b) -> a + b);
        result2 = rddA.reduce((a, b) -> a * b);
    }

    @Test
    public void testReduce_with_Explicit() {
        Function2<Integer, Integer, Integer> add = (a, b) -> a + b;
        result1 = rddA.reduce(add);

        Function2<Integer, Integer, Integer> multiple = (a, b) -> a * b;
        result2 = rddA.reduce(multiple);
    }
}
