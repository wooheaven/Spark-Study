package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TakeSampleTest {
    private JavaSparkContext sc;
    private List<Integer> inputList;
    private JavaRDD<Integer> inputRDD;
    private List<Integer> outputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("SampleTest"));
        inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        inputRDD = sc.parallelize(inputList);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), inputRDD.collect());
        assertEquals(Arrays.asList(6, 4, 2, 3, 5), outputRDD);
        sc.close();
    }

    @Test
    public void testSample() {
        outputRDD = inputRDD.takeSample(false, 5, 3);
    }
}
