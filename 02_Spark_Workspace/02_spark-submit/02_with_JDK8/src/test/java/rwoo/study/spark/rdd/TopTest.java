package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private List<Integer> result;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaRDD.top");
        rddA = sc.parallelize(Arrays.asList(1, 3, 1, 2, 3));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 3, 1, 2, 3), rddA.collect());
        assertEquals(Arrays.asList(3, 3, 2), result);
        sc.close();
    }

    @Test
    public void testTop() {
        result = rddA.top(3);
    }
}
