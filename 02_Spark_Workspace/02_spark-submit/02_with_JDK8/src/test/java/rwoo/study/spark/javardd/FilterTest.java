package rwoo.study.spark.javardd;

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
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.filter");
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/FilterTest/");
        rddA = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("I", "am", "a", "Boy"), rddA.collect());
        assertEquals(Arrays.asList("I", "am", "a"), rddB.collect());
        sc.close();
    }

    @Test
    public void test_Filter_with_Implicit() {
        rddB = rddA.filter(word -> word.length() < 3);
    }

    @Test
    public void testFilter_with_Explicit() {
        Function<String, Boolean> filter_function = word -> word.length() < 3;
        rddB = rddA.filter(filter_function);
    }
}
