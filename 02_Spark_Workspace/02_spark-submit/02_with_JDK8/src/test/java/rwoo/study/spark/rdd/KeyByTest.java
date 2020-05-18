package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class KeyByTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaPairRDD<String, String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.keyBy");
        rddA = sc.parallelize(Arrays.asList("John", "Fred", "Anna", "James"));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("John", "Fred", "Anna", "James"), rddA.collect());
        assertEquals("[(A,Anna), (F,Fred), (J,John), (J,James)]", rddB.collect().toString());
        sc.close();
    }

    @Test
    public void test_keyBy() {
        rddB = rddA.keyBy(x -> x.substring(0, 1)).sortByKey();
    }
}
