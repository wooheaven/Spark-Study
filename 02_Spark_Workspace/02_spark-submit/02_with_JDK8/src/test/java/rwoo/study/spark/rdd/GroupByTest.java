package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.function.CustomFunctionThreeGroup;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GroupByTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaPairRDD<Integer, Iterable<Integer>> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("JavaRDD.groupBy"));
        rddA = sc.parallelize(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), rddA.collect());
        assertEquals("[(0,[0, 3, 6, 9]), (1,[1, 4, 7]), (2,[2, 5, 8])]", rddB.collect().toString());
        sc.close();
    }

    @Test
    public void testGroupBy_with_Implicit() {
        rddB = rddA.groupBy(v -> v % 3);
    }

    @Test
    public void testGroupBy_with_Explicit() {
        Function<Integer, Integer> f = v -> v % 3;
        rddB = rddA.groupBy(f);
    }

    @Test
    public void testGroupBy_with_CustomFunction() {
        rddB = rddA.groupBy(new CustomFunctionThreeGroup());
    }
}
