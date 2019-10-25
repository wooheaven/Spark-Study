```
scala> val links_list = List( ("A", 1.0), ("B", 2.0), ("C", 3.0), ("A", 4.0) )
links_list: List[(String, Double)] = List((A,1.0), (B,2.0), (C,3.0), (A,4.0))

scala> val links = sc.parallelize(links_list)
links: org.apache.spark.rdd.RDD[(String, Double)] = ParallelCollectionRDD[0] at parallelize at <console>:26

scala> val result = links.reduceByKey((x,y) => x+y)
result: org.apache.spark.rdd.RDD[(String, Double)] = ShuffledRDD[1] at reduceByKey at <console>:25

scala> result.collect
res0: Array[(String, Double)] = Array((B,2.0), (A,5.0), (C,3.0))
```
