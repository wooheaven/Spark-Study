package rwoo.study.spark.pairrdd;

import org.apache.spark.SparkConf;
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
    private JavaPairRDD<String, Integer> wordPair;
    private JavaPairRDD<String, Iterable<Integer>> wordMergedRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
            .setMaster("local[*]")
            .setAppName("GroupByKeyTest"));
        List<String> inputList = new ArrayList<>();
        inputList.add("I am a boy");
        inputList.add("You are a girl");
        JavaRDD<String> inputRDD = sc.parallelize(inputList);
        JavaRDD<String> wordRDD = inputRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        wordPair = wordRDD.mapToPair(word -> new Tuple2<String, Integer>(word, 1));
        wordPair.foreach(v -> System.out.println(v));
//        (I,1)
//        (You,1)
//        (am,1)
//        (are,1)
//        (a,1)
//        (a,1)
//        (boy,1)
//        (girl,1)
    }

    @After
    public void tearDown() {
        wordMergedRDD.foreach(v -> System.out.println(v));
//        (You,[1])
//        (a,[1, 1])
//        (I,[1])
//        (are,[1])
//        (am,[1])
//        (girl,[1])
//        (boy,[1])
        sc.close();
    }

    @Test
    public void testGroupByKey() {
        wordMergedRDD = wordPair.groupByKey();
    }
}
