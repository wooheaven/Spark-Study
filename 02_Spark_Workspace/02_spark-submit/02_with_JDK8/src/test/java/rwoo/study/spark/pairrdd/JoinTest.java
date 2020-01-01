package rwoo.study.spark.pairrdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JoinTest implements Serializable {
    private JavaSparkContext sc;
    private List<Tuple2<String, Integer>> left = new ArrayList<>();
    private List<Tuple2<String, Integer>> right = new ArrayList<>();
    private JavaPairRDD<String, Integer> leftRdd;
    private JavaPairRDD<String, Integer> rightRdd;
    private JavaPairRDD<String, Tuple2<Integer, Integer>> join;
    private JavaPairRDD<String, Tuple2<Integer, Optional<Integer>>> leftJoin;
    private JavaPairRDD<String, Tuple2<Optional<Integer>, Integer>> rightJoin;
    private JavaPairRDD<String, Tuple2<Optional<Integer>, Optional<Integer>>> fullOuterJoin;

    @Before
    public void setUp() {
        left.add(new Tuple2<>("A", 2));
        left.add(new Tuple2<>("B", 2));
        right.add(new Tuple2<>("B", 3));
        right.add(new Tuple2<>("C", 3));
        sc = new JavaSparkContext("local", "JavaPairRDD.join");
        leftRdd = sc.parallelizePairs(left);
        rightRdd = sc.parallelizePairs(right);
    }

    @After
    public void tearDown() {
        assertEquals("[(A,2), (B,2)]", leftRdd.collect().toString());
        assertEquals("[(B,3), (C,3)]", rightRdd.collect().toString());
        sc.close();
    }

    @Test
    public void test_Join() {
        join = leftRdd.join(rightRdd).sortByKey();
        assertEquals("[(B,(2,3))]", join.collect().toString());
    }

    @Test
    public void test_LeftOuterJoin() {
        leftJoin = leftRdd.leftOuterJoin(rightRdd).sortByKey();
        assertEquals(
                "[(A,(2,Optional.empty)), (B,(2,Optional[3]))]",
                leftJoin.collect().toString());
    }

    @Test
    public void test_RightOuterJoin() {
        rightJoin = leftRdd.rightOuterJoin(rightRdd).sortByKey();
        assertEquals(
                "[(B,(Optional[2],3)), (C,(Optional.empty,3))]",
                rightJoin.collect().toString());
    }

    @Test
    public void test_FullOuterJoin() {
        fullOuterJoin = leftRdd.fullOuterJoin(rightRdd).sortByKey();
        assertEquals(
                "[(A,(Optional[2],Optional.empty)), (B,(Optional[2],Optional[3])), (C,(Optional.empty,Optional[3]))]",
                fullOuterJoin.collect().toString());
    }
}
