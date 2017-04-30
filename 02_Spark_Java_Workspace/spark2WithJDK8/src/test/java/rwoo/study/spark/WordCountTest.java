package rwoo.study.spark;


import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.Arrays;

public class WordCountTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "WordCount");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testWordCount() {
        // run
        JavaRDD<String> lines = sc.parallelize(Arrays.asList("I am a boy", "You are a girl"));
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String, Integer> allWords = words.mapToPair(word -> new Tuple2<String, Integer>(word, 1));
        JavaPairRDD<String, Integer> counts = allWords.reduceByKey((x, y) -> x + y);

        // print
        System.out.println(counts.collect());
    }
}
