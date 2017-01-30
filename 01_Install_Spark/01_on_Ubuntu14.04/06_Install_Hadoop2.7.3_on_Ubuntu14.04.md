# Install Hadoop2.7.3 on Ubuntu14.04
```{bash}
$ wget http://mirror.navercorp.com/apache/hadoop/common/hadoop-2.7.3/hadoop-2.7.3-src.tar.gz
$ ll hadoop-2.7.3.tar.gz
$ sudo mkdir /usr/local/hadoop
$ sudo chown rwoo:rwoo /usr/local/hadoop
$ tar -zxf hadoop-2.7.3.tar.gz -C /usr/local/hadoop/
$ cd /usr/local/hadoop
$ ln -s hadoop-2.7.3/ latest
$ ll
$ vi ~/.profile
...
31 # Hadoop
32 export HADOOP_HOME=/usr/local/hadoop/latest
33 export HADOOP_MAPRED_HOME=$HADOOP_HOME
34 export HADOOP_COMMON_HOME=$HADOOP_HOME
35 export HADOOP_HDFS_HOME=$HADOOP_HOME
36 export YARN_HOME=$HADOOP_HOME
37 export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native
38 export HADOOP_OPTS="-Djava.library.path=$HADOOP_COMMON_LIB_NATIVE_DIR"
39 export PATH=$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
...

$ source ~/.profile
$ cd $HADOOP_HOME
$ vi etc/hadoop/hadoop-env.sh
...
24 # The java implementation to use.
25 #export JAVA_HOME=${JAVA_HOME}
26 export JAVA_HOME=/usr/lib/jvm/java-8-oracle
...

$ vi etc/hadoop/core-site.xml
...
19 <configuration>
20     <property>
21         <name>fs.default.name</name>
22         <value>hdfs://localhost:9000</value>
23     </property>
24 </configuration>

$ vi etc/hadoop/yarn-site.xml
...
15 <configuration>
16   <property>
17     <name>yarn.nodemanager.aux-services</name>
18     <value>mapreduce_shuffle</value>
19   </property>
20   <property>
21     <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>
22     <value>org.apache.hadoop.mapred.ShuffleHandler</value>
23   </property>
24 </configuration>

$ cp etc/hadoop/mapred-site.xml.template etc/hadoop/mapred-site.xml
$ vi etc/hadoop/mapred-site.xml
...
19 <configuration>
20   <property>
21     <name>mapreduce.framework.name</name>
22     <value>yarn</value>
23   </property>
24 </configuration>

$ mkdir hdfs
$ mkdir hdfs/namenode
$ mkdir hdfs/datanode
$ vi etc/hadoop/hdfs-site.xml
...
19 <configuration>
20   <property>
21     <name>dfs.replication</name>
22     <value>1</value>
23   </property>
24   <property>
25     <name>dfs.namenode.name.dir</name>
26     <value>file:/usr/local/hadoop/latest/hdfs/namenode</value>
27   </property>
28   <property>
29     <name>dfs.datanode.data.dir</name>
30     <value>file:/usr/local/hadoop/latest/hdfs/datanode</value>
31   </property>
32 </configuration>

$ hdfs namenode -format
$ tree hdfs

$ start-dfs.sh
$ jps
22016 SecondaryNameNode
21809 DataNode
22165 Jps
21640 NameNode

$ start-yarn.sh
$ jps
22016 SecondaryNameNode
21809 DataNode
22577 Jps
21640 NameNode
22364 NodeManager
22221 ResourceManager

# ResourceManager
http://localhost:8088/cluster

$ mr-jobhistory-daemon.sh start historyserver
$ jps
22016 SecondaryNameNode
21809 DataNode
22871 JobHistoryServer
21640 NameNode
22364 NodeManager
22908 Jps
22221 ResourceManager

# MR JobHistory Server
http://localhost:19888/jobhistory

# Namenode web admin
http://localhost:50070

$ hdfs dfs -mkdir /user
$ hdfs dfs -mkdir /user/rwoo
$ hdfs dfs -chown rwoo:rwoo /user/rwoo
$ hdfs dfs -put README.txt
$ hdfs dfs -ls
$ hdfs dfs -ls /user/rwoo

$ hdfs dfs -rm -r output/
$ hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.3.jar wordcount README.txt output/
$ hdfs dfs -text output/part-r-00000
```
