package rwoo.study.spark.pairrdd;

import com.google.common.collect.Iterables;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.pairfunction.CustomPairFunctionDivideByItemSize;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapToPairTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, Iterable<String>> rddA;
    private JavaPairRDD<String, Tuple2<Iterable<String>, Double>> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaPairRDD.mapToPair");
        rddA = sc.textFile("src/test/resources/input/MapToPairTest/")
                .mapToPair(line -> {
                    String[] parts = line.split(" ");
                    return new Tuple2<>(parts[0], parts[1]);
                }).groupByKey().sortByKey().cache();
    }

    @After
    public void after() {
        assertEquals("[(A,[C, D]), (B,[A]), (C,[A]), (D,[B, C])]", rddA.collect().toString());
        sc.close();
    }

    @Test
    public void test_MapToPair_with_Implicit() {
        rddB = rddA.mapToPair(items ->
                new Tuple2<>(items._1(), new Tuple2<>(items._2(), 1.0 / Iterables.size(items._2())))
        ).sortByKey().cache();
        assertEquals(
                "[(A,([C, D],0.5)), (B,([A],1.0)), (C,([A],1.0)), (D,([B, C],0.5))]",
                rddB.collect().toString());
    }

    @Test
    public void test_MapToPair_with_Explicit() {
        PairFunction<Tuple2<String, Iterable<String>>, String, Tuple2<Iterable<String>, Double>> f = items -> {
            return new Tuple2<>(items._1(), new Tuple2<>(items._2(), 1.0 / Iterables.size(items._2())));
        };
        rddB = rddA.mapToPair(f).sortByKey().cache();
        assertEquals(
                "[(A,([C, D],0.5)), (B,([A],1.0)), (C,([A],1.0)), (D,([B, C],0.5))]",
                rddB.collect().toString());
    }

    @Test
    public void test_MapToPair_with_CustomPairFunction() {
        rddB = rddA.mapToPair(new CustomPairFunctionDivideByItemSize()).cache();
        assertEquals(
                "[(A,([C, D],0.5)), (B,([A],1.0)), (C,([A],1.0)), (D,([B, C],0.5))]",
                rddB.collect().toString());
    }

    @Test
    public void test_compare_mapToPair_vs_flatMapToPair() {
        JavaPairRDD<String, Tuple2<String, Double>> rddC = rddA.flatMapToPair(items -> {
            List<Tuple2<String, Tuple2<String, Double>>> myContributions = new ArrayList<>();
            items._2().forEach(dest ->
                    myContributions.add(new Tuple2<>(items._1(), new Tuple2<>(dest, 1.0 / Iterables.size(items._2()))))
            );
            return myContributions.iterator();
        });
        assertEquals(
                "[(A,(C,0.5)), (A,(D,0.5)), (B,(A,1.0)), (C,(A,1.0)), (D,(B,0.5)), (D,(C,0.5))]",
                rddC.collect().toString()
        );
    }
}
