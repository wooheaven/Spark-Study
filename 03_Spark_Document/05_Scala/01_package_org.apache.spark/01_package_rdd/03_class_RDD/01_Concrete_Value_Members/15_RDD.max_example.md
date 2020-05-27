```
scala> val a = sc.parallelize(Array(2, 4, 10))
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a.max()
res0: Int = 10

scala> a.max()(ord= new Ordering[Int]() {
     |   override def compare(x: Int, y: Int): Int = {
     |     Ordering[String].compare(x.toString, y.toString)
     |   }
     | })
res1: Int = 4
```
