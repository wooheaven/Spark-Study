```
scala> val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10), 3)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[Int] = Array(1, 2, 3, 2, 3, 10)

scala> rddA.take(4)
res1: Array[Int] = Array(1, 2, 3, 2)
```
