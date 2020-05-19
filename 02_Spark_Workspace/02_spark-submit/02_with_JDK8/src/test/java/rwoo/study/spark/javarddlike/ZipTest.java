package rwoo.study.spark.javarddlike;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ZipTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;
    private JavaPairRDD<Integer, Integer> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.zip");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3));
        rddB = rddA.map(x -> x * x);
    }

    @After
    public void after() {
        assertEquals("[(1,1), (2,4), (3,9)]", rddC.collect().toString());
        sc.close();
    }

    @Test
    public void testZip() {
        rddC = rddA.zip(rddB);
    }
}
