package rwoo.study.spark;

import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapToDoubleTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "FlatMapToDouble");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testFlatMapToDouble() {
        // input
        List<Tuple2<Double, Double>> input = new ArrayList<Tuple2<Double, Double>>();
        input.add(new Tuple2<Double, Double>(1.0, 11.0));
        input.add(new Tuple2<Double, Double>(2.0, 22.0));
        input.add(new Tuple2<Double, Double>(3.0, 33.0));
        JavaPairRDD<Double, Double> inputRDD = sc.parallelizePairs(input);

        // run
        JavaDoubleRDD mapRDD = inputRDD.mapToDouble(t -> t._1() * t._2());
        System.out.println(mapRDD.collect());

        JavaDoubleRDD flatMapRDD = inputRDD.flatMapToDouble(t -> Arrays.asList(t._1(), t._2()).iterator());
        System.out.println(flatMapRDD.collect());
    }
}
