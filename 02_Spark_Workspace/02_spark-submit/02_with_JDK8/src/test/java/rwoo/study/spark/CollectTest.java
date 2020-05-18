package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "Collect");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testCollect() {
        // inputList
        List<String> inputList = new ArrayList<>();
        inputList.add("I am a boy");
        inputList.add("You are a girl");

        // input RDD
        JavaRDD<String> inputRDD = sc.parallelize(inputList);

        // print
        System.out.println(inputRDD.toDebugString());
        System.out.println(inputRDD.collect());
    }
}
