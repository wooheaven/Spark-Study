package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.pairfunction.CustomPairFunctionDivideBySpace;
import scala.Tuple2;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MapToPairTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaPairRDD<String, String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("MapToPairTest"));
        rddA = sc.textFile("src/test/resources/input/MapToPairTest/");
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("A C", "A D", "B A", "C A", "D B", "D C"), rddA.collect());
        assertEquals("[(A,C), (A,D), (B,A), (C,A), (D,B), (D,C)]", rddB.collect().toString());
        sc.close();
    }

    @Test
    public void test_MapToPair_with_Implicit() {
        rddB = rddA.mapToPair(v -> {
            String[] fields = v.split(" ");
            return new Tuple2<>(fields[0], fields[1]);
        });
    }

    @Test
    public void test_MapToPair_with_Explicit() {
        PairFunction<String, String, String> f = v -> {
            String[] fields = v.split(" ");
            return new Tuple2<>(fields[0], fields[1]);
        };
        rddB = rddA.mapToPair(f);
    }

    @Test
    public void test_MapToPair_with_CustomPairFunction() {
        rddB = rddA.mapToPair(new CustomPairFunctionDivideBySpace());
    }
}
