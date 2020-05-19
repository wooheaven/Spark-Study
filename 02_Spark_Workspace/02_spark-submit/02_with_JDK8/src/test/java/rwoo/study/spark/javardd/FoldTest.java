package rwoo.study.spark.javardd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FoldTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private int sum;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.fold");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 3);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), rddA.collect());
        assertEquals(45, sum);
        sc.close();
    }

    @Test
    public void testFold_with_Implicit() {
        sum = rddA.fold(0, (a, b) -> a + b);
    }

    @Test
    public void testFold_with_Explicit() {
        Function2<Integer, Integer, Integer> f = (a, b) -> a + b;
        sum = rddA.fold(0, f);
    }
}
