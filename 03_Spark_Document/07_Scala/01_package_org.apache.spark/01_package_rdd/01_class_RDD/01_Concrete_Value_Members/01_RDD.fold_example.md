```
scala> val rddA = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

scala> rddA.fold(0)(_ + _)
res1: Int = 45
```
