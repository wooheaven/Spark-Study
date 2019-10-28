package rwoo.study.spark.pairrdd;

import com.google.common.collect.Iterables;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.pairflatmapfunction.CustomPairFlatMapFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class FlatMapToPairTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, Iterable<String>> links;
    private JavaPairRDD<String, Tuple2<String, Double>> ranks;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
            .setMaster("local[*]")
            .setAppName("FlatMapToPairTest"));
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/FlatMapToPairTest/");
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().cache();
        links.foreach(link -> System.out.println(link));
//        (B,[A])
//        (A,[C, D])
//        (D,[B, C])
//        (C,[A])
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void test_FlatMapToPair_with_Explicit() {
        ranks = links.flatMapToPair(items -> {
            List<Tuple2<String, Tuple2<String, Double>>> myContributions = new ArrayList<>();
            items._2().forEach(dest ->
                myContributions.add(new Tuple2<>(items._1(), new Tuple2<>(dest, 1.0 / Iterables.size(items._2()))))
            );
            return myContributions.iterator();
        });
        ranks.foreach(rank -> System.out.println(rank));
//        (A,(C,0.5))
//        (B,(A,1.0))
//        (A,(D,0.5))
//        (D,(B,0.5))
//        (C,(A,1.0))
//        (D,(C,0.5))
    }

    @Test
    public void test_FlatMapToPair_with_CustomPairFlatMapFunction() {
        ranks = links.flatMapToPair(new CustomPairFlatMapFunction());
        ranks.foreach(rank -> System.out.println(rank));
//        (A,(C,0.5))
//        (B,(A,1.0))
//        (A,(D,0.5))
//        (D,(B,0.5))
//        (C,(A,1.0))
//        (D,(C,0.5))
    }

    @Test
    public void test_MapToPair() {
        JavaPairRDD<String, Tuple2<Iterable<String>, Double>> ranks = links.mapToPair(items ->
            new Tuple2<>(items._1(), new Tuple2<>(items._2(), 1.0 / Iterables.size(items._2())))
        );
        ranks.foreach(rank -> System.out.println(rank));
//        (B,([A],1.0))
//        (A,([C, D],0.5))
//        (D,([B, C],0.5))
//        (C,([A],1.0))
    }
}
