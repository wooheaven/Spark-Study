```
scala> val a = sc.parallelize(Array(1, 2, 3, 2))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val b = a.distinct()
b: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[3] at distinct at <console>:25

scala> a.collect()
res0: Array[Int] = Array(1, 2, 3, 2)

scala> b.collect()
res1: Array[Int] = Array(2, 1, 3)
```
