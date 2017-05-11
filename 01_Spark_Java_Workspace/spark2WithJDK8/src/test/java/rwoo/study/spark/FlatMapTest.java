package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "FlatMap");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testFlatMap() {
        // inputList
        List<String> inputList = new ArrayList<>();
        inputList.add("I am a boy");
        inputList.add("You are a girl");

        // input RDD
        JavaRDD<String> inputRDD = sc.parallelize(inputList);

        // run map
        JavaRDD<String> outputRDD = inputRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        // print
        System.out.println(outputRDD.count());
        System.out.println(outputRDD.collect());
    }
}
