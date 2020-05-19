```
scala> val a = sc.parallelize(Array(1, 2, 3), 2)
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val b = sc.parallelize(Array(3, 4), 2)
b: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[1] at parallelize at <console>:24

scala> val c = a.union(b)
c: org.apache.spark.rdd.RDD[Int] = UnionRDD[2] at union at <console>:27

scala> a.collect()
res0: Array[Int] = Array(1, 2, 3)

scala> b.collect()
res1: Array[Int] = Array(3, 4)

scala> c.collect()
res2: Array[Int] = Array(1, 2, 3, 3, 4)

scala> a.glom().collect()
res3: Array[Array[Int]] = Array(Array(1), Array(2, 3))

scala> b.glom().collect()
res4: Array[Array[Int]] = Array(Array(3), Array(4))

scala> c.glom().collect()
res5: Array[Array[Int]] = Array(Array(1), Array(2, 3), Array(3), Array(4))
```
