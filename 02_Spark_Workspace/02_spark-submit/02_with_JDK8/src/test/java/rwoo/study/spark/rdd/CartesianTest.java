package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartesianTest {
    private JavaSparkContext sc;
    private List<String> inputList;
    private JavaRDD<String> inputHead;
    private JavaRDD<String> inputTail;
    private JavaPairRDD<String, String> outputRDD;

    @Before
    public void setUp() {
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("Cartesian"));
        inputList = new ArrayList<>();
        inputList.add("b");
        inputList.add("a");
        inputList.add("c");
        inputHead = sc.parallelize(inputList);
        inputList = new ArrayList<>();
        inputList.add("1");
        inputList.add("2");
        inputTail = sc.parallelize(inputList);
    }

    @After
    public void after() {
        assertEquals("[b, a, c]", inputHead.collect().toString());
        assertEquals("[1, 2]", inputTail.collect().toString());
        assertEquals("[(b,1), (b,2), (a,1), (a,2), (c,1), (c,2)]", outputRDD.collect().toString());
        sc.close();
    }

    @Test
    public void testCartesian() {
        outputRDD = inputHead.cartesian(inputTail);
    }
}
