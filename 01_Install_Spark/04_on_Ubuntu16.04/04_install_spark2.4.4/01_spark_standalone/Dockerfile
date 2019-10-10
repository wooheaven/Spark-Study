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

RUN cd $SPARK_HOME && \
    cp $SPARK_HOME/conf/spark-env.sh.template $SPARK_HOME/conf/spark-env.sh && \
    echo "" >> conf/spark-env.sh && \
    echo "# Add" >> conf/spark-env.sh && \
    echo "JAVA_HOME=/usr/lib/jvm/jdk1.8.0_221" >> conf/spark-env.sh && \
    echo "HADOOP_HOME=$HADOOP_HOME" >> conf/spark-env.sh && \
    echo "HADOOP_CONF_DIR=$HADOOP_CONF" >> conf/spark-env.sh && \
    echo "SPARK_MASTER_HOST=localhost" >> conf/spark-env.sh && \
    echo "SPARK_HISTORY_OPTS=\"-Dspark.history.fs.logDirectory=hdfs://localhost:9000/tmp/spark-standalone\"" >> conf/spark-env.sh && \
    echo "LD_LIBRARY_PATH=$HADOOP_HOME/lib/native" >> conf/spark-env.sh && \
    cat -n conf/spark-env.sh | tail -6

RUN cd $SPARK_HOME && \
    cp conf/slaves.template conf/slaves && \
    cat $HADOOP_CONF/slaves > conf/slaves && \
    cat -n conf/slaves | tail -1

ADD spark-defaults.conf $SPARK_HOME/conf/
RUN cd $SPARK_HOME && \
    cat -n conf/spark-defaults.conf | tail -3

RUN service ssh start && \
    sleep 1 && echo "start-dfs" && \
    $HADOOP_HOME/sbin/start-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    $HADOOP_HOME/bin/hdfs dfsadmin -safemode leave && \
    $HADOOP_HOME/bin/hdfs dfs -mkdir /tmp/spark-standalone && \
    $HADOOP_HOME/bin/hdfs dfs -ls /tmp && \
    sleep 1 && echo "start-master" && \
    $SPARK_HOME/sbin/start-master.sh && \
    sleep 1 && echo "start-slaves" && \
    $SPARK_HOME/sbin/start-slaves.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    $HADOOP_HOME/bin/hdfs dfs -ls README.txt && \
    cd $SPARK_HOME && \
    $SPARK_HOME/bin/spark-submit --class org.apache.spark.examples.JavaWordCount examples/jars/spark-examples*.jar README.txt

RUN service ssh start && \
    sleep 5 && echo "stop-slaves" && \
    $SPARK_HOME/sbin/stop-slaves.sh && \
    sleep 5 && echo "stop-master" && \
    $SPARK_HOME/sbin/stop-master.sh && \
    sleep 5 && echo "stop-dfs" && \
    $HADOOP_HOME/sbin/stop-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps
