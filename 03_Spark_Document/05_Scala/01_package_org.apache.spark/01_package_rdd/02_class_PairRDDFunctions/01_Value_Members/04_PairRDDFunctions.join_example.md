```
scala> val rddLeft = sc.parallelize(List(("A",2),("B",2)))
rddLeft: org.apache.spark.rdd.RDD[(String, Int)] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddLeft.collect()
res0: Array[(String, Int)] = Array((A,2), (B,2))

scala> val rddRight = sc.parallelize(List(("B",3),("C",3)))
rddRight: org.apache.spark.rdd.RDD[(String, Int)] = ParallelCollectionRDD[1] at parallelize at <console>:24

scala> rddRight.collect()
res1: Array[(String, Int)] = Array((B,3), (C,3))

scala> rddLeft.join(rddRight).collect()
res2: Array[(String, (Int, Int))] = Array((B,(2,3)))

scala> rddLeft.leftOuterJoin(rddRight).collect()
res3: Array[(String, (Int, Option[Int]))] = Array((B,(2,Some(3))), (A,(2,None)))

scala> rddLeft.rightOuterJoin(rddRight).collect()
res4: Array[(String, (Option[Int], Int))] = Array((B,(Some(2),3)), (C,(None,3)))

scala> rddLeft.fullOuterJoin(rddRight).collect
res5: Array[(String, (Option[Int], Option[Int]))] = Array((B,(Some(2),Some(3))), (A,(Some(2),None)), (C,(None,Some(3))))
```
