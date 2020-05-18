package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GlomTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<List<Integer>> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.glom");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), rddA.collect());
        assertEquals(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6, 7)), rddB.collect());
        sc.close();
    }

    @Test
    public void testGetNumPartitions() {
        rddB = rddA.glom();
    }
}
