package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TakeTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private List<Integer> result;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.take");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 2, 3, 10));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 2, 3, 10), rddA.collect());
        sc.close();
    }

    @Test
    public void testTake() {
        result = rddA.take(4);
        assertEquals(Arrays.asList(1, 2, 3, 2), result);
    }
}
