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
root@d357da7f302f:/# spark-shell --master yarn --deploy-mode client --packages graphframes:graphframes:0.7.0-spark2.4-s_2.11
Ivy Default Cache set to: /root/.ivy2/cache
The jars for the packages stored in: /root/.ivy2/jars
:: loading settings :: url = jar:file:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7/jars/ivy-2.4.0.jar!/org/apache/ivy/core/settings/ivysettings.xml
graphframes#graphframes added as a dependency
:: resolving dependencies :: org.apache.spark#spark-submit-parent-4f1caa77-5047-4be6-8eaf-4f5861658ffe;1.0
	confs: [default]
	found graphframes#graphframes;0.7.0-spark2.4-s_2.11 in spark-packages
	found org.slf4j#slf4j-api;1.7.16 in central
downloading https://dl.bintray.com/spark-packages/maven/graphframes/graphframes/0.7.0-spark2.4-s_2.11/graphframes-0.7.0-spark2.4-s_2.11.jar ...
	[SUCCESSFUL ] graphframes#graphframes;0.7.0-spark2.4-s_2.11!graphframes.jar (3192ms)
downloading https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar ...
	[SUCCESSFUL ] org.slf4j#slf4j-api;1.7.16!slf4j-api.jar (263ms)
:: resolution report :: resolve 4707ms :: artifacts dl 3466ms
	:: modules in use:
	graphframes#graphframes;0.7.0-spark2.4-s_2.11 from spark-packages in [default]
	org.slf4j#slf4j-api;1.7.16 from central in [default]
	---------------------------------------------------------------------
	|                  |            modules            ||   artifacts   |
	|       conf       | number| search|dwnlded|evicted|| number|dwnlded|
	---------------------------------------------------------------------
	|      default     |   2   |   2   |   2   |   0   ||   2   |   2   |
	---------------------------------------------------------------------
:: retrieving :: org.apache.spark#spark-submit-parent-4f1caa77-5047-4be6-8eaf-4f5861658ffe
	confs: [default]
	2 artifacts copied, 0 already retrieved (411kB/16ms)
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
19/10/22 14:21:27 WARN yarn.Client: Neither spark.yarn.jars nor spark.yarn.archive is set, falling back to uploading libraries under SPARK_HOME.
Spark context Web UI available at http://d357da7f302f:4040
Spark context available as 'sc' (master = yarn, app id = application_1571753973070_0002).
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

# PageRank with graphframes
```
scala> import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SQLContext

scala> val sqlContext = new SQLContext(sc)
warning: there was one deprecation warning; re-run with -deprecation for details
sqlContext: org.apache.spark.sql.SQLContext = org.apache.spark.sql.SQLContext@403e8b5

scala> val v = sqlContext.createDataFrame(List(
     |   ("a", "Alice", 34),
     |   ("b", "Bob", 36),
     |   ("c", "Charlie", 30)
     | )).toDF("id", "name", "age")
v: org.apache.spark.sql.DataFrame = [id: string, name: string ... 1 more field]

scala> v.show()
+---+-------+---+
| id|   name|age|
+---+-------+---+
|  a|  Alice| 34|
|  b|    Bob| 36|
|  c|Charlie| 30|
+---+-------+---+

scala> val e = sqlContext.createDataFrame(List(
     |   ("a", "b", "friend"),
     |   ("b", "c", "follow"),
     |   ("c", "b", "follow")
     | )).toDF("src", "dst", "relationship")
e: org.apache.spark.sql.DataFrame = [src: string, dst: string ... 1 more field]

scala> e.show
+---+---+------------+
|src|dst|relationship|
+---+---+------------+
|  a|  b|      friend|
|  b|  c|      follow|
|  c|  b|      follow|
+---+---+------------+

scala> val g = GraphFrame(v,e)
g: org.graphframes.GraphFrame = GraphFrame(v:[id: string, name: string ... 1 more field], e:[src: string, dst: string ... 1 more field])

scala> g.inDegrees.show
+---+--------+                                                                  
| id|inDegree|
+---+--------+
|  c|       1|
|  b|       2|
+---+--------+

scala> g.edges.filter("relationship = 'follow'").count()
res4: Long = 2

scala> val results = g.pageRank.resetProbability(0.01).maxIter(20).run()
results: org.graphframes.GraphFrame = GraphFrame(v:[id: string, name: string ... 2 more fields], e:[src: string, dst: string ... 2 more fields])

scala> results.vertices.select("id", "pagerank").show()
+---+------------------+                                                        
| id|          pagerank|
+---+------------------+
|  a|              0.01|
|  b|1.0905890109440908|
|  c|1.8994109890559092|
+---+------------------+
```
