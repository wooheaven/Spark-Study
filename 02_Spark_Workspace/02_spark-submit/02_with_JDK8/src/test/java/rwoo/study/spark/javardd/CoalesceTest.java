package rwoo.study.spark.javardd;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoalesceTest {
    private JavaSparkContext sc;
    private JavaRDD<Integer> rddA;
    private JavaRDD<Integer> rddB;
    private JavaRDD<Integer> rddC;
    private JavaRDD<Integer> rddD;

    @Before
    public void before() {
        sc = new JavaSparkContext("local[*]", "JavaRDD.coalesce");
        rddA = sc.parallelize(Arrays.asList(1, 2, 3, 2, 3, 10), 3);
    }

    @After
    public void after() {
        assertEquals(3, rddA.getNumPartitions());
        assertEquals(2, rddB.getNumPartitions());
        assertEquals(3, rddC.getNumPartitions());
        assertEquals(4, rddD.getNumPartitions());
        assertEquals("[[1, 2], [3, 2], [3, 10]]", rddA.glom().collect().toString());
        assertEquals("[[1, 2], [3, 2, 3, 10]]", rddB.glom().collect().toString());
        assertEquals("[[1, 2], [3, 2], [3, 10]]", rddC.glom().collect().toString());
        assertTrue(customSetAssert(Arrays.asList("[1], [2], [2, 3], [3, 10]"), rddD.glom().collect()));
        sc.close();
    }

    @Test
    public void test_coalesce() {
        rddB = rddA.coalesce(2);
        rddC = rddA.coalesce(4);
        rddD = rddA.repartition(4);
    }

    private boolean customSetAssert(List<String> list, List<List<Integer>> collect) {
        boolean result = true;
        String collectStr = collect.toString();
        for (int i = 0; i < list.size(); i++) {
            if (!collectStr.contains(list.get(i))) {
                result = false;
                break;
            }
        }
        String listStr = list.toString();
        for (int i = 0; i < collect.size(); i++) {
            if (!listStr.contains(collect.get(i).toString())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
