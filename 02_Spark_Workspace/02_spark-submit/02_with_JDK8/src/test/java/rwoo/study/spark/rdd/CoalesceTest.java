package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoalesceTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;

    @Before
    public void before() {
        sc = new JavaSparkContext("local", "JavaRDD.coalesce");
        rddA = sc.parallelize(Arrays.asList("a", "b", "c"), 3);
    }

    @After
    public void after() {
        assertEquals(3, rddA.getNumPartitions());
        assertEquals(2, rddB.getNumPartitions());
        sc.close();
    }

    @Test
    public void test_coalesce() {
        rddB = rddA.coalesce(2);
    }
}
