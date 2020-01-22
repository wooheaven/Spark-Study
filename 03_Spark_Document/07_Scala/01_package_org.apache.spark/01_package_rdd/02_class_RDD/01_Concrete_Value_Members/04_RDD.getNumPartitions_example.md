```
scala> val rddA = sc.parallelize(Array(1, 2, 3), 2)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.glom().collect()
res0: Array[Array[Int]] = Array(Array(1), Array(2, 3))

scala> rddA.getNumPartitions
res2: Int = 2
```
