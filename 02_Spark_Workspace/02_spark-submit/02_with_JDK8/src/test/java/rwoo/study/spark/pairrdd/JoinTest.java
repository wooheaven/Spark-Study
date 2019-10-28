package rwoo.study.spark.pairrdd;

import org.apache.spark.SparkConf;
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
    public void test_Join() {
        // join
        JavaPairRDD<String, Tuple2<Integer, Integer>> join = leftRdd.join(rightRdd);
        join.foreach(v -> System.out.println(v));
//        (C,(2,3))
//        (D,(2,3))
//        (E,(2,3))
    }

    @Test
    public void test_LeftOuterJoin() {
        // left outer join
        JavaPairRDD<String, Tuple2<Integer, Optional<Integer>>> leftJoin = leftRdd.leftOuterJoin(rightRdd);
        leftJoin.foreach(v -> System.out.println(v));
//        (B,(2,Optional.empty))
//        (D,(2,Optional[3]))
//        (A,(2,Optional.empty))
//        (E,(2,Optional[3]))
//        (C,(2,Optional[3]))
    }

    @Test
    public void test_RightOuterJoin() {
        // right outer join
        JavaPairRDD<String, Tuple2<Optional<Integer>, Integer>> rightJoin = leftRdd.rightOuterJoin(rightRdd);
        rightJoin.foreach(v -> System.out.println(v));
//        (C,(Optional[2],3))
//        (D,(Optional[2],3))
//        (E,(Optional[2],3))
//        (F,(Optional.empty,3))
    }

    @Test
    public void test_FullOuterJoin() {
        // full outer join
        JavaPairRDD<String, Tuple2<Optional<Integer>, Optional<Integer>>> fullOuterJoin = leftRdd.fullOuterJoin(rightRdd);
        fullOuterJoin.foreach(v -> System.out.println(v));
//        (A,(Optional[2],Optional.empty))
//        (F,(Optional.empty,Optional[3]))
//        (B,(Optional[2],Optional.empty))
//        (C,(Optional[2],Optional[3]))
//        (E,(Optional[2],Optional[3]))
//        (D,(Optional[2],Optional[3]))
    }
}
