```
scala> val rddA = sc.parallelize(Array("John", "Fred", "Anna", "James"))
rddA: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[String] = Array(John, Fred, Anna, James)

scala> val rddB = rddA.keyBy(x => x.charAt(0))
rddB: org.apache.spark.rdd.RDD[(Char, String)] = MapPartitionsRDD[1] at keyBy at <console>:25

scala> rddB.collect()
res1: Array[(Char, String)] = Array((J,John), (F,Fred), (A,Anna), (J,James))
```
