package rwoo.study.spark.javapairrdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CountByKeyTest {
    private JavaSparkContext sc;
    private JavaPairRDD<String, String> links;
    private Map<String, Long> ranks;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaPairRDD.countByKey");
        JavaRDD<String> lines = sc.textFile("src/test/resources/input/CountByKeyTest/");
        links = lines.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<>(parts[0], parts[1]);
        }).sortByKey().cache();
    }

    @After
    public void after() {
        assertEquals("[(A,Anna), (F,Fred), (J,James), (J,John)]", links.collect().toString());
        assertEquals("{A=1, F=1, J=2}", ranks.toString());
        sc.close();
    }

    @Test
    public void testCountByKey() {
        ranks = links.countByKey();
    }
}
