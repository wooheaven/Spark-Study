```
scala> val x = sc.parallelize(Array(1,2,3))
x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val y = x.map(n=>n*n)
y: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[1] at map at <console>:25

scala> val z = x.zip(y)
z: org.apache.spark.rdd.RDD[(Int, Int)] = ZippedPartitionsRDD2[2] at zip at <console>:27

scala> x.collect()
res0: Array[Int] = Array(1, 2, 3)

scala> y.collect()
res1: Array[Int] = Array(1, 4, 9)

scala> z.collect()
res2: Array[(Int, Int)] = Array((1,1), (2,4), (3,9))
```
