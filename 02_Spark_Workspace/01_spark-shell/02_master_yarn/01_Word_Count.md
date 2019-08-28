# Ref
```
http://spark.apache.org/examples.html
```

# spark-shell
```{bash}
$ spark-shell --master yarn --deploy-mode client
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
Spark context Web UI available at http://SparkNode:4040
Spark context available as 'sc' (master = yarn, app id = application_1527756226975_0002).
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

scala>
```

# Word Count
```{scala}
scala> val textFile = sc.textFile("hdfs:///user/hadoop/input/")

scala> val counts = textFile.flatMap(line => line.split(" ")).map(word => (word.toLowerCase, 1)).reduceByKey(_ + _).sortByKey()
counts: org.apache.spark.rdd.RDD[(String, Int)] = ShuffledRDD[7] at sortByKey at <console>:25

scala> counts.saveAsTextFile("hdfs:///user/hadoop/output2")

scala> :quit

hadoop@SparkNode:~$ hdfs dfs -ls /user/hadoop/output2
Found 3 items
-rw-r--r--   2 hadoop supergroup          0 2018-05-31 17:51 /user/hadoop/output2/_SUCCESS
-rw-r--r--   2 hadoop supergroup      25378 2018-05-31 17:51 /user/hadoop/output2/part-00000
-rw-r--r--   2 hadoop supergroup      43527 2018-05-31 17:51 /user/hadoop/output2/part-00001

hadoop@SparkNode:~$ hdfs dfs -cat /user/hadoop/output2/part-00000 | head
(,2244)
(#11],1)
($5,000),1)
(($1,1)
((801),1)
((a,1)
((a),1)
((alice,4)
((and,2)
((and,,1)
cat: Unable to write to output stream.
```
