package rwoo.study.spark.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class PiEstimation {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("PiEstimation by JDK8");
        if (3 == args.length) {
            System.out.println("args for debugging");
            System.out.println("args[0] input  Example = hdfs:///user/hadoop/input");
            System.out.println("args[0] = " + args[0]);
            System.out.println("args[1] output Example = hdfs:///user/hadoop/output");
            System.out.println("args[1] = " + args[1]);
            System.out.println("args[2] master Example = local[*] or yarn");
            System.out.println("args[2] = " + args[2]);
            conf.setMaster(args[2]);
        } else if (2 == args.length) {
            System.out.println("args for cluster");
            System.out.println("args[0] input  Example = hdfs:///user/hadoop/input");
            System.out.println("args[0] = " + args[0]);
            System.out.println("args[1] output Example = hdfs:///user/hadoop/output");
            System.out.println("args[1] = " + args[1]);
        } else {
            System.out.println("args are bad : " + args);
            System.exit(-1);
        }
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile(args[0]);
        JavaRDD<String> quarter_circle = lines.filter(i -> {
            double x = Math.random();
            double y = Math.random();
            return x*x + y*y < 1;
        });
        List<Double> piList = new ArrayList<>();
        piList.add(quarter_circle.count() * 4.0 / lines.count());
        JavaRDD<Double> pi = sc.parallelize(piList);
        pi.repartition(1).saveAsTextFile(args[1]);

        sc.close();
    }
}
