```
scala> val links_list = List(("A",List("C","D")),("C", List("A")),("D",List("B","C")),("B", List("A")))
links_list: List[(String, List[String])] = List((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val links = sc.parallelize(links_list)
links: org.apache.spark.rdd.RDD[(String, List[String])] = ParallelCollectionRDD[0] at parallelize at <console>:26

scala> links.collect
res2: Array[(String, List[String])] = Array((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val links_flat = links.flatMapValues(x => x)
links_flat: org.apache.spark.rdd.RDD[(String, String)] = MapPartitionsRDD[13] at flatMapValues at <console>:25

scala> links_flat.collect
res13: Array[(String, String)] = Array((A,C), (A,D), (C,A), (D,B), (D,C), (B,A))

scala> links_flat.groupByKey()
res14: org.apache.spark.rdd.RDD[(String, Iterable[String])] = ShuffledRDD[14] at groupByKey at <console>:26

scala> links_flat.groupByKey().collect
res15: Array[(String, Iterable[String])] = Array((B,CompactBuffer(A)), (D,CompactBuffer(B, C)), (A,CompactBuffer(C, D)), (C,CompactBuffer(A)))
```
