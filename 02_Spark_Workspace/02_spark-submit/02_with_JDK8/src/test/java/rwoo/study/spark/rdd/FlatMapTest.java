package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlatMapTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.flatMap");
        rddA = sc.parallelize(Arrays.asList("I am a boy", "You are a girl"));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("I am a boy", "You are a girl"), rddA.collect());
        assertEquals(Arrays.asList("I", "am", "a", "boy", "You", "are", "a", "girl"), rddB.collect());
        sc.close();
    }

    @Test
    public void testFlatMap() {
        rddB = rddA.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
    }
}
