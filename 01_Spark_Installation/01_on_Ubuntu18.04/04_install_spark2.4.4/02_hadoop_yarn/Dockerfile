FROM ubuntu:18.04_3rd_hadoop2

RUN mkdir /usr/lib/spark
ADD spark-2.4.4-bin-hadoop2.7.tgz /usr/lib/spark
RUN ls -als /usr/lib/spark

ENV HADOOP_HOME /usr/lib/hadoop/hadoop-2.8.5
ENV HADOOP_CONF $HADOOP_HOME/etc/hadoop
ENV SPARK_HOME /usr/lib/spark/spark-2.4.4-bin-hadoop2.7
RUN echo $HADOOP_HOME && echo $HADOOP_CONF && echo $SPARK_HOME

ADD 99_Utility/spark_bashrc.txt /root
RUN cat /root/spark_bashrc.txt >> /root/.bashrc && \
    cat -n ~/.bashrc | tail -3

ADD spark-env.sh $SPARK_HOME/conf/
RUN cat -n $SPARK_HOME/conf/spark-env.sh | tail -7

RUN cat -n $HADOOP_CONF/slaves && \
    cp $SPARK_HOME/conf/slaves.template $SPARK_HOME/conf/slaves && \
    sed -i 's/localhost/localhost\n/' $SPARK_HOME/conf/slaves && \
    cat -n $SPARK_HOME/conf/slaves | tail -2

RUN cd $SPARK_HOME && \
    /usr/lib/jvm/zulu8.50.0.21-ca-jdk8.0.272-linux_x64/bin/jar cv0f spark-libs.jar -C $SPARK_HOME/jars/ . && \
    ls -als $SPARK_HOME/spark-libs.jar

ADD spark-defaults.conf $SPARK_HOME/conf/
RUN cat -n $SPARK_HOME/conf/spark-defaults.conf | tail -12

RUN service ssh start && \
    sleep 1 && echo "start-dfs" && \
    $HADOOP_HOME/sbin/start-dfs.sh && \
    $HADOOP_HOME/bin/hdfs dfsadmin -safemode leave && \
    $HADOOP_HOME/bin/hdfs dfs -mkdir /user/root/spark_yarn_archive && \
    $HADOOP_HOME/bin/hdfs dfs -put $SPARK_HOME/spark-libs.jar /user/root/spark_yarn_archive && \
    $HADOOP_HOME/bin/hdfs dfs -ls /user/root/spark_yarn_archive && \
    $HADOOP_HOME/bin/hdfs dfs -setrep -w 1 hdfs:///user/root/spark_yarn_archive/spark-libs.jar && \
    $HADOOP_HOME/bin/hdfs dfs -mkdir /tmp/spark-yarn && \
    $HADOOP_HOME/bin/hdfs dfs -ls /tmp && \
    sleep 1 && echo "start-yarn" && \
    $HADOOP_HOME/sbin/start-yarn.sh && \
    sleep 1 && echo "start-history-server" && \
    $SPARK_HOME/sbin/start-history-server.sh && \
    /usr/lib/jvm/zulu8.50.0.21-ca-jdk8.0.272-linux_x64/bin/jps && \ 
    $HADOOP_HOME/bin/hdfs dfs -ls README.txt && \
    cd $SPARK_HOME/ && \
    $SPARK_HOME/bin/spark-submit --deploy-mode client --class org.apache.spark.examples.JavaWordCount examples/jars/spark-examples*.jar README.txt > wordcount.log && \
    cat wordcount.log | head && \
    $SPARK_HOME/sbin/stop-history-server.sh && \
    $HADOOP_HOME/sbin/stop-yarn.sh && \
    $HADOOP_HOME/sbin/stop-dfs.sh && \
    /usr/lib/jvm/zulu8.50.0.21-ca-jdk8.0.272-linux_x64/bin/jps && \
    service ssh stop
#   $SPARK_HOME/bin/spark-submit --deploy-mode cluster --class org.apache.spark.examples.JavaWordCount examples/jars/spark-examples*.jar README.txt > wordcount.log && \
#   cat wordcount.log 

ADD 99_Utility/*.sh /root/
RUN chmod +x /root/*.sh
