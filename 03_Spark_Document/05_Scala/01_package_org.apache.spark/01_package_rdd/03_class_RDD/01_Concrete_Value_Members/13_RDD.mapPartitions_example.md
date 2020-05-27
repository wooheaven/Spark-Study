```
scala> val rddA = sc.parallelize(Array(1,2,3,4,5,6,7),3)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val rddB = rddA.mapPartitions(iter => List(iter.sum).iterator)
rddB: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[1] at mapPartitions at <console>:25

scala> rddA.glom.collect
res0: Array[Array[Int]] = Array(Array(1, 2), Array(3, 4), Array(5, 6, 7))

scala> rddB.glom.collect
res1: Array[Array[Int]] = Array(Array(3), Array(7), Array(18))
```
