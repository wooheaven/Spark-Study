package javapairrdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.junit.Test;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OuterJoinTest implements Serializable {
    @Test
    public void testOuterJoin() {
        JavaSparkContext sc = new JavaSparkContext(new SparkConf().setMaster("local[*]").setAppName("LeftOuterJoin"));
        List<Tuple2<String, Integer>> left = new ArrayList<Tuple2<String, Integer>>();
        left.add(new Tuple2<String, Integer>("A", 2));
        left.add(new Tuple2<String, Integer>("B", 2));
        left.add(new Tuple2<String, Integer>("C", 2));
        left.add(new Tuple2<String, Integer>("D", 2));
        left.add(new Tuple2<String, Integer>("E", 2));

        List<Tuple2<String, Integer>> right = new ArrayList<Tuple2<String, Integer>>();
        right.add(new Tuple2<String, Integer>("B", 3));
        right.add(new Tuple2<String, Integer>("C", 3));
        right.add(new Tuple2<String, Integer>("D", 3));
        right.add(new Tuple2<String, Integer>("F", 3));

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
                System.out.println(t._1 + " " + t._2());
            }
        });
    }
}