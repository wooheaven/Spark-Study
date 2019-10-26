package rwoo.study.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class MapToPairTest {
    private JavaSparkContext sc;
    private JavaRDD<String> inputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
            .setMaster("local[*]")
            .setAppName("MapToPairTest"));

        List<String> lines = new ArrayList<>();
        lines.add("A C");
        lines.add("A D");
        lines.add("B A");
        lines.add("C A");
        lines.add("D B");
        lines.add("D C");

        inputRDD = sc.parallelize(lines);
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void test_MapToPair() {
        JavaPairRDD<String, String> outputRDD = inputRDD.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        });
        System.out.println(outputRDD.collect());
    }
}
