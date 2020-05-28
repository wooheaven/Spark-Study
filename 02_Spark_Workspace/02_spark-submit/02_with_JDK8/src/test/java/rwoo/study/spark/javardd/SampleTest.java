package rwoo.study.spark.javardd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SampleTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRdd.sample");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), rddA.collect());
        assertEquals(Arrays.asList(1, 2, 5, 7, 9, 10), rddB.collect());
        sc.close();
    }

    @Test
    public void testSample() {
        rddB = rddA.sample(false, 0.5, 30);
    }
}
