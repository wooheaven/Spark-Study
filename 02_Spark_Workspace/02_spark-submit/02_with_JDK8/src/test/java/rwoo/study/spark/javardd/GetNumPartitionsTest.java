package rwoo.study.spark.javardd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GetNumPartitionsTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private int numPartitions;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.getNumPartitions");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
    }

    @After
    public void after() {
        assertEquals("[[1, 2], [3, 4], [5, 6, 7]]", rddA.glom().collect().toString());
        assertEquals(3, numPartitions);
        sc.close();
    }

    @Test
    public void testGetNumPartitions() {
        numPartitions = rddA.getNumPartitions();
    }
}
