```
scala> val rddA = sc.parallelize(Array(('J',"James"),('F',"Fred"), ('A', "Anna"), ('J', "John")), 3)
rddA: org.apache.spark.rdd.RDD[(Char, String)] = ParallelCollectionRDD[2] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[(Char, String)] = Array((J,James), (F,Fred), (A,Anna), (J,John))

scala> rddA.glom().collect()
res1: Array[Array[(Char, String)]] = Array(Array((J,James)), Array((F,Fred)), Array((A,Anna), (J,John)))

scala> import org.apache.spark.Partitioner
import org.apache.spark.Partitioner

scala> val rddB = rddA.partitionBy(new Partitioner() {
     |   val numPartitions = 2
     |   def getPartition(k:Any) = {
     |     if (k.asInstanceOf[Char] < 'H') 0 else 1
     |   }
     | })
rddB: org.apache.spark.rdd.RDD[(Char, String)] = ShuffledRDD[3] at partitionBy at <console>:26

scala> rddB.collect()
res2: Array[(Char, String)] = Array((F,Fred), (A,Anna), (J,James), (J,John))

scala> rddB.glom().collect()
res3: Array[Array[(Char, String)]] = Array(Array((F,Fred), (A,Anna)), Array((J,James), (J,John)))

scala> import org.apache.spark.HashPartitioner
import org.apache.spark.HashPartitioner

scala> val rddC = rddA.partitionBy(new HashPartitioner(2))
rddC: org.apache.spark.rdd.RDD[(Char, String)] = ShuffledRDD[1] at partitionBy at <console>:26

scala> rddC.collect
res4: Array[(Char, String)] = Array((J,James), (F,Fred), (J,John), (A,Anna))    

scala> rddC.glom.collect
res5: Array[Array[(Char, String)]] = Array(Array((J,James), (F,Fred), (J,John)), Array((A,Anna)))
```
