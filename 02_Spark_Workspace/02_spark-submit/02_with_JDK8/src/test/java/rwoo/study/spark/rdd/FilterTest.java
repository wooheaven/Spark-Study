package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FilterTest {
    private JavaSparkContext sc;
    private JavaRDD<String> words;
    private JavaRDD<String> words_filtered;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("FilterTest"));
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/FilterTest/");
        words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
    }

    @After
    public void after() {
        assertEquals("[I, am, a, Boy]", words.collect().toString());
        assertEquals("[I, am, a]", words_filtered.collect().toString());
        sc.close();
    }

    @Test
    public void test_Filter_with_implicit() {
        words_filtered = words.filter(word -> word.length() < 3);
    }

    @Test
    public void testFilter_with_Explicit() {
        Function<String, Boolean> filter_function = word -> word.length() < 3;
        words_filtered = words.filter(filter_function);
    }
}
