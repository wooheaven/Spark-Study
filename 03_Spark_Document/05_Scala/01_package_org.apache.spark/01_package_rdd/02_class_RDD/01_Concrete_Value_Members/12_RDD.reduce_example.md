```
scala> val a = sc.parallelize(Array(1, 2, 3, 4))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a.reduce((x,y) => x+y)
res0: Int = 10

scala> a.reduce((x,y) => x*y)
res1: Int = 24
```
