# Ref
```
http://spark.apache.org/examples.html
http://www.itversity.com/topic/spark-context-and-spark-configuration/
```

# spark-shell
```{bash}
$ spark-shell --master spark://BISTel.Research.Dev.SparkNode:7077 --deploy-mode client
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
Spark context Web UI available at http://BISTel.Research.Dev.ClientNode:4040
Spark context available as 'sc' (master = spark://BISTel.Research.Dev.SparkNode:7077, app id = app-20180523115816-0001).
Spark session available as 'spark'.
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.3.0
      /_/

Using Scala version 2.11.8 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_171)
Type in expressions to have them evaluated.
Type :help for more information.
```

# Word Count
```{scala}
scala> import org.apache.hadoop.fs._
import org.apache.hadoop.fs._

scala> val hdfs = FileSystem.get(sc.hadoopConfiguration)
hdfs: org.apache.hadoop.fs.FileSystem = DFS[DFSClient[clientName=DFSClient_NONMAPREDUCE_103117446_1, ugi=research (auth:SIMPLE)]]

scala> hdfs.exists(new Path("hdfs:///user/research/input"))
res1: Boolean = true

scala> hdfs.exists(new Path("hdfs:///user/research/output"))
res2: Boolean = true

scala> hdfs.delete(new Path("hdfs:///user/research/output"))
warning: there was one deprecation warning; re-run with -deprecation for details
res3: Boolean = true

scala> hdfs.exists(new Path("hdfs:///user/research/output"))
res4: Boolean = false

scala> val textFile = sc.textFile("hdfs:///user/research/input/")
textFile: org.apache.spark.rdd.RDD[String] = hdfs:///user/research/input/ MapPartitionsRDD[1] at textFile at <console>:27

scala> textFile.collect()
res5: Array[String] = Array(i am a boy, you are a girl)

scala> val counts = textFile.flatMap(line => line.split(" ")).map(word => (word.toLowerCase, 1)).reduceByKey(_ + _).sortByKey()
counts: org.apache.spark.rdd.RDD[(String, Int)] = ShuffledRDD[7] at sortByKey at <console>:28

scala> counts.collect()
res6: Array[(String, Int)] = Array((a,2), (am,1), (are,1), (boy,1), (girl,1), (i,1), (you,1))

scala> counts.saveAsTextFile("hdfs:///user/research/output")
```
