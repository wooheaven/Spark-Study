package rwoo.study.spark.javarddlike;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CollectTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> inputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.collect");
        inputRDD = sc.parallelize(Arrays.asList(1, 2, 3), 2);
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testCollect() {
        assertEquals("[1, 2, 3]", inputRDD.collect().toString());
        System.out.println(inputRDD.toDebugString());
    }
}
