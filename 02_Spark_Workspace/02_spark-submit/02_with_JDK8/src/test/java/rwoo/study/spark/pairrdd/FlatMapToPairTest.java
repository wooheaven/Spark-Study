package rwoo.study.spark.pairrdd;

import com.google.common.collect.Iterables;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FlatMapToPairTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, Iterable<String>> links;
    private JavaPairRDD<String, Tuple2<String, Double>> ranks;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaPairRDD.flatMapToPair");
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/FlatMapToPairTest/");
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<>(parts[0], parts[1]);
        }).groupByKey().sortByKey().cache();
    }

    @After
    public void after() {
        assertEquals("[(A,[C, D]), (B,[A]), (C,[A]), (D,[B, C])]", links.collect().toString());
        sc.close();
    }

    @Test
    public void test_FlatMapToPair_with_Implicit() {
        ranks = links.flatMapToPair(items -> {
            List<Tuple2<String, Tuple2<String, Double>>> myContributions = new ArrayList<>();
            items._2().forEach(dest ->
                    myContributions.add(new Tuple2<>(items._1(), new Tuple2<>(dest, 1.0 / Iterables.size(items._2()))))
            );
            return myContributions.iterator();
        }).sortByKey();
        assertEquals("[(A,(C,0.5)), (A,(D,0.5)), (B,(A,1.0)), (C,(A,1.0)), (D,(B,0.5)), (D,(C,0.5))]", ranks.collect().toString());
    }

    @Test
    public void test_FlatMapToPair_with_Explicit() {
        PairFlatMapFunction<Tuple2<String, Iterable<String>>, String, Tuple2<String, Double>> f = items -> {
            List<Tuple2<String, Tuple2<String, Double>>> myContributions = new ArrayList<>();
            items._2().forEach(dest ->
                    myContributions.add(new Tuple2<>(items._1(), new Tuple2<>(dest, 1.0 / Iterables.size(items._2()))))
            );
            return myContributions.iterator();
        };
        ranks = links.flatMapToPair(f).sortByKey();
        assertEquals("[(A,(C,0.5)), (A,(D,0.5)), (B,(A,1.0)), (C,(A,1.0)), (D,(B,0.5)), (D,(C,0.5))]", ranks.collect().toString());
    }

    @Test
    public void test_FlatMapToPair_with_CustomPairFlatMapFunction() {
        ranks = links.flatMapToPair(new CustomPairFlatMapFunction()).sortByKey();
        assertEquals("[(A,(C,0.5)), (A,(D,0.5)), (B,(A,1.0)), (C,(A,1.0)), (D,(B,0.5)), (D,(C,0.5))]", ranks.collect().toString());
    }

    @Test
    public void test_MapToPair() {
        JavaPairRDD<String, Tuple2<Iterable<String>, Double>> ranks_compare = links.mapToPair(items ->
                new Tuple2<>(items._1(), new Tuple2<>(items._2(), 1.0 / Iterables.size(items._2())))
        );
        assertEquals("[(A,([C, D],0.5)), (B,([A],1.0)), (C,([A],1.0)), (D,([B, C],0.5))]", ranks_compare.collect().toString());
    }

    /**
     * (FROM,[TOs]) --> (FROM, (TO,CONTRIBUTION))
     * (A,[C, D]),  --> (A,(C,0.5)), (A,(D,0.5)),
     * (B,[A]),     --> (B,(A,1.0)),
     * (C,[A]),     --> (C,(A,1.0)),
     * (D,[B, C])   --> (D,(B,0.5)), (D,(C,0.5))
     */
    static class CustomPairFlatMapFunction implements PairFlatMapFunction<Tuple2<String, Iterable<String>>, String, Tuple2<String, Double>> {
        @Override
        public Iterator<Tuple2<String, Tuple2<String, Double>>> call(Tuple2<String, Iterable<String>> items) throws Exception {
            List<Tuple2<String, Tuple2<String, Double>>> myContributions = new ArrayList<>();
            items._2().forEach(dest ->
                    myContributions.add(new Tuple2<>(items._1(), new Tuple2<>(dest, 1.0 / Iterables.size(items._2()))))
            );
            return myContributions.iterator();
        }
    }
}
