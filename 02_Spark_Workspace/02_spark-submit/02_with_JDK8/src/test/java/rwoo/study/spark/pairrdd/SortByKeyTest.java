package rwoo.study.spark.pairrdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class SortByKeyTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, String> rddA;
    private JavaPairRDD<String, String> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaPairRDD.sortByKey");
        rddA = sc.textFile("src/test/resources/input/SortByKeyTest/")
                .mapToPair(line -> {
                    String[] fields = line.split(" ");
                    return new Tuple2<>(fields[0], fields[1]);
                });
    }

    @After
    public void after() {
        assertEquals("[(b,1), (E,4), (a,2), (c,3), (D,3)]", rddA.collect().toString());
        assertEquals("[(a,2), (b,1), (c,3), (D,3), (E,4)]", rddB.collect().toString());
        sc.close();
    }

    @Test
    public void test_SortByKey_with_CustomComparator() {
        rddB = rddA.sortByKey(new CustomComparatorLowerCase(), true, 3);
    }

    static class CustomComparatorLowerCase implements Comparator<String>, Serializable {
        @Override
        public int compare(String o1, String o2) {
            return o1.toLowerCase().compareTo(o2.toLowerCase());
        }
    }
}
