package rwoo.study.spark.pairrdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import static org.junit.Assert.assertEquals;

public class FlatMapValuesTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, String> rddA;
    private JavaPairRDD<String, Iterable<String>> rddB;
    private JavaPairRDD<String, String> rddC;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaPairRDD.flatMapValues");
        rddA = sc.textFile("src/test/resources/input/MapToPairTest/")
                .mapToPair(line -> {
                    String[] parts = line.split(" ");
                    return new Tuple2<>(parts[0], parts[1]);
                });
        rddB = rddA.groupByKey();
    }

    @After
    public void after() {
        assertEquals("[(A,C), (A,D), (B,A), (C,A), (D,B), (D,C)]", rddA.collect().toString());
        assertEquals("[(A,[C, D]), (B,[A]), (C,[A]), (D,[B, C])]", rddB.sortByKey().collect().toString());
        assertEquals("[(A,C), (A,D), (B,A), (C,A), (D,B), (D,C)]", rddC.sortByKey().collect().toString());
        sc.close();
    }

    @Test
    public void testFlatMapValues() {
        rddC = rddB.flatMapValues(x -> x);
    }
}
