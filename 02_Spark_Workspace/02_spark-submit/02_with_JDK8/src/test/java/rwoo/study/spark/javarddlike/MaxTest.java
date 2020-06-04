package rwoo.study.spark.javarddlike;

import com.google.common.collect.Ordering;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<String> rddB;
    private Integer max;
    private String maxStr;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaRDDLike.max");
        rddA = sc.parallelize(Arrays.asList(2, 4, 10));
        rddB = sc.parallelize(Arrays.asList("2", "4", "10"));
    }

    @After
    public void after() {
        assertEquals(Arrays.asList(2, 4, 10), rddA.collect());
        assertEquals(10, max, 0.0);
        assertEquals("4", maxStr);
        sc.close();
    }

    @Test
    public void testMax_with_Comparator() {
        Object ordering = Ordering.natural();
        final Comparator<Integer> comp = (Comparator<Integer>) ordering;
        max = rddA.max(comp);
//        max = rddA.max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        }); org.apache.spark.SparkException: Task not serializable
        final Comparator<String> comp2 = (Comparator<String>) ordering;
        maxStr = rddB.max(comp2);
    }

    @Test
    public void testMax_with_CustomComparator() {
        CustomComparator customComparator = new CustomComparator();
        max = rddA.max(customComparator);
        CustomComparator2 customComparator2 = new CustomComparator2();
        maxStr = rddB.max(customComparator2);
    }

    private static class CustomComparator implements Comparator<Integer>, Serializable {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    private static class CustomComparator2 implements Comparator<String>, Serializable {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }

    }
}
