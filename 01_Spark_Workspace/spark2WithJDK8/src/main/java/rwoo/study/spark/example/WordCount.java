package rwoo.study.spark.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {
    public static void main(String[] args) {
        if (2 !=args.length) {
            System.out.println("use args[0] input  Example = hdfs:///user/hadoop/input");
            System.out.println("use args[1] output Example = hdfs:///user/hadoop/output");
            System.exit(-1);
        } else {
            System.out.println("args are good");
            System.out.println("input args[0] = " + args[0]);
            System.out.println("output args[1] = " + args[1]);
        }

        SparkConf conf = new SparkConf();
        conf.setAppName("WordCount by JDK8");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile(args[0]);
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String, Integer> allWords = words.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> wordCounts = allWords.reduceByKey((x, y) -> x + y).sortByKey();
        wordCounts.saveAsTextFile(args[1]);

        sc.close();
    }
}
