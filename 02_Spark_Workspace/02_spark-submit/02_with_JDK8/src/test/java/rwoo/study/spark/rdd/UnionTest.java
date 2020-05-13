package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnionTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;
    private JavaRDD<Integer> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaRDD.union");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3), 2);
        rddB = sc.parallelize(Arrays.asList(3, 4), 2);
    }

    @After
    public void after() {
        // prepare assert value
        List<Integer> array1 = Arrays.asList(1);
        List<Integer> array23 = Arrays.asList(2, 3);
        List<List<Integer>> rddAGlom = Arrays.asList(array1, array23);
        List<Integer> array3 = Arrays.asList(3);
        List<Integer> array4 = Arrays.asList(4);
        List<List<Integer>> rddBGlom = Arrays.asList(array3, array4);
        List<List<Integer>> rddCGlom = Arrays.asList(array1, array23, array3, array4);

        // assert
        assertEquals(Arrays.asList(1, 2, 3), rddA.collect());
        assertEquals(rddAGlom, rddA.glom().collect());
        assertEquals(Arrays.asList(3, 4), rddB.collect());
        assertEquals(rddBGlom, rddB.glom().collect());
        assertEquals(Arrays.asList(1, 2, 3, 3, 4), rddC.collect());
        assertEquals(rddCGlom, rddC.glom().collect());
        sc.close();
    }

    @Test
    public void testSample() {
        rddC = rddA.union(rddB);
    }
}
