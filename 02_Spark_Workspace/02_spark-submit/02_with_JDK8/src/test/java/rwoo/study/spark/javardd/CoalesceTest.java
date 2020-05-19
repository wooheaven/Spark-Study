package rwoo.study.spark.javardd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CoalesceTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;

    @Before
    public void before() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.coalesce");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 2, 3, 10), 3);
    }

    @After
    public void after() {
        assertEquals(3, rddA.getNumPartitions());
        assertEquals(2, rddB.getNumPartitions());
        assertEquals("[[1, 2], [3, 2], [3, 10]]", rddA.glom().collect().toString());
        assertEquals("[[1, 2], [3, 2, 3, 10]]", rddB.glom().collect().toString());
        sc.close();
    }

    @Test
    public void test_coalesce() {
        rddB = rddA.coalesce(2);
    }
}
