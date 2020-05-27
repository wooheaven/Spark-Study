```
scala> val rddA = sc.parallelize(Array(1,2,3,4,5,6,7), 3)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> def f(partitionIndex:Int, i:Iterator[Int]) = {
     | (partitionIndex, i.sum).productIterator
     | }
f: (partitionIndex: Int, i: Iterator[Int])Iterator[Any]

scala> val rddB = rddA.mapPartitionsWithIndex(f)
rddB: org.apache.spark.rdd.RDD[Any] = MapPartitionsRDD[1] at mapPartitionsWithIndex at <console>:27

scala> val rddC = rddA.mapPartitionsWithIndex(
     | (partitionIndex, iter) => (partitionIndex, iter.sum).productIterator
     | )
rddC: org.apache.spark.rdd.RDD[Any] = MapPartitionsRDD[2] at mapPartitionsWithIndex at <console>:25

scala> rddA.glom.collect
res0: Array[Array[Int]] = Array(Array(1, 2), Array(3, 4), Array(5, 6, 7))

scala> rddB.glom.collect
res1: Array[Array[Any]] = Array(Array(0, 3), Array(1, 7), Array(2, 18))

scala> rddC.glom.collect
res2: Array[Array[Any]] = Array(Array(0, 3), Array(1, 7), Array(2, 18))
```
