package rwoo.study.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UnionTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "Union");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testReduce() {
        // inputList
        List<String> inputList1 = new ArrayList<>();
        inputList1.add("a");
        inputList1.add("b");
        inputList1.add("c");
        List<String> inputList2 = new ArrayList<>();
        inputList2.add("b");
        inputList2.add("c");
        inputList2.add("1");
        inputList2.add("2");

        // input RDD
        JavaRDD<String> inputRDD1 = sc.parallelize(inputList1);
        JavaRDD<String> inputRDD2 = sc.parallelize(inputList2);

        // run union
        JavaRDD<String> unionRDD = inputRDD1.union(inputRDD2);

        // print
        System.out.println(unionRDD.collect());
        System.out.println(unionRDD.distinct().collect());
    }
}
