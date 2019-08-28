package rwoo.study.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupByKeyTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "GroupByKey");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testGroupByKey() {
        // inputList
        List<String> inputList = new ArrayList<>();
        inputList.add("I am a boy");
        inputList.add("You are a girl");

        // input RDD
        JavaRDD<String> inputRDD = sc.parallelize(inputList);

        // run GroupByKey
        JavaRDD<String> wordRDD = inputRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String, Integer> wordPair = wordRDD.mapToPair(word -> new Tuple2<String, Integer>(word, 1));
        JavaPairRDD<String, Iterable<Integer>> wordMergedRDD = wordPair.groupByKey();

        // print
        for (Tuple2<String, Iterable<Integer>> myTuple : wordMergedRDD.collect()) {
            System.out.println("(" + myTuple._1() + "," + myTuple._2() + ")");
        }
    }
}
