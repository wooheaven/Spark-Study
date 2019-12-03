package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.function.CustomFunction2IndexSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapPartitionsWithIndexTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("MapTest"));
        rddA = sc.parallelize(Arrays.asList("1", "2", "3", "4", "5", "6", "7"), 3);
    }

    @After
    public void after() {
        assertEquals("[[1, 2], [3, 4], [5, 6, 7]]", rddA.glom().collect().toString());
        assertEquals("[[0 : 3], [1 : 7], [2 : 18]]", rddB.glom().collect().toString());
        sc.close();
    }

    @Test
    public void testMapPartitions_with_Implicit() {
        rddB = rddA.mapPartitionsWithIndex((index, partition) -> {
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
    public void testMapPartitions_with_Explicit() {
        Function2<Integer, Iterator<String>, Iterator<String>> f = (index, partition) -> {
            int sum = 0;
            while (partition.hasNext()) {
                sum += Integer.parseInt(partition.next());
            }
            List<String> partitionSum = new ArrayList<>();
            partitionSum.add(index + " : " + sum);
            return partitionSum.iterator();
        };
        rddB = rddA.mapPartitionsWithIndex(f, false);
    }

    @Test
    public void testMapPartitions_with_CustomFunction2IndexSum() {
        rddB = rddA.mapPartitionsWithIndex(new CustomFunction2IndexSum(), false);
    }
}
