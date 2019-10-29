package rwoo.study.spark.pairrdd;

import org.apache.spark.HashPartitioner;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.partitioner.CustomPartitioner;
import scala.Tuple2;

import java.io.Serializable;

public class PartitionByTest implements Serializable {
    private JavaSparkContext sc;
    private JavaRDD<String> lines;
    private JavaPairRDD<String, Iterable<String>> links;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("PartitionByTest")
                .set("spark.driver.allowMultipleContexts", "true"));
        lines = sc.textFile("src/test/resources/input/PartitionByTest/");
        lines.foreach(v -> System.out.println(v));
//        A C
//        C A
//        A D
//        D B
//        B A
//        D C
    }

    @After
    public void after() {
        links.glom().foreach(v -> System.out.println(v));
//        [(A,[C, D]), (C,[A])]
//        [(B,[A]), (D,[B, C])]
//
//        [(A,[C, D])]
//        [(B,[A])]
//        [(D,[B, C])]
//        [(C,[A])]
        sc.close();
    }

    @Test
    public void test_without_PartitionBy() {
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey();
    }

    @Test
    public void test_with_PartitionBy_HashPartitioner() {
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().partitionBy(new HashPartitioner(4));
    }

    @Test
    public void test_with_PartitionBy_CustomPartitioner() {
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().partitionBy(new CustomPartitioner(4));
    }
}
