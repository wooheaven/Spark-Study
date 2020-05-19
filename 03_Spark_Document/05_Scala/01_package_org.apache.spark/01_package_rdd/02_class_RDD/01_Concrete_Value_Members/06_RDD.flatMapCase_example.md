```
scala> val rddA = sc.parallelize(List(("A",List("C","D")),("C", List("A")),("D",List("B","C")),("B", List("A"))))
rddA: org.apache.spark.rdd.RDD[(String, List[String])] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[(String, List[String])] = Array((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val rddB = rddA.mapValues(v => 1.0)
rddB: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[1] at mapValues at <console>:25

scala> rddB.collect()
res1: Array[(String, Double)] = Array((A,1.0), (C,1.0), (D,1.0), (B,1.0))

scala> val rddC = rddA.join(rddB)
rddC: org.apache.spark.rdd.RDD[(String, (List[String], Double))] = MapPartitionsRDD[4] at join at <console>:27

scala> rddC.collect()
res2: Array[(String, (List[String], Double))] = Array((B,(List(A),1.0)), (D,(List(B, C),1.0)), (A,(List(C, D),1.0)), (C,(List(A),1.0)))

scala> val rddD = rddC.flatMap{ case (url, (links, rank)) => links.map(dest => (dest, rank / links.size)) }
rddD: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[5] at flatMap at <console>:25

scala> rddD.collect()
res3: Array[(String, Double)] = Array((A,1.0), (B,0.5), (C,0.5), (C,0.5), (D,0.5), (A,1.0))
```
