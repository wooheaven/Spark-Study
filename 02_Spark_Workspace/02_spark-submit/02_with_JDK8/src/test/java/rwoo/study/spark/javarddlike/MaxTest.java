package rwoo.study.spark.javarddlike;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.spark_project.guava.collect.Ordering;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private Integer max;
    private Integer maxStr;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDDLike.max");
        rddA = sc.parallelize(Arrays.asList(2, 4, 10));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(2, 4, 10), rddA.collect());
        assertEquals(10, max, 0.0);
        assertEquals(4, maxStr, 0.0);
        sc.close();
    }

    @Test
    public void testMax() {
        Object ordering = Ordering.natural();
        final Comparator<Integer> comp = (Comparator<Integer>) ordering;
        max = rddA.max(comp);
//        max = rddA.max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        }); org.apache.spark.SparkException: Task not serializable

        ComparatorStr compStr = new ComparatorStr();
        maxStr = rddA.max(compStr);
//        maxStr = rddA.max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.toString().compareTo(o2.toString());
//            }
//        }); org.apache.spark.SparkException: Task not serializable
    }

    static class ComparatorStr implements Comparator<Integer>, Serializable {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.toString().compareTo(o2.toString());
        }
    }
}
