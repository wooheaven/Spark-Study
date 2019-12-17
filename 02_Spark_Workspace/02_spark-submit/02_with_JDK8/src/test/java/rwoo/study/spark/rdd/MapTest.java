package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MapTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<Tuple2<String, Integer>> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("JavaRDD.map"));
        rddA = sc.parallelize(Arrays.asList("b", "a", "c"));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("b", "a", "c"), rddA.collect());
        assertEquals("[(b,1), (a,1), (c,1)]", rddB.collect().toString());
        sc.close();
    }

    @Test
    public void testMap() {
        rddB = rddA.map(v -> new Tuple2<String, Integer>(v, 1));
    }
}
