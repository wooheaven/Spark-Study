package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.voidfunction.CustomVoidfunctionAppendPrint;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ForeachTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;

    private static void deleteContents() throws IOException {
        FileWriter f = new FileWriter("src/test/resources/input/ForeachTest/input.txt");
        f.write("");
        f.close();
    }

    private static void append(Integer v) throws IOException {
        FileWriter f = new FileWriter("src/test/resources/input/ForeachTest/input.txt", true);
        f.write("num = " + v + "\n");
        f.close();
    }

    @Before
    public void setUp() throws IOException {
        deleteContents();
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("JavaRDD.foreachTest"));
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), rddA.collect());
        sc.close();
    }

    @Test
    public void testForeach() {
        rddA.foreach(v -> {
            append(v);
            System.out.println(v);
        });
    }

    @Test
    public void testForeach_with_CustomVoidfunction() {
        rddA.foreach(new CustomVoidfunctionAppendPrint());
    }
}
