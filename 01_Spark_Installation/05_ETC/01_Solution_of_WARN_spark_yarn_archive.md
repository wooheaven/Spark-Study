# WARN from spark.yarn.archive
```
root@c65bb1a14adf:/# spark-shell --master yarn --deploy-mode client
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
19/10/21 11:16:23 WARN yarn.Client: Neither spark.yarn.jars nor spark.yarn.archive is set, falling back to uploading libraries under SPARK_HOME.
Spark context Web UI available at http://c65bb1a14adf:4040
Spark context available as 'sc' (master = yarn, app id = application_1571656520634_0001).
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

# archive spark yarn jars and upload to hdfs
```
root@13149d68c1be:~# cd $SPARK_HOME/

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# jar cv0f spark-libs.jar -C $SPARK_HOME/jars/ .
added manifest
adding: compress-lzf-1.0.3.jar(in = 79845) (out= 79845)(stored 0%)
...

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# ll spark-libs.jar 
-rw-r--r-- 1 root root 238621098 Nov  2 12:07 spark-libs.jar

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -mkdir /user/root/spark_yarn_archive

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -put spark-libs.jar /user/root/spark_yarn_archive

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -ls /user/root/spark_yarn_archive
Found 1 items
-rw-r--r--   1 root supergroup  238621098 2019-11-02 12:14 /user/root/spark_yarn_archive/spark-libs.jar

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# cat $HADOOP_CONF/hdfs-site.xml 
...
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
...

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# # For a large cluster, increase the replication count of the Spark archive 
root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# # so that you reduce the amount of times for a NodeManager will do a remote copy

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -setrep -w 1 hdfs:///user/root/spark_yarn_archive/spark-libs.jar
Replication 1 set: hdfs:///user/root/spark_yarn_archive/spark-libs.jar
Waiting for hdfs:///user/root/spark_yarn_archive/spark-libs.jar ... done 

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# echo "spark.yarn.archive hdfs:///user/root/spark_yarn_archive/spark-libs.jar" >> $SPARK_HOME/conf/spark-defaults.conf

root@13149d68c1be:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# cat -n $SPARK_HOME/conf/spark-defaults.conf | tail -1
    40  spark.yarn.archive hdfs:///user/root/spark_yarn_archive/spark-libs.jar
```

# fix
```
root@13149d68c1be:~# spark-shell --master yarn --deploy-mode client
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
Spark context Web UI available at http://13149d68c1be:4040
Spark context available as 'sc' (master = yarn, app id = application_1572697430061_0001).
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
