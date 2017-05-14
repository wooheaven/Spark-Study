package rwoo.study.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupByTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "GroupBy");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testGroupBy() {
        // inputList
        List<String> inputList = new ArrayList<>();
        inputList.add("April");
        inputList.add("April");
        inputList.add("Awesome");
        inputList.add("Baby");
        inputList.add("Beautiful");
        inputList.add("Beautiful");
        inputList.add("Beautiful");

        // input RDD
        JavaRDD<String> inputRDD = sc.parallelize(inputList);

        // run GroupBy
        JavaPairRDD<Character, Iterable<String>> outputRDD = inputRDD.groupBy(word -> word.charAt(0));

        // print
        for (Tuple2<Character, Iterable<String>> myTyuple : outputRDD.collect()) {
            System.out.println("[" + myTyuple._2() + " in " + myTyuple._1() + "]");
        }
    }
}
