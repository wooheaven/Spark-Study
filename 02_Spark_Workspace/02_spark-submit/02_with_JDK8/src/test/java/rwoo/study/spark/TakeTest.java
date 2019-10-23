package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TakeTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "Take");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testTake() {
        // inputList
        List<String> inputList = new ArrayList<>();
        inputList.add("a");
        inputList.add("b");
        inputList.add("c");

        // input RDD
        JavaRDD<String> inputRDD1 = sc.parallelize(inputList);

        // run take
        List<String> takeList = inputRDD1.take(2);

        // print
        System.out.println(takeList);
    }
}
