package rwoo.study.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JoinTest implements Serializable {
    private JavaSparkContext sc;
    private List<Tuple2<String, Integer>> left = new ArrayList<>();
    private List<Tuple2<String, Integer>> right = new ArrayList<>();
    private JavaPairRDD<String, Integer> leftRdd;
    private JavaPairRDD<String, Integer> rightRdd;

    @Before
    public void setUp() {
        left.add(new Tuple2<>("A", 2));
        left.add(new Tuple2<>("B", 2));
        left.add(new Tuple2<>("C", 2));
        left.add(new Tuple2<>("D", 2));
        left.add(new Tuple2<>("E", 2));

        right.add(new Tuple2<>("C", 3));
        right.add(new Tuple2<>("D", 3));
        right.add(new Tuple2<>("E", 3));
        right.add(new Tuple2<>("F", 3));

        // JavaSparkContext
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("Join")
                .set("spark.driver.allowMultipleContexts", "true"));

        // input JavaPairRDD
        leftRdd = sc.parallelizePairs(left);
        rightRdd = sc.parallelizePairs(right);
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testJoin() {
        // join
        JavaPairRDD<String, Tuple2<Integer, Integer>> join = leftRdd.join(rightRdd);

        // print
        for (Tuple2<String, Tuple2<Integer, Integer>> myTuple : join.collect()) {
            System.out.println(myTuple);
        }
    }

    @Test
    public void testLeftOuterJoin() {
        // left outer join
        JavaPairRDD<String, Tuple2<Integer, Optional<Integer>>> leftJoin = leftRdd.leftOuterJoin(rightRdd);

        // print
        for (Tuple2<String, Tuple2<Integer, Optional<Integer>>> myTuple : leftJoin.collect()) {
            System.out.println(myTuple);
        }
    }

    @Test
    public void testRightOuterJoin() {
        // right outer join
        JavaPairRDD<String, Tuple2<Optional<Integer>, Integer>> rightJoin = leftRdd.rightOuterJoin(rightRdd);

        // print
        for (Tuple2<String, Tuple2<Optional<Integer>, Integer>> myTuple : rightJoin.collect()) {
            System.out.println(myTuple);
        }
    }

    @Test
    public void testFullOuterJoin() {
        // full outer join
        JavaPairRDD<String, Tuple2<Optional<Integer>, Optional<Integer>>> fullOuterJoin = leftRdd.fullOuterJoin(rightRdd);

        // print
        for (Tuple2<String, Tuple2<Optional<Integer>, Optional<Integer>>> myTuple : fullOuterJoin.collect()) {
            System.out.println(myTuple);
        }
    }
}
