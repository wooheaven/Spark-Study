```
scala> val rddA = sc.parallelize(Array(('J', "James"), ('F', "Fred"), ('A', "Anna"), ('J', "John")))
rddA: org.apache.spark.rdd.RDD[(Char, String)] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val countDict = rddA.countByKey()
countDict: scala.collection.Map[Char,Long] = Map(J -> 2, F -> 1, A -> 1)
```
