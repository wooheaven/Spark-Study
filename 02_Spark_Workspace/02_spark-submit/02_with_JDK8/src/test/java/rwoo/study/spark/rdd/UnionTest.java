package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UnionTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;
    private JavaRDD<Integer> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("SampleTest"));
        rddA = sc.parallelize(Arrays.asList(1, 3, 5));
        rddB = sc.parallelize(Arrays.asList(2, 4, 6));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 3, 5), rddA.collect());
        assertEquals(Arrays.asList(2, 4, 6), rddB.collect());
        assertEquals(Arrays.asList(1, 3, 5, 2, 4, 6), rddC.collect());
        sc.close();
    }

    @Test
    public void testSample() {
        rddC = rddA.union(rddB);
    }
}
