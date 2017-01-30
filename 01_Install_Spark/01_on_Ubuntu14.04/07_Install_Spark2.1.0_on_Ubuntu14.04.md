# Install Spark2.1.0 on Ubuntu14.04
```{bash}
$ wget http://d3kbcqa49mib13.cloudfront.net/spark-2.1.0-bin-hadoop2.7.tgz
$ sudo mkdir /usr/local/spark
$ sudo chown rwoo:rwoo /usr/local/spark
$ tar -zxf spark-2.1.0-bin-hadoop2.7.tgz -C /usr/local/spark
$ cd /usr/local/spark
$ ln -s spark-2.1.0-bin-hadoop2.7/ latest
$ ll
$ vi ~/.profile
41 # Spark
42 export SPARK_HOME=/usr/local/spark/latest
43 export PATH=$PATH:$SPARK_HOME/bin:$SPARK_HOME/sbin

$ source ~/.profile

$ cd $SPARK_HOME
$ cp conf/spark-env.sh.template conf/spark-env.sh
$ vi conf/spark-env.sh
...
68 export JAVA_HOME=/usr/lib/jvm/java-8-oracle
69 export HADOOP_HOME=/usr/local/hadoop/latest
70 export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop/
71 export SPARK_MASTER_HOST=localhost
72 export SPARK_HISTORY_OPTS="-Dspark.history.fs.logDirectory=hdfs://localhost:9000/tmp/spark-standalone"
73 export LD_LIBRARY_PATH=${HADOOP_HOME}/lib/native/:$LD_LIBRARY_PATH

$ vi conf/spark-default.conf
...
29 spark.eventLog.enabled true
30 spark.eventLog.dir hdfs://localhost:9000/tmp/spark-standalone

$ hdfs dfs -mkdir /tmp/spark-standalone
$ hdfs dfs -chown -R rwoo:rwoo /tmp/spark-standalone

$ start-master.sh
$ jps
22016 SecondaryNameNode
25809 Jps
21809 DataNode
22871 JobHistoryServer
21640 NameNode
22364 NodeManager
22221 ResourceManager
27529 Master

# Spark Master web
http://localhost:8080/

$ start-slaves.sh 
$ jps
22016 SecondaryNameNode
21809 DataNode
26004 Jps
22871 JobHistoryServer
21640 NameNode
22364 NodeManager
22221 ResourceManager
27713 Worker
27529 Master

# Spark Worker web
http://localhost:8081/

$ start-history-server.sh
$ jps
27808 HistoryServer
22016 SecondaryNameNode
27713 Worker
21809 DataNode
22871 JobHistoryServer
21640 NameNode
27529 Master
22364 NodeManager
22221 ResourceManager
27902 Jps

# Spark History Server web
http://localhost:18080
```
