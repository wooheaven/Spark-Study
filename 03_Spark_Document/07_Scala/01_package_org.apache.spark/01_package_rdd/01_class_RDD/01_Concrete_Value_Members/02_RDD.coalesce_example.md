```
scala> val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10), 3)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.glom().collect()
res0: Array[Array[Int]] = Array(Array(1, 2), Array(3, 2), Array(3, 10))

scala> rddA.coalesce(2).glom().collect()
res1: Array[Array[Int]] = Array(Array(1, 2), Array(3, 2, 3, 10))
```
