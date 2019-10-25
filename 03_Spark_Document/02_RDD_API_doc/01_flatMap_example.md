```
scala> val l = sc.parallelize(List(1,2,3))
l: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[2] at parallelize at <console>:24

scala> val result = l.flatMap(v => List(v-1,v,v+1))
result: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[4] at flatMap at <console>:25

scala> result.collect
res2: Array[Int] = Array(0, 1, 2, 1, 2, 3, 2, 3, 4)
```
