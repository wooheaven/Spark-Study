```
scala> val a = sc.parallelize(Array(2, 4, 10))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a.sum()
res2: Double = 16.0
```
