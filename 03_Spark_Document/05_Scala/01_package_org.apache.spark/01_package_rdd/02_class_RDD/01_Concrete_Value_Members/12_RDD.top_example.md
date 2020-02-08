```
scala> val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10), 3)
rddA: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[Int] = Array(1, 2, 3, 2, 3, 10)                                     

scala> rddA.top(3)
res1: Array[Int] = Array(10, 3, 3)

scala> implicit val stringOrdering = new Ordering[Int] {
     | override def compare(x: Int, y: Int): Int = x.toString.compareTo(y.toString)
     | }
StringOrdering: Ordering[Int] = $anon$1@39b704f7

scala> rddA.top(3)(stringOrdering)
res2: Array[Int] = Array(3, 3, 2)
```
