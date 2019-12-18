package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PipeTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaRDD.pipe");
        rddA = sc.parallelize(Arrays.asList("b", "aB", "c", "De"), 2);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("b", "aB", "c", "De"), rddA.collect());
//        assertEquals(Arrays.asList("b", "aB"), rddB.collect());
        sc.close();
    }

    @Test
    @Ignore
    public void testPipe() {
        rddB = rddA.pipe("grep --regexp=B -i");
    }
}
