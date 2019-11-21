package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.function.CustomFunction2IndexSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapPartitionsWithIndexTest {
    private JavaSparkContext sc;
    private List<String> inputList;
    private JavaRDD<String> inputRDD;
    private JavaRDD<String> outputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("MapTest"));
        inputList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        inputRDD = sc.parallelize(inputList, 3);
    }

    @After
    public void after() {
        assertEquals("[[1, 2], [3, 4], [5, 6, 7]]", inputRDD.glom().collect().toString());
        assertEquals("[[0 : 3], [1 : 7], [2 : 18]]", outputRDD.glom().collect().toString());
        sc.close();
    }

    @Test
    public void testMapPartitions_with_Implicit() {
        outputRDD = inputRDD.mapPartitionsWithIndex((index, partition) -> {
            int sum = 0;
            while (partition.hasNext()) {
                sum += Integer.parseInt(partition.next());
            }
            List<String> partitionSum = new ArrayList<>();
            partitionSum.add(index + " : " + sum);
            return partitionSum.iterator();
        }, false);
    }

    @Test
    public void testMapPartitions_with_CustomFunction2IndexSum() {
        outputRDD = inputRDD.mapPartitionsWithIndex(new CustomFunction2IndexSum(), false);
    }
}
