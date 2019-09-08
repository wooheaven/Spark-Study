FROM ubuntu:16.04_2nd_jdk8

RUN mkdir /usr/lib/hadoop
ADD hadoop-2.8.5.tar.gz /usr/lib/hadoop
RUN ls -als /usr/lib/hadoop

ENV HADOOP_HOME /usr/lib/hadoop/hadoop-2.8.5
ENV HADOOP_CONF $HADOOP_HOME/etc/hadoop
ENV HADOOP_COMMON_LIB_NATIVE_DIR $HADOOP_HOME/lib/native
RUN echo $HADOOP_HOME && echo $HADOOP_COMMON_LIB_NATIVE_DIR

# Step 8
RUN echo "" >> ~/.bashrc && \
    echo "# Hadoop" >> ~/.bashrc && \
    echo "export HADOOP_HOME=$HADOOP_HOME" >> ~/.bashrc && \
    echo "export PATH=\$PATH:$HADOOP_HOME/bin:$HADOOP_HOME/sbin" >> ~/.bashrc && \
    echo "export HADOOP_MAPRED_HOME=$HADOOP_HOME" >> ~/.bashrc && \
    echo "export HADOOP_COMMON_HOME=$HADOOP_HOME" >> ~/.bashrc && \
    echo "export HADOOP_HDFS_HOME=$HADOOP_HOME" >> ~/.bashrc && \
    echo "export YARN_HOME=$HADOOP_HOME" >> ~/.bashrc && \
    echo "export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_COMMON_LIB_NATIVE_DIR" >> ~/.bashrc && \
    echo "export HADOOP_OPTS=\"-Djava.library.path=$HADOOP_COMMON_LIB_NATIVE_DIR\"" >> ~/.bashrc && \
    cat -n ~/.bashrc | tail -9

RUN cd $HADOOP_CONF && \
    sed -i "s/JAVA_HOME=\${JAVA_HOME}/JAVA_HOME=\/usr\/lib\/jvm\/jdk1.8.0_221/" hadoop-env.sh && \
    cat -n hadoop-env.sh | head -25 | tail -2

RUN cd $HADOOP_$HADOOP_CONF/ && \ 
    sed -i 's/<\/configuration>/    <property>/' core-site.xml && \
    echo "        <name>fs.default.name</name>" >> core-site.xml && \
    echo "        <value>hdfs://localhost:9000</value>" >> core-site.xml && \
    echo "    </property>" >> core-site.xml && \
    echo "</configuration>" >> core-site.xml && \
    cat -n core-site.xml | tail -6

RUN cd $HADOOP_$HADOOP_CONF/ && \ 
    sed -i 's/<\/configuration>/    <property>/' hdfs-site.xml && \
    echo "        <name>dfs.replication</name>" >> hdfs-site.xml && \
    echo "        <value>1</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "    <property>" >> hdfs-site.xml && \
    echo "        <name>dfs.namenode.name.dir</name>" >> hdfs-site.xml && \
    echo "        <value>file:$HADOOP_HOME/hdfs/namenode</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "    <property>" >> hdfs-site.xml && \
    echo "        <name>dfs.namenode.data.dir</name>" >> hdfs-site.xml && \
    echo "        <value>file:$HADOOP_HOME/hdfs/datanode</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "    <property>" >> hdfs-site.xml && \
    echo "        <name>dfs.http.address</name>" >> hdfs-site.xml && \
    echo "        <value>localhost:50070</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "    <property>" >> hdfs-site.xml && \
    echo "        <name>dfs.secondary.http.address</name>" >> hdfs-site.xml && \
    echo "        <value>localhost:50090</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "</configuration>" >> hdfs-site.xml && \
    cat -n hdfs-site.xml | tail -23

ADD mapred-site.xml /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/
RUN cd $HADOOP_$HADOOP_CONF/ && \ 
    cat -n mapred-site.xml | tail -32

ADD yarn-site.xml /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/
RUN cd $HADOOP_$HADOOP_CONF/ && \ 
    cat -n yarn-site.xml | tail -38

RUN cat $HADOOP_$HADOOP_CONF/slaves && \ 
    cp $HADOOP_$HADOOP_CONF/slaves $HADOOP_CONF/master && \
    cat $HADOOP_$HADOOP_CONF/master

RUN cd $HADOOP_HOME && \ 
    mkdir hdfs && \
    mkdir hdfs/namenode && \
    mkdir hdfs/datanode && \
    $HADOOP_HOME/bin/hdfs namenode -format && \
    tree hdfs

RUN service ssh start && \
    $HADOOP_HOME/sbin/start-dfs.sh && \
    $HADOOP_HOME/sbin/start-yarn.sh && \
    $HADOOP_HOME/sbin/mr-jobhistory-daemon.sh start historyserver && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \
    cd $HADOOP_HOME && \ 
    bin/hdfs dfs -ls / && \
    bin/hdfs dfs -mkdir /user && \
    bin/hdfs dfs -mkdir /user/root && \
    bin/hdfs dfs -put README.txt && \
    bin/hdfs dfs -ls && \
    bin/hdfs dfs -ls /user/root && \
    bin/hdfs dfs -text README.txt | head && \
    bin/yarn jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.8.5.jar wordcount README.txt output/ && \
    bin/hdfs dfs -text output/part-r-00000 | head && \
    bin/hdfs dfs -rmr output/ && \
    $HADOOP_HOME/sbin/mr-jobhistory-daemon.sh stop historyserver && \
    $HADOOP_HOME/sbin/stop-yarn.sh && \
    $HADOOP_HOME/sbin/stop-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \
    service ssh stop

ENTRYPOINT service ssh start && \
    $HADOOP_HOME/sbin/start-dfs.sh && \
    $HADOOP_HOME/sbin/start-yarn.sh && \
    $HADOOP_HOME/sbin/mr-jobhistory-daemon.sh start historyserver && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \
    /bin/bash

# ref : https://hadoop.apache.org/docs/r2.8.5/hadoop-project-dist/hadoop-hdfs/hdfs-default.xml
# ref : https://hadoop.apache.org/docs/r2.8.5/hadoop-yarn/hadoop-yarn-common/yarn-default.xml
# ref : https://hadoop.apache.org/docs/r2.8.5/hadoop-project-dist/hadoop-common/ClusterSetup.html
# ref : https://www.linode.com/docs/databases/hadoop/how-to-install-and-set-up-hadoop-cluster/
