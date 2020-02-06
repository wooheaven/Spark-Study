```
scala> val rddA = sc.parallelize(List(("A",1.0),("B",2.0),("C",3.0),("A",4.0)))
rddA: org.apache.spark.rdd.RDD[(String, Double)] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> val rddB = rddA.reduceByKey((x,y) => x+y)
rddB: org.apache.spark.rdd.RDD[(String, Double)] = ShuffledRDD[1] at reduceByKey at <console>:25

scala> rddA.collect
res0: Array[(String, Double)] = Array((A,1.0), (B,2.0), (C,3.0), (A,4.0))

scala> rddB.collect
res1: Array[(String, Double)] = Array((B,2.0), (A,5.0), (C,3.0))
```
