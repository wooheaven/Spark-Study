package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlatMapTest {
    private JavaSparkContext sc;
    private List<String> inputList;
    private JavaRDD<String> inputRDD;
    private JavaRDD<String> outputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("FlatMapTest"));
        inputList = new ArrayList<>(Arrays.asList("I am a boy", "You are a girl"));
        inputRDD = sc.parallelize(inputList);
    }

    @After
    public void after() {
        outputRDD.foreach(v -> System.out.println(v));
        assertEquals("[I am a boy, You are a girl]", inputRDD.collect().toString());
        assertEquals("[I, am, a, boy, You, are, a, girl]", outputRDD.collect().toString());
        sc.close();
    }

    @Test
    public void testFlatMap() {
        outputRDD = inputRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
    }
}
