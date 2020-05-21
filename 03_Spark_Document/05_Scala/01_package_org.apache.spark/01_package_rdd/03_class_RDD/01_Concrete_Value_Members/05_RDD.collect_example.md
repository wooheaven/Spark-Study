```
scala> val a = sc.parallelize(List(1,2,3))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a
res0: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a.collect()
res1: Array[Int] = Array(1, 2, 3)
```
