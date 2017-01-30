import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class ListTupleToJavaPairRDDTest {
    private JavaSparkContext sc;
    @Before
    public void setUp() throws Exception {
        sc = new JavaSparkContext(new SparkConf().setMaster("local[*]").setAppName("ListTupleToJavaPairRDD"));
    }

    @Test
    public void testListTupleToJavaPairRDD() {
        List<Tuple2<String, Integer>> list = new ArrayList<Tuple2<String, Integer>>();
        list.add(new Tuple2<String, Integer>("A", 1));
        list.add(new Tuple2<String, Integer>("B", 2));
        list.add(new Tuple2<String, Integer>("C", 3));
        list.add(new Tuple2<String, Integer>("D", 4));
        list.add(new Tuple2<String, Integer>("E", 5));

        JavaPairRDD<String, Integer> pairRdd = sc.parallelizePairs(list);
        System.out.println(pairRdd.collect());
    }
}