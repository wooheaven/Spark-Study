package rwoo.study.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnToRowsTest {
    private JavaSparkContext sc;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local", "ColumnToRows");
    }

    @After
    public void after() {
        sc.close();
    }

    @Test
    public void testColumnToRows() {
        // input
        JavaRDD<String> linesRDD = sc.parallelize(Arrays.asList("a1\tb11|b12|b13", "a2\tb21|b22|b23"));

        // run
        JavaPairRDD<String, String> twoColumnRDD = linesRDD.mapToPair(line -> {
            String[] lineArray = line.split("\t");
            String key = lineArray[0];
            String value = lineArray[1];
            return  new Tuple2<>(key, value);
        });
        JavaPairRDD<String, String> columnToRowsRDD = twoColumnRDD.flatMapToPair(keyValueTuple -> {
            List<Tuple2<String, String>> myColumnToRows = new ArrayList<>();
            String[] valueArray = keyValueTuple._2().split("\\|");
            for (int i = 0; i < valueArray.length; i++) {
                myColumnToRows.add(new Tuple2<>(keyValueTuple._1(), valueArray[i]));
            }
            return myColumnToRows.iterator();
        });
        System.out.println(columnToRowsRDD.collect());
    }
}