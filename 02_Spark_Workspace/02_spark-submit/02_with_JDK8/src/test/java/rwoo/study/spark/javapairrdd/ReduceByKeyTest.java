package rwoo.study.spark.javapairrdd;

import com.google.common.collect.Iterables;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReduceByKeyTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, Double> ranks;
    private JavaPairRDD<String, Double> contributions;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaPairRDD.reduceByKey");
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/ReduceByKeyTest/");
        JavaPairRDD<String, Iterable<String>> links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<>(parts[0], parts[1]);
        }).groupByKey().cache();
        ranks = links.mapValues(link -> 1.0);
        JavaPairRDD<String, Tuple2<Iterable<String>, Double>> joins = links.join(ranks);
        contributions = joins.values().flatMapToPair(items -> {
            int items_count = Iterables.size(items._1());
            List<Tuple2<String, Double>> myContributions = new ArrayList<>();
            items._1().forEach(dest -> myContributions.add(new Tuple2<>(dest, items._2() / items_count)));
            return myContributions.iterator();
        }).sortByKey().cache();
    }

    @After
    public void after() {
        assertEquals("[(A,1.0), (A,1.0), (B,0.5), (C,0.5), (C,0.5), (D,0.5)]", contributions.collect().toString());
        assertEquals("[(A,2.0), (B,0.5), (C,1.0), (D,0.5)]", ranks.collect().toString());
        sc.close();
    }

    @Test
    public void test_ReduceByKey_with_Implicit_Function() {
        ranks = contributions.reduceByKey((x, y) -> x + y).sortByKey();
    }

    @Test
    public void test_ReduceByKey_with_Explicit_Function() {
        Function2<Double, Double, Double> f = (x, y) -> x + y;
        ranks = contributions.reduceByKey(f).sortByKey();
    }

    @Test
    public void test_ReduceByKey_with_CustomFunction() {
        ranks = contributions.reduceByKey(new CustomFunction()).sortByKey();
    }

    static class CustomFunction implements Function2<Double, Double, Double> {
        @Override
        public Double call(Double x, Double y) throws Exception {
            return x + y;
        }
    }
}
