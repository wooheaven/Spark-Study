package rwoo.study.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;

import java.util.ArrayList;
import java.util.List;

public class CoGroupTest {
    private JavaSparkContext sc;
    private List<Tuple2<String, String>> list1;
    private List<Tuple2<String, Integer>> list2;
    private List<Tuple2<String, Double>> list3;
    private List<Tuple2<String, Float>> list4;
    private JavaPairRDD<String, String> pairRDD1;
    private JavaPairRDD<String, Integer> pairRDD2;
    private JavaPairRDD<String, Double> pairRDD3;
    private JavaPairRDD<String, Float> pairRDD4;

    @Before
    public void setUp() {
        // JavaSparkContext
        sc = new JavaSparkContext(new SparkConf()
                .setMaster("local[*]")
                .setAppName("CoGroup"));

        list1 = new ArrayList<>();
        list1.add(new Tuple2<>("K1", "ABC"));
        list1.add(new Tuple2<>("K2", "DE"));
        list1.add(new Tuple2<>("K5", "GHI"));
        list1.add(new Tuple2<>("K5", "JKL"));
        pairRDD1 = sc.parallelizePairs(list1);

        list2 = new ArrayList<>();
        list2.add(new Tuple2<>("K1", 123));
        list2.add(new Tuple2<>("K2", 456));
        list2.add(new Tuple2<>("K7", 0));
        pairRDD2 = sc.parallelizePairs(list2);

        list3 = new ArrayList<>();
        list3.add(new Tuple2<>("K1", 777.1));
        list3.add(new Tuple2<>("K2", 999.1));
        list3.add(new Tuple2<>("K8", 10.1));
        pairRDD3 = sc.parallelizePairs(list3);

        list4 = new ArrayList<>();
        list4.add(new Tuple2<>("K1", 1.1f));
        list4.add(new Tuple2<>("K2", 2.1f));
        list4.add(new Tuple2<>("K8", 3.1f));
        pairRDD4 = sc.parallelizePairs(list4);
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testCoGroup() {
        // run CoGroup
        JavaPairRDD<String, Tuple2<Iterable<String>, Iterable<Integer>>> result1 = pairRDD1.cogroup(pairRDD2);
        JavaPairRDD<String, Tuple3<Iterable<String>, Iterable<Integer>, Iterable<Double>>> result2 = pairRDD1.cogroup(pairRDD2, pairRDD3);
        JavaPairRDD<String, Tuple4<Iterable<String>, Iterable<Integer>, Iterable<Double>, Iterable<Float>>> result3 = pairRDD1.cogroup(pairRDD2, pairRDD3, pairRDD4);

        // print
        //[(K7,([],[0])), (K1,([ABC],[123])), (K5,([GHI, JKL],[])), (K2,([DE],[456]))]
        System.out.println(result1.collect());
        //[(K7,([],[0],[])), (K1,([ABC],[123],[777.1])), (K5,([GHI, JKL],[],[])), (K2,([DE],[456],[999.1])), (K8,([],[],[10.1]))]
        System.out.println(result2.collect());
        //[(K7,([],[0],[],[])), (K1,([ABC],[123],[777.1],[1.1])), (K5,([GHI, JKL],[],[],[])), (K2,([DE],[456],[999.1],[2.1])), (K8,([],[],[10.1],[3.1]))]
        System.out.println(result3.collect());
    }
}
