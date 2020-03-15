```
scala> val a = sc.parallelize(Array(1, 3, 5))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val b = sc.parallelize(Array(2, 4, 6))
b: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[1] at parallelize at <console>:24

scala> val c = a.union(b)
c: org.apache.spark.rdd.RDD[Int] = UnionRDD[2] at union at <console>:27

scala> c.collect()
res0: Array[Int] = Array(1, 3, 5, 2, 4, 6)
```
