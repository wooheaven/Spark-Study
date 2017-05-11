package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "Filter");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testFilter() {
        // inputList
        List<String> inputList = new ArrayList<>();
        inputList.add("I");
        inputList.add("am");
        inputList.add("a");
        inputList.add("boy");
        inputList.add("You");
        inputList.add("are");
        inputList.add("a");
        inputList.add("girl");

        // input RDD
        JavaRDD<String> inputRDD = sc.parallelize(inputList);

        // run filter
        Function<String, Boolean> condition = word -> word.length() < 3;
        JavaRDD<String> outputRDD = inputRDD.filter(condition);

        // print
        System.out.println(outputRDD.count());
        System.out.println(outputRDD.collect());
    }
}
