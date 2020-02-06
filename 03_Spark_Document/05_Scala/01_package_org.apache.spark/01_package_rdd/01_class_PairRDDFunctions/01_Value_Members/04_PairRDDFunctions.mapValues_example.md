```
scala> val rddA = sc.parallelize(List(("A",List("C","D")),("C",List("A")),("D",List("B","C")),("B",List("A"))))
rddA: org.apache.spark.rdd.RDD[(String, List[String])] = ParallelCollectionRDD[1] at parallelize at <console>:24

scala> val rddB = rddA.mapValues(x => 1.0)
rddB: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[2] at mapValues at <console>:25

scala> rddA.collect()
res0: Array[(String, List[String])] = Array((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> rddB.collect()
res1: Array[(String, Double)] = Array((A,1.0), (C,1.0), (D,1.0), (B,1.0))
```
