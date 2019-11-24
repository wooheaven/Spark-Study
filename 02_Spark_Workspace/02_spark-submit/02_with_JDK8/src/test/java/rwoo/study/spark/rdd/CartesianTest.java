package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CartesianTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;
    private JavaPairRDD<String, String> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("Cartesian"));
        rddA = sc.parallelize(Arrays.asList("b", "a", "c"));
        rddB = sc.parallelize(Arrays.asList("1","2"));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("b", "a", "c"), rddA.collect());
        assertEquals(Arrays.asList("1", "2"), rddB.collect());
        assertEquals("[(b,1), (b,2), (a,1), (a,2), (c,1), (c,2)]", rddC.collect().toString());
        sc.close();
    }

    @Test
    public void testCartesian() {
        rddC = rddA.cartesian(rddB);
    }
}
