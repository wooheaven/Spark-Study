```
scala> val links_list = List(("A",List("C","D")),("C", List("A")),("D",List("B","C")),("B", List("A")))
links_list: List[(String, List[String])] = List((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val links = sc.parallelize(links_list)
links: org.apache.spark.rdd.RDD[(String, List[String])] = ParallelCollectionRDD[0] at parallelize at <console>:26

scala> val ranks = links.mapValues(v=> 1.0)
ranks: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[1] at mapValues at <console>:25

scala> links.collect
res2: Array[(String, List[String])] = Array((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> ranks.collect
res0: Array[(String, Double)] = Array((A,1.0), (C,1.0), (D,1.0), (B,1.0))

scala> val join_result = links.join(ranks)
join_result: org.apache.spark.rdd.RDD[(String, (List[String], Double))] = MapPartitionsRDD[4] at join at <console>:27

scala> join_result.collect
res1: Array[(String, (List[String], Double))] = Array((B,(List(A),1.0)), (D,(List(B, C),1.0)), (A,(List(C, D),1.0)), (C,(List(A),1.0)))
```
