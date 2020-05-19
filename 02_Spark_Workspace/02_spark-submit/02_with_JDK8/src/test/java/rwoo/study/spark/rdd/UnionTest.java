package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UnionTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;
    private JavaRDD<Integer> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.union");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3), 2);
        rddB = sc.parallelize(Arrays.asList(3, 4), 2);
    }

    @After
    public void after() {
        // assert
        assertEquals("[[1], [2, 3]]", rddA.glom().collect().toString());
        assertEquals("[[3], [4]]", rddB.glom().collect().toString());
        assertEquals("[[1], [2, 3], [3], [4]]", rddC.glom().collect().toString());
        sc.close();
    }

    @Test
    public void testSample() {
        rddC = rddA.union(rddB);
    }
}
