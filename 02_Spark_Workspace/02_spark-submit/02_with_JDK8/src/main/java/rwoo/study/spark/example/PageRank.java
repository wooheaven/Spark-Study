package rwoo.study.spark.example;

import com.google.common.collect.Iterables;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class PageRank {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("PageRank by JDK8");
        if (4 == args.length) {
            System.out.println("args for debugging");
            System.out.println("args[0] input  Example = hdfs:///user/hadoop/input");
            System.out.println("args[0] = " + args[0]);
            System.out.println("args[1] output Example = hdfs:///user/hadoop/output");
            System.out.println("args[1] = " + args[1]);
            System.out.println("args[2] iteration = 1 or more");
            System.out.println("args[2] = " + args[2]);
            System.out.println("args[3] master Example = local[*] or yarn");
            System.out.println("args[3] = " + args[3]);
            conf.setMaster(args[3]);
        } else if (3 == args.length) {
            System.out.println("args for cluster");
            System.out.println("args[0] input  Example = hdfs:///user/hadoop/input");
            System.out.println("args[0] = " + args[0]);
            System.out.println("args[1] output Example = hdfs:///user/hadoop/output");
            System.out.println("args[1] = " + args[1]);
            System.out.println("args[2] iteration = 1 or more");
            System.out.println("args[2] = " + args[2]);
        } else {
            System.out.println("args are bad : " + args);
            System.exit(-1);
        }
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile(args[0]);
        JavaPairRDD<String, Iterable<String>> links = lines.mapToPair(s -> {
            String[] parts = s.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().cache();
        JavaPairRDD<String, Double> ranks = links.mapValues(link -> 1.0);
        Integer iteration = Integer.parseInt(args[2]);
        for (int i = 0; i < iteration; i++) {
            JavaPairRDD<String, Tuple2<Iterable<String>, Double>> joins = links.join(ranks);
            JavaPairRDD<String , Double> contributions = joins.values().flatMapToPair(items -> {
                int items_count = Iterables.size(items._1());
                List<Tuple2<String, Double>> contribution = new ArrayList<>();
                items._1().forEach(dest -> contribution.add(new Tuple2<>(dest, items._2() / items_count)));
                return contribution.iterator();
            });
            ranks = contributions.reduceByKey((x, y) -> x + y).mapValues(x -> 0.15 + x * 0.85);
        }
        ranks.saveAsTextFile(args[1]);
        sc.close();
    }
}
