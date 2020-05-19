```
scala> val rddA = sc.parallelize(List("I am a boy", "You are a girl"))
rddA: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[String] = Array(I am a boy, You are a girl)

scala> val rddB = rddA.flatMap(line => line.split(" "))
rddB: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[1] at flatMap at <console>:25

scala> rddB.collect()
res1: Array[String] = Array(I, am, a, boy, You, are, a, girl)
```
