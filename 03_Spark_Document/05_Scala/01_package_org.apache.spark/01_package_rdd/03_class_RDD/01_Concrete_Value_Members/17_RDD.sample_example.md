```
scala> val x = sc.parallelize(Array(1,2,3,4,5,6,7,8,9,10))
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val y = x.sample(false, 0.5, 30)
y: org.apache.spark.rdd.RDD[Int] = PartitionwiseSampledRDD[1] at sample at <console>:25

scala> y.collect()
res0: Array[Int] = Array(1, 6, 7, 9, 10)
```
