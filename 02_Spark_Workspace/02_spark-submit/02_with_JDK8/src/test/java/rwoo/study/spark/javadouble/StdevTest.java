package rwoo.study.spark.javadouble;

import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StdevTest {
    private JavaSparkContext sc;
    private JavaDoubleRDD rddA;
    private Double stdev;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaDoubleRDD.stdev");
        rddA = sc.parallelizeDoubles(Arrays.asList(2.0, 4.0, 10.0));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(2.0, 4.0, 10.0), rddA.collect());
        assertEquals(3.39934634239519, stdev, 0.0001);
        sc.close();
    }

    @Test
    public void testStdev() {
        stdev = rddA.stdev();
    }
}
