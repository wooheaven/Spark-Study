# docker run
```
$ cat 02_docker_run.sh 
docker run -it --cpus="4" \
-p 8088:8088 \
-p 18080:18080 \
-p 8042:8042 \
--name spark ubuntu:16.04_4th_spark_yarn
# 8088 Yarn Cluster
# 19888 Yarn HistoryServer
# 18080 Spark HistoryServer
# 8042 Yarn NodeManager

$ ./02_docker_run.sh 
 * Starting OpenBSD Secure Shell server sshd                             [ OK ] 
19/10/22 14:19:16 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Starting namenodes on [localhost]
localhost: starting namenode, logging to /usr/lib/hadoop/hadoop-2.8.5/logs/hadoop-root-namenode-d357da7f302f.out
localhost: starting datanode, logging to /usr/lib/hadoop/hadoop-2.8.5/logs/hadoop-root-datanode-d357da7f302f.out
Starting secondary namenodes [localhost]
localhost: starting secondarynamenode, logging to /usr/lib/hadoop/hadoop-2.8.5/logs/hadoop-root-secondarynamenode-d357da7f302f.out
19/10/22 14:19:31 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
starting yarn daemons
starting resourcemanager, logging to /usr/lib/hadoop/hadoop-2.8.5/logs/yarn--resourcemanager-d357da7f302f.out
localhost: starting nodemanager, logging to /usr/lib/hadoop/hadoop-2.8.5/logs/yarn-root-nodemanager-d357da7f302f.out
starting historyserver, logging to /usr/lib/hadoop/hadoop-2.8.5/logs/mapred--historyserver-d357da7f302f.out
945 JobHistoryServer
710 NodeManager
982 Jps
136 NameNode
445 SecondaryNameNode
271 DataNode
607 ResourceManager

root@d357da7f302f:/# 
```

# spark-shell
```
root@d357da7f302f:~# spark-shell --master yarn --deploy-mode client
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
19/10/23 12:54:02 WARN yarn.Client: Neither spark.yarn.jars nor spark.yarn.archive is set, falling back to uploading libraries under SPARK_HOME.
Spark context Web UI available at http://d357da7f302f:4040
Spark context available as 'sc' (master = yarn, app id = application_1571753973070_0005).
Spark session available as 'spark'.
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.4.4
      /_/
         
Using Scala version 2.11.12 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_221)
Type in expressions to have them evaluated.
Type :help for more information.

scala>
```

# PageRank
```
scala> val links_list = List(("A",List("C","D")),("C", List("A")),("D",List("B","C")),("B", List("A")))
links_list: List[(String, List[String])] = List((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> links_list
res0: List[(String, List[String])] = List((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val links = sc.parallelize(links_list)
links: org.apache.spark.rdd.RDD[(String, List[String])] = ParallelCollectionRDD[0] at parallelize at <console>:26

scala> links.collect
res1: Array[(String, List[String])] = Array((A,List(C, D)), (C,List(A)), (D,List(B, C)), (B,List(A)))

scala> val ranks = links.mapValues(v=> 1.0)
ranks: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[1] at mapValues at <console>:25

scala> ranks.collect
res2: Array[(String, Double)] = Array((A,1.0), (C,1.0), (D,1.0), (B,1.0))

scala> val contributions = links.join(ranks).flatMap { case (url, (links, rank)) => links.map(dest => (dest, rank / links.size)) }
contributions: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[5] at flatMap at <console>:27

scala> contributions.collect
res3: Array[(String, Double)] = Array((A,1.0), (B,0.5), (C,0.5), (C,0.5), (D,0.5), (A,1.0))

scala> val ranks = contributions.reduceByKey((x, y) => x + y).mapValues(v => 0.15 + 0.85*v)
ranks: org.apache.spark.rdd.RDD[(String, Double)] = MapPartitionsRDD[7] at mapValues at <console>:25

scala> ranks.collect
res4: Array[(String, Double)] = Array((B,0.575), (D,0.575), (A,1.8499999999999999), (C,1.0))
```
