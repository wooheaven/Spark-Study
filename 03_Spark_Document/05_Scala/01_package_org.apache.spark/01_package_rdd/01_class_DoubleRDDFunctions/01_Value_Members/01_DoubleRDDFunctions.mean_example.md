```
scala> val a = sc.parallelize(Array(2, 4, 10))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a.mean()
res3: Double = 5.333333333333333
```
