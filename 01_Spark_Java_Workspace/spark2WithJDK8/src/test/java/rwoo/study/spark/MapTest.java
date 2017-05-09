package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "Map");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testMap() {
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

        // run map
        JavaRDD<String> outputRDD = inputRDD.map(e -> e.toLowerCase());

        // print
        System.out.println(outputRDD.collect());
    }
}
