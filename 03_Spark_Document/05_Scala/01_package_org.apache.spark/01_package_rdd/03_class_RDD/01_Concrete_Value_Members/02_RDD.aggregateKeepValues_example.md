```
scala> val a = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> def initialValue = (Array[Int](), 0)
initialValue: (Array[Int], Int)

scala> def seqOp = (data: (Array[Int], Int), item: Int) => (data._1 :+ item, data._2 + item)
seqOp: ((Array[Int], Int), Int) => (Array[Int], Int)

scala> def combOp = (d1: (Array[Int], Int), d2: (Array[Int], Int)) => (d1._1.union(d2._1), d1._2 + d2._2)
combOp: ((Array[Int], Int), (Array[Int], Int)) => (Array[Int], Int)

scala> val b = a.aggregate(initialValue)(seqOp, combOp)
b: (Array[Int], Int) = (Array(1, 2, 3, 4, 5, 6, 7, 8, 9),45)

scala> a.glom().collect()
res0: Array[Array[Int]] = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))

scala> b
res2: (Array[Int], Int) = (Array(1, 2, 3, 4, 5, 6, 7, 8, 9),45)
```
