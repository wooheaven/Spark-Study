package rwoo.study.spark.pairrdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;

public class MapValuesTest implements Serializable {
    private JavaSparkContext sc;
    private JavaPairRDD<String, Iterable<String>> links;
    private JavaPairRDD<String, Tuple2<String, Double>> ranks;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "JavaPairRDD.mapValues");
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/MapValuesTest/");
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<>(parts[0], parts[1]);
        }).groupByKey().sortByKey().cache();
    }

    @After
    public void tearDown() {
        assertEquals("[(A,[C, D]), (B,[A]), (C,[A]), (D,[B, C])]", links.collect().toString());
        assertEquals(
                "[(A,([C, D],1.0)), (B,([A],1.0)), (C,([A],1.0)), (D,([B, C],1.0))]",
                ranks.collect().toString());
        sc.close();
    }

    @Test
    public void test_MapValues_with_Implicit_Function() {
        ranks = links.mapValues(v -> new Tuple2<>(v.toString(), 1.0));
    }

    @Test
    public void test_MapValues_with_Explicit_Function() {
        Function<Iterable<String>, Tuple2<String, Double>> f = v -> new Tuple2<>(v.toString(), 1.0);
        ranks = links.mapValues(f);
    }

    @Test
    public void test_MapValues_with_CustomFunction() {
        ranks = links.mapValues(new CustomFunction());
    }

    /*
    (FROM, [TOs]) -> (FROM, ([TOs], 1.0))
    (A,[C, D]),   -> (A,([C, D],1.0)),
    (B,[A]),      -> (B,([A],1.0)),
    (C,[A]),      -> (C,([A],1.0)),
    (D,[B, C])    -> (D,([B, C],1.0))
     */
    static class CustomFunction implements Function<Iterable<String>, Tuple2<String, Double>> {
        @Override
        public Tuple2<String, Double> call(Iterable<String> v) throws Exception {
            return new Tuple2<>(v.toString(), 1.0);
        }
    }
}
