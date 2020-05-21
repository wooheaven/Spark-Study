package rwoo.study.spark.javadouble;

import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MeanTest {
    private JavaSparkContext sc;
    private JavaDoubleRDD rddA;
    private Double mean;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaDoubleRDD.mean");
        rddA = sc.parallelizeDoubles(Arrays.asList(2.0, 4.0, 10.0));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(2.0, 4.0, 10.0), rddA.collect());
        assertEquals(5.333333333333333, mean, 0.0001);
        sc.close();
    }

    @Test
    public void testMean() {
        mean = rddA.mean();
    }
}
