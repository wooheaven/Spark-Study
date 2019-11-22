package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.flatmapfunction.CustomFlatMapFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapPartitionsTest {
    private JavaSparkContext sc;
    private List<Integer> inputList;
    private JavaRDD<Integer> inputRDD;
    private JavaRDD<Integer> outputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("MapPartitionsTest"));
        inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        inputRDD = sc.parallelize(inputList, 3);
    }

    @After
    public void after() {
        assertEquals("[[1, 2], [3, 4], [5, 6, 7]]", inputRDD.glom().collect().toString());
        assertEquals("[[3], [7], [18]]", outputRDD.glom().collect().toString());
        sc.close();
    }

    @Test
    public void testMapPartitions_with_Implicit() {
        outputRDD = inputRDD.mapPartitions(partition -> {
            List<Integer> partitionSum = new ArrayList<>();
            int sum = 0;
            while (partition.hasNext()) {
                sum += partition.next();
            }
            partitionSum.add(sum);
            return partitionSum.iterator();
        });
    }

    @Test
    public void testMapPartitions_with_CustomFlatMapFunction() {
        outputRDD = inputRDD.mapPartitions(new CustomFlatMapFunction());
    }
}