FROM ubuntu:16.04_2nd_jdk8

RUN mkdir /usr/lib/hadoop
ADD hadoop-2.8.5.tar.gz /usr/lib/hadoop
RUN ls -als /usr/lib/hadoop

ENV HADOOP_HOME /usr/lib/hadoop/hadoop-2.8.5
ENV HADOOP_CONF $HADOOP_HOME/etc/hadoop
ENV HADOOP_COMMON_LIB_NATIVE_DIR $HADOOP_HOME/lib/native
RUN echo $HADOOP_HOME && echo $HADOOP_COMMON_LIB_NATIVE_DIR

ADD hadoop_bashrc.txt /root
RUN cat /root/hadoop_bashrc.txt >> /root/.bashrc && \
    cat -n /root/.bashrc | tail -9

RUN sed -i "s/JAVA_HOME=\${JAVA_HOME}/JAVA_HOME=\/usr\/lib\/jvm\/jdk1.8.0_221/" $HADOOP_CONF/hadoop-env.sh && \
    cat -n $HADOOP_CONF/hadoop-env.sh | head -25 | tail -2

ADD core-site.xml $HADOOP_CONF
RUN cat -n $HADOOP_$HADOOP_CONF/core-site.xml | tail -6 

ADD hdfs-site.xml $HADOOP_$HADOOP_CONF
RUN cat -n $HADOOP_$HADOOP_CONF/hdfs-site.xml | tail -23

ADD mapred-site.xml $HADOOP_$HADOOP_CONF
RUN cat -n $HADOOP_$HADOOP_CONF/mapred-site.xml | tail -32

ADD yarn-site.xml $HADOOP_$HADOOP_CONF
RUN cat -n $HADOOP_$HADOOP_CONF/yarn-site.xml | tail -38

RUN cat -n $HADOOP_$HADOOP_CONF/slaves && \ 
    cp $HADOOP_$HADOOP_CONF/slaves $HADOOP_CONF/master && \
    cat -n $HADOOP_$HADOOP_CONF/master

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

ADD 99_Utility/*.sh /root/

RUN chmod +x /root/*.sh

# ref : https://hadoop.apache.org/docs/r2.8.5/hadoop-project-dist/hadoop-hdfs/hdfs-default.xml
# ref : https://hadoop.apache.org/docs/r2.8.5/hadoop-yarn/hadoop-yarn-common/yarn-default.xml
# ref : https://hadoop.apache.org/docs/r2.8.5/hadoop-project-dist/hadoop-common/ClusterSetup.html
# ref : https://www.linode.com/docs/databases/hadoop/how-to-install-and-set-up-hadoop-cluster/
