package rwoo.study.spark.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {
    public static void main(String[] args) {
        if(3 !=args.length) {
            System.out.println("use args[0] master Example = yarn or local[*]");
            System.out.println("use args[1] input  Example = hdfs:///user/hadoop/input");
            System.out.println("use args[2] output Example = hdfs:///user/hadoop/output");
            System.exit(-1);
        }

        SparkConf conf = new SparkConf();
        conf.setMaster(args[0]);
        conf.setAppName("WordCount by JDK8");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile(args[1]);
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String, Integer> allWords = words.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> wordCounts = allWords.reduceByKey((x, y) -> x + y).sortByKey();
        if ("console" == args[2]) {
            wordCounts.collect().forEach(tuple -> System.out.println(tuple._1() + "\t" + tuple._2()));
        } else {
            wordCounts.saveAsTextFile(args[2]);
        }

        sc.close();
    }
}
