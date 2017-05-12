package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "Reduce");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testReduce() {
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

        // run reduce
        Function2<String, String, String> wordSpaceWord = (oldWord, newWord) -> (oldWord + " " + newWord);
        String output = inputRDD.reduce(wordSpaceWord);

        // print
        System.out.println(output);
    }
}
