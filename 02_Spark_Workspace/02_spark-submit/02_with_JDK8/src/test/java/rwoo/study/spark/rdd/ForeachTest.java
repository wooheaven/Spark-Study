package rwoo.study.spark.rdd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ForeachTest {
    private static final String fileName = "src/test/resources/input/ForeachTest/input.txt";
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;

    private static void deleteContents() throws IOException {
        FileWriter f = new FileWriter(fileName);
        f.write("");
        f.close();
    }

    private static void appendAndPrint(Integer v) throws IOException {
        FileWriter f = new FileWriter(fileName, true);
        f.write("num = " + v + "\n");
        System.out.println("num = " + v);
        f.close();
    }

    @Before
    public void setUp() throws IOException {
        deleteContents();
        sc = new JavaSparkContext("local[*]", "JavaRDD.foreach");
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
        rddA.foreach(new CustomVoidFunction());
    }

    static class CustomVoidFunction implements VoidFunction<Integer> {
        private static void append(Integer v) throws IOException {
            FileWriter f = new FileWriter("src/test/resources/input/ForeachTest/input.txt", true);
            f.write("num = " + v + "\n");
            f.close();
        }

        @Override
        public void call(Integer v) throws Exception {
            append(v);
            System.out.println(v);
        }
    }
}
