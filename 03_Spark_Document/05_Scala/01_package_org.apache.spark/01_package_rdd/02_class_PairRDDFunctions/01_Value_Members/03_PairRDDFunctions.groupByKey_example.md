```
scala> val rddA = sc.parallelize(List(("A",List("C","D")),("C", List("A")),("D",List("B","C")),("B", List("A"))))
rddA: org.apache.spark.rdd.RDD[(String, List[String])] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[(String, List[String])] = Array((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val rddB = rddA.flatMapValues(x => x)
rddB: org.apache.spark.rdd.RDD[(String, String)] = MapPartitionsRDD[1] at flatMapValues at <console>:25

scala> rddB.collect()
res1: Array[(String, String)] = Array((A,C), (A,D), (C,A), (D,B), (D,C), (B,A))

scala> val rddC = rddB.groupByKey()
rddC: org.apache.spark.rdd.RDD[(String, Iterable[String])] = ShuffledRDD[2] at groupByKey at <console>:25

scala> rddC.collect()
res2: Array[(String, Iterable[String])] = Array((B,CompactBuffer(A)), (D,CompactBuffer(B, C)), (A,CompactBuffer(C, D)), (C,CompactBuffer(A)))
```
