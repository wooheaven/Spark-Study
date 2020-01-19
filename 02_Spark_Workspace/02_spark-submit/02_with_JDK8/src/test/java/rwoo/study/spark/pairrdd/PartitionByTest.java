package rwoo.study.spark.pairrdd;

import org.apache.spark.HashPartitioner;
import org.apache.spark.Partitioner;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PartitionByTest {
    private JavaSparkContext sc;
    private JavaRDD<String> rddA;
    private JavaPairRDD<String, Iterable<String>> rddB;

    @Before
    public void setUp() {
        sc = new JavaSparkContext("local[*]", "JavaPairRDD.partitionBy");
        rddA = sc.textFile("src/test/resources/input/PartitionByTest/");
    }

    @After
    public void tearDown() {
        assertEquals(Arrays.asList("A C", "A D", "B A", "C A", "D B", "D C"), rddA.collect());
        sc.close();
    }

    @Test
    public void test_without_PartitionBy() {
        rddB = rddA.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey();
        assertEquals(2, rddB.getNumPartitions());
        assertTrue(customSetAssert(Arrays.asList("[(B,[A]), (D,[B, C])]", "[(A,[C, D]), (C,[A])]"), rddB.glom().collect()));
    }

    @Test
    public void test_with_PartitionBy_HashPartitioner() {
        rddB = rddA.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().partitionBy(new HashPartitioner(3));
        assertEquals(3, rddB.getNumPartitions());
        assertTrue(customSetAssert(Arrays.asList("[(B,[A])]", "[(C,[A])]", "[(D,[B, C]), (A,[C, D])]"), rddB.glom().collect()));
    }

    @Test
    public void test_with_PartitionBy_CustomPartitioner() {
        rddB = rddA.mapToPair(line -> {
            String[] parts = line.split(" ");
            return new Tuple2<String, String>(parts[0], parts[1]);
        }).groupByKey().partitionBy(new CustomPartitioner(3));
        rddB.foreach(tmp -> System.out.println(tmp));
        assertEquals(3, rddB.getNumPartitions());
        assertTrue(customSetAssert(Arrays.asList("[(D,[B, C]), (A,[C, D])]", "[(B,[A])]", "[(C,[A])]"), rddB.glom().collect()));
    }

    private boolean customSetAssert(List<String> list, List<List<Tuple2<String, Iterable<String>>>> collect) {
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

    static class CustomPartitioner extends Partitioner {

        private int numParts;

        public CustomPartitioner(int numParts) {
            this.numParts = numParts;
        }

        @Override
        public int numPartitions() {
            return numParts;
        }

        @Override
        public int getPartition(Object key) {
            int code = key.toString().hashCode() % this.numPartitions();
            if (code < 0) {
                return code + this.numPartitions();
            } else {
                return code;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CustomPartitioner) {
                CustomPartitioner pObj = (CustomPartitioner) obj;
                return pObj.numPartitions() == this.numPartitions();
            } else {
                return false;
            }
        }
    }
}
