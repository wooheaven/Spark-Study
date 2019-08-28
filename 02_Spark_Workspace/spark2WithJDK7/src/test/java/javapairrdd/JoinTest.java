package javapairrdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JoinTest implements Serializable {
    private List<Tuple2<String, Integer>> left = new ArrayList<Tuple2<String, Integer>>();
    private List<Tuple2<String, Integer>> right = new ArrayList<Tuple2<String, Integer>>();

    @Before
    public void setUp() {
        left.add(new Tuple2<String, Integer>("A", 2));
        left.add(new Tuple2<String, Integer>("B", 2));
        left.add(new Tuple2<String, Integer>("C", 2));
        left.add(new Tuple2<String, Integer>("D", 2));
        left.add(new Tuple2<String, Integer>("E", 2));

        right.add(new Tuple2<String, Integer>("B", 3));
        right.add(new Tuple2<String, Integer>("C", 3));
        right.add(new Tuple2<String, Integer>("D", 3));
        right.add(new Tuple2<String, Integer>("F", 3));
    }

    @Test
    public void testJoin() {
        // JavaSparkContext
        JavaSparkContext sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("Join")
                .set("spark.driver.allowMultipleContexts", "true"));

        // input JavaPairRDD
        JavaPairRDD<String, Integer> leftRdd = sc.parallelizePairs(left);
        JavaPairRDD<String, Integer> rightRdd = sc.parallelizePairs(right);

        // join
        JavaPairRDD<String, Tuple2<Integer, Integer>> join = leftRdd.join(rightRdd);
        JavaPairRDD<String, Integer> joinResult = join.mapValues(new Function<Tuple2<Integer, Integer>, Integer>() {
            @Override
            public Integer call(Tuple2<Integer, Integer> t) throws Exception {
                return t._1() + t._2();
            }
        });
        joinResult.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> t) throws Exception {
                System.out.println(t._1() + " " + t._2());
            }
        });
    }

    @Test
    public void testLeftOuterJoin() {
        // JavaSparkContext
        JavaSparkContext sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("LeftOuterJoin")
                .set("spark.driver.allowMultipleContexts", "true"));

        // input JavaPairRDD
        JavaPairRDD<String, Integer> leftRdd = sc.parallelizePairs(left);
        JavaPairRDD<String, Integer> rightRdd = sc.parallelizePairs(right);

        // left outer join
        JavaPairRDD<String, Tuple2<Integer, Optional<Integer>>> leftJoin = leftRdd.leftOuterJoin(rightRdd);
        JavaPairRDD<String, Integer> leftJoinResult = leftJoin.mapValues(new Function<Tuple2<Integer, Optional<Integer>>, Integer>() {
            @Override
            public Integer call(Tuple2<Integer, Optional<Integer>> v1) throws Exception {
                return v1._2().or(v1._1());
            }
        });
        leftJoinResult.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> t) throws Exception {
                System.out.println(t._1() + " " + t._2());
            }
        });
    }

    @Test
    public void testRightOuterJoin() {
        // JavaSparkContext
        JavaSparkContext sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("RightOuterJoin")
                .set("spark.driver.allowMultipleContexts", "true"));

        // input JavaPairRDD
        JavaPairRDD<String, Integer> leftRdd = sc.parallelizePairs(left);
        JavaPairRDD<String, Integer> rightRdd = sc.parallelizePairs(right);

        // right outer join
        JavaPairRDD<String, Tuple2<Optional<Integer>, Integer>> rightJoin = leftRdd.rightOuterJoin(rightRdd);
        JavaPairRDD<String, Integer> rightJoinResult = rightJoin.mapValues(new Function<Tuple2<Optional<Integer>, Integer>, Integer>() {
            @Override
            public Integer call(Tuple2<Optional<Integer>, Integer> v) throws Exception {
                return v._1().or(v._2());
            }
        });
        rightJoinResult.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> t) throws Exception {
                System.out.println(t._1() + " " + t._2());
            }
        });
    }

    @Test
    public void testFullOuterJoin() {
        // JavaSparkContext
        JavaSparkContext sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("FullOuterJoin")
                .set("spark.driver.allowMultipleContexts", "true"));

        // input JavaPairRDD
        JavaPairRDD<String, Integer> leftRdd = sc.parallelizePairs(left);
        JavaPairRDD<String, Integer> rightRdd = sc.parallelizePairs(right);

        // full outer join
        JavaPairRDD<String, Tuple2<Optional<Integer>, Optional<Integer>>> fullOuterJoin = leftRdd.fullOuterJoin(rightRdd);
        JavaPairRDD<String, Integer> fullOuterJoinResult = fullOuterJoin.mapValues(new Function<Tuple2<Optional<Integer>, Optional<Integer>>, Integer>() {
            @Override
            public Integer call(Tuple2<Optional<Integer>, Optional<Integer>> t) throws Exception {
                Integer sum = 0;
                if (t._1().isPresent()) {
                    sum += t._1().get();
                }
                if (t._2().isPresent()) {
                    sum += t._2().get();
                }
                return sum;
            }
        });
        fullOuterJoinResult.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> t) throws Exception {
                System.out.println(t._1() + " " + t._2());
            }
        });
    }
}