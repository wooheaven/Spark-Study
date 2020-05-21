```
scala> val l = sc.parallelize(List(1,2,3))
l: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val result = l.map(v => List(v-1,v,v+1)).cache()
result: org.apache.spark.rdd.RDD[List[Int]] = MapPartitionsRDD[1] at map at <console>:25

scala> result.collect()
[Stage 0:===========================================================(2 + 0) / 2]res0: Array[List[Int]] = Array(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4))
```
