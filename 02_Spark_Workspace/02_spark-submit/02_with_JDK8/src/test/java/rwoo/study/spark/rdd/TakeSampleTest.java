package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TakeSampleTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private List<Integer> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaRDD.sample");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), rddA.collect());
        assertEquals(Arrays.asList(6, 4, 2, 3, 5), rddB);
        sc.close();
    }

    @Test
    public void testSample() {
        rddB = rddA.takeSample(false, 5, 3);
    }
}
