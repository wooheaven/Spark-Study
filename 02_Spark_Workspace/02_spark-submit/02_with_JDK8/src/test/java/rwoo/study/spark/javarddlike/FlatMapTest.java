package rwoo.study.spark.javarddlike;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class FlatMapTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaRDD<String> rddB;
    private JavaRDD<Integer> rddC;
    private JavaRDD<Integer> rddD;
    private JavaRDD<Integer> rddE;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDDLike.flatMap");
        rddA = sc.parallelize(Arrays.asList("I am a boy", "You are a girl"));
        rddC = sc.parallelize(Arrays.asList(1, 2, 3));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList("I am a boy", "You are a girl"), rddA.collect());
        assertEquals(Arrays.asList("I", "am", "a", "boy", "You", "are", "a", "girl"), rddB.collect());
        assertEquals(Arrays.asList(1, 2, 3), rddC.collect());
        assertEquals(Arrays.asList(1, 11, 21, 2, 12, 22, 3, 13, 23), rddD.collect());
        assertEquals(Arrays.asList(1, 11, 21, 2, 12, 22, 3, 13, 23), rddE.collect());
        sc.close();
    }

    @Test
    public void testFlatMap() {
        rddB = rddA.flatMap(sentense -> Arrays.asList(sentense.split(" ")).iterator());
        rddD = rddC.flatMap(v -> Arrays.asList(v, v + 10, v + 20).iterator());
//        rddD = rddC.flatMap(new FlatMapFunction<Integer, Integer>() {
//            @Override
//            public Iterator<Integer> call(Integer v) throws Exception {
//                return Arrays.asList(v, v+10, v+20).iterator();
//            }
//        }); // org.apache.spark.SparkException: Task not serializable
        rddE = rddC.flatMap(new customFlatMapFunction());
    }

    private static class customFlatMapFunction implements FlatMapFunction<Integer, Integer> {
        @Override
        public Iterator call(Integer v) throws Exception {
            return Arrays.asList(v, v+10, v+20).iterator();
        }
    }
}
