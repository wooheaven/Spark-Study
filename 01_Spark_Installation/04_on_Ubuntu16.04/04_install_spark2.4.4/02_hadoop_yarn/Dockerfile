FROM ubuntu:16.04_3rd_hadoop2

RUN mkdir /usr/lib/spark
ADD spark-2.4.4-bin-hadoop2.7.tgz /usr/lib/spark
RUN ls -als /usr/lib/spark

ENV HADOOP_HOME /usr/lib/hadoop/hadoop-2.8.5
ENV HADOOP_CONF $HADOOP_HOME/etc/hadoop
ENV SPARK_HOME /usr/lib/spark/spark-2.4.4-bin-hadoop2.7
RUN echo $HADOOP_HOME && echo $HADOOP_CONF && echo $SPARK_HOME

RUN echo "" >> ~/.bashrc && \
    echo "# Spark" >> ~/.bashrc && \
    echo "export SPARK_HOME=$SPARK_HOME" >> ~/.bashrc && \
    echo "export PATH=\$PATH:\$SPARK_HOME/bin:\$SPARK_HOME/sbin" >> ~/.bashrc && \
    cat -n ~/.bashrc | tail -3

ADD spark-env.sh $SPARK_HOME/conf/
RUN cat -n $SPARK_HOME/conf/spark-env.sh | tail -7

RUN cd $SPARK_HOME && \
    cp conf/slaves.template conf/slaves && \
    cat $HADOOP_CONF/slaves > conf/slaves && \
    cat -n conf/slaves | tail -1

ADD spark-defaults.conf $SPARK_HOME/conf/
RUN cat -n $SPARK_HOME/conf/spark-defaults.conf | tail -11

RUN service ssh start && \
    sleep 1 && echo "start-dfs" && \
    $HADOOP_HOME/sbin/start-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    $HADOOP_HOME/bin/hdfs dfsadmin -safemode leave && \
    $HADOOP_HOME/bin/hdfs dfs -mkdir /tmp/spark-yarn && \
    $HADOOP_HOME/bin/hdfs dfs -ls /tmp && \
    sleep 1 && echo "start-yarn" && \
    $HADOOP_HOME/sbin/start-yarn.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    sleep 1 && echo "start-history-server" && \
    $SPARK_HOME/sbin/start-history-server.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    $HADOOP_HOME/bin/hdfs dfs -ls README.txt && \
    cd $SPARK_HOME/ && \
    $SPARK_HOME/bin/spark-submit --deploy-mode client --class org.apache.spark.examples.JavaWordCount examples/jars/spark-examples*.jar README.txt > wordcount.log && \
    cat wordcount.log 
#   $SPARK_HOME/bin/spark-submit --deploy-mode cluster --class org.apache.spark.examples.JavaWordCount examples/jars/spark-examples*.jar README.txt > wordcount.log && \
#   cat wordcount.log 

RUN service ssh start && \
    sleep 5 && echo "stop-history-server" && \
    $SPARK_HOME/sbin/stop-history-server.sh && \
    sleep 5 && echo "stop-yarn" && \
    $HADOOP_HOME/sbin/stop-yarn.sh && \
    sleep 5 && echo "stop-dfs" && \
    $HADOOP_HOME/sbin/stop-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps
