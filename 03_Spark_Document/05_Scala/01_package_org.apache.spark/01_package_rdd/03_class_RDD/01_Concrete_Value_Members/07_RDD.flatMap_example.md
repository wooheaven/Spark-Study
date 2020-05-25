```
scala> val rddA = sc.parallelize(List("I am a boy", "You are a girl"))
rddA: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddA.collect()
res0: Array[String] = Array(I am a boy, You are a girl)

scala> val rddB = rddA.flatMap(line => line.split(" "))
rddB: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[1] at flatMap at <console>:25

scala> rddB.collect()
res1: Array[String] = Array(I, am, a, boy, You, are, a, girl)

scala> val rddC = sc.parallelize(List(1, 2, 3))
rddC: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> rddC.collect
res2: Array[Int] = Array(1, 2, 3)

scala> val rddD = rddC.flatMap(v => List(v,v+10,v+20))
rddD: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[1] at flatMap at <console>:25

scala> rddD.collect
res3: Array[Int] = Array(1, 11, 21, 2, 12, 22, 3, 13, 23)
```
