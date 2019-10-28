package rwoo.study.spark.pairrdd;

import avro.shaded.com.google.common.collect.Iterables;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.function.CustomFunction2;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceByKeyTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, Double> ranks;
    private JavaPairRDD<String , Double> contributions;

        @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
             .setMaster("local[*]")
             .setAppName("ReduceByKeyTest"));
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/ReduceByKeyTest/");
        JavaPairRDD<String, Iterable<String>> links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().cache();
        ranks = links.mapValues(link -> 1.0);
        JavaPairRDD<String, Tuple2<Iterable<String>, Double>> joins = links.join(ranks);
        contributions = joins.values().flatMapToPair(items -> {
            int items_count = Iterables.size(items._1());
            List<Tuple2<String, Double>> myContributions = new ArrayList<>();
            items._1().forEach(dest -> myContributions.add(new Tuple2<>(dest, items._2() / items_count)));
            return myContributions.iterator();
        });
        contributions.foreach(contribution -> System.out.println(contribution));
//        (A,1.0)
//        (C,0.5)
//        (D,0.5)
//        (B,0.5)
//        (C,0.5)
//        (A,1.0)
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void test_ReduceByKey_with_Implicit_Function() {
        ranks = contributions.reduceByKey((x, y) -> x + y);
        ranks.foreach(rank -> System.out.println(rank));
//        (B,0.5)
//        (A,2.0)
//        (D,0.5)
//        (C,1.0)
    }

    @Test
    public void test_ReduceByKey_with_Explicit_Function() {
        Function2<Double, Double, Double> f = (x, y) -> x + y;
        ranks = contributions.reduceByKey(f);
        ranks.foreach(rank -> System.out.println(rank));
//        (B,0.5)
//        (A,2.0)
//        (D,0.5)
//        (C,1.0)
    }

    @Test
    public void test_ReduceByKey_with_CustomFunction2() {
        ranks = contributions.reduceByKey(new CustomFunction2());
        ranks.foreach(rank -> System.out.println(rank));
//        (B,0.5)
//        (A,2.0)
//        (D,0.5)
//        (C,1.0)
    }
}
