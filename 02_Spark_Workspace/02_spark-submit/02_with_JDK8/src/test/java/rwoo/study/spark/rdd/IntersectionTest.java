package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntersectionTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;
    private JavaRDD<Integer> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("IntersectionTest"));
        rddA = sc.parallelize(Arrays.asList(1, 3, 5));
        rddB = sc.parallelize(Arrays.asList(1, 4, 6));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 3, 5), rddA.collect());
        assertEquals(Arrays.asList(1, 4, 6), rddB.collect());
        assertEquals(Arrays.asList(1), rddC.collect());
        sc.close();
    }

    @Test
    public void testIntersection() {
        rddC = rddA.intersection(rddB);
    }
}
