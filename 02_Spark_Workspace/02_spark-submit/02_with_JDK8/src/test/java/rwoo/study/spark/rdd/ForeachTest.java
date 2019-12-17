package rwoo.study.spark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.voidfunction.CustomVoidfunctionAppendAndPrintWithElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ForeachTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private static final String fileName = "src/test/resources/input/ForeachTest/input.txt";

    private static void deleteContents() throws IOException {
        FileWriter f = new FileWriter(fileName);
        f.write("");
        f.close();
    }

    private static void appendAndPrint(Integer v) throws IOException {
        FileWriter f = new FileWriter(fileName, true);
        f.write("for each -> element = " + v + "\n");
        System.out.println("for each -> element = " + v);
        f.close();
    }

    @Before
    public void setUp() throws IOException {
        deleteContents();
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("JavaRDD.foreach"));
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), rddA.collect());
        assertEquals(
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(5, 6, 7)
                ), rddA.glom().collect());
        sc.close();
    }

    @Test
    public void testForeach() {
        rddA.foreach(v -> {
            appendAndPrint(v);
        });
    }

    @Test
    public void testForeach_with_CustomVoidfunction() {
        rddA.foreach(new CustomVoidfunctionAppendAndPrintWithElement());
    }
}
