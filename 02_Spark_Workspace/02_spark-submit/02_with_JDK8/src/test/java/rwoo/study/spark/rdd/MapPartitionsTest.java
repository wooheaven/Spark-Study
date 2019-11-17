package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.flatmapfunction.CustomFlatMapFunction;

import java.util.ArrayList;
import java.util.List;

public class MapPartitionsTest {
    private JavaSparkContext sc;
    private List<Integer> inputList;
    private JavaRDD<Integer> inputRDD;
    private JavaRDD<Integer> outputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("MapTest"));
        inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        inputList.add(6);
        inputList.add(7);
        inputRDD = sc.parallelize(inputList, 3);
        System.out.println(inputRDD.glom().collect());
//      [[1, 2], [3, 4], [5, 6, 7]]
    }

    @After
    public void after() {
        System.out.println(outputRDD.glom().collect());
//      [[3], [7], [18]]
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
