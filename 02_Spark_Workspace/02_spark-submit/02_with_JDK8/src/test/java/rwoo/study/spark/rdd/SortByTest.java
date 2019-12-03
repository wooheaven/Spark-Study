package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.function.CustomFunctionToLowerCase;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortByTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;
    private JavaRDD<String> rddC;
    private JavaRDD<String> rddD;
    private JavaRDD<String> rddE;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("SortByTest"));
        rddA = sc.parallelize(Arrays.asList("I am a boy", "You are a girl"));
        rddB = rddA.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("I am a boy", "You are a girl"), rddA.collect());
        assertEquals(Arrays.asList("I", "am", "a", "boy", "You", "are", "a", "girl"), rddB.collect());
        assertEquals(Arrays.asList("a", "a", "am", "are", "boy", "girl", "I", "You"), rddE.collect());
        sc.close();
    }

    @Test
    public void testSortBy_with_Implicit() {
        rddC = rddB.sortBy(v -> v, true, rddB.partitions().size());
        rddD = rddB.sortBy(v -> v, false, rddB.partitions().size());
        rddE = rddB.sortBy(v -> v.toLowerCase(), true, rddB.partitions().size());

        assertEquals(Arrays.asList("I", "You", "a", "a", "am", "are", "boy", "girl"), rddC.collect());
        assertEquals(Arrays.asList("girl", "boy", "are", "am", "a", "a", "You", "I"), rddD.collect());
    }

    @Test
    public void testSortBy_with_Explicit() {
        Function<String, String> f1 = v -> v;
        rddC = rddB.sortBy(f1, true, rddB.partitions().size());
        rddD = rddB.sortBy(f1, false, rddB.partitions().size());
        Function<String, String> f3 = v -> v.toLowerCase();
        rddE = rddB.sortBy(f3, true, rddB.partitions().size());

        assertEquals(Arrays.asList("I", "You", "a", "a", "am", "are", "boy", "girl"), rddC.collect());
        assertEquals(Arrays.asList("girl", "boy", "are", "am", "a", "a", "You", "I"), rddD.collect());
    }

    @Test
    public void testSortBy_with_CustomFunction() {
        rddE = rddB.sortBy(new CustomFunctionToLowerCase(), true, rddB.partitions().size());
    }
}
