FROM ubuntu:16.04_3rd_hadoop2

RUN mkdir /usr/lib/spark
ADD spark-2.4.3-bin-hadoop2.7.tgz /usr/lib/spark
RUN ls -als /usr/lib/spark

RUN echo "" >> ~/.bashrc && \
    echo "# Spark" >> ~/.bashrc && \
    echo "SPARK_HOME=/usr/lib/spark/spark-2.4.3-bin-hadoop2.7" >> ~/.bashrc && \
    echo "PATH=\$PATH:\$SPARK_HOME/bin:\$SPARK_HOME/sbin" >> ~/.bashrc && \
    cat -n ~/.bashrc | tail -3

RUN cd /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/ && \
    cp /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/conf/spark-env.sh.template /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/conf/spark-env.sh && \
    echo "" >> conf/spark-env.sh && \
    echo "# Add" >> conf/spark-env.sh && \
    echo "JAVA_HOME=/usr/lib/jvm/jdk1.8.0_221" >> conf/spark-env.sh && \
    echo "HADOOP_HOME=/usr/lib/hadoop/hadoop-2.8.5" >> conf/spark-env.sh && \
    echo "HADOOP_CONF_DIR=/usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/" >> conf/spark-env.sh && \
    echo "SPARK_MASTER_HOST=localhost >> conf/spark-env.sh" && \
    echo "LD_LIBRARY_PATH=/usr/lib/hadoop/hadoop-2.8.5/lib/native" >> conf/spark-env.sh && \
    cat -n conf/spark-env.sh | tail -6

RUN cd /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/ && \
    cp conf/slaves.template conf/slaves && \
    cat /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/slaves > conf/slaves && \
    cat -n conf/slaves | tail -1

RUN cd /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/ && \
    cp conf/spark-defaults.conf.template conf/spark-defaults.conf && \
    echo "" >> conf/spark-defaults.conf && \
    echo "# Add" >> conf/spark-defaults.conf && \
    echo "spark.eventLog.enabled           true" >> conf/spark-defaults.conf && \
    echo "spark.eventLog.dir               hdfs://localhost:9000/tmp/spark-yarn" >> conf/spark-defaults.conf && \
    echo "spark.history.provider           org.apache.spark.deploy.history.FsHistoryProvider" >> conf/spark-defaults.conf && \
    echo "spark.history.fs.logDirectory    hdfs://localhost:9000/tmp/spark-yarn" >> conf/spark-defaults.conf && \
    echo "spark.history.fs.update.interval 10s" >> conf/spark-defaults.conf && \
    echo "spark.history.ui.port            18080" >> conf/spark-defaults.conf && \
    echo "spark.master                     yarn" >> conf/spark-defaults.conf && \
    cat -n conf/spark-defaults.conf | tail -8

RUN service ssh start && \
    sleep 1 && echo "start-dfs" && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/start-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    /usr/lib/hadoop/hadoop-2.8.5/bin/hdfs dfsadmin -safemode leave && \
    /usr/lib/hadoop/hadoop-2.8.5/bin/hdfs dfs -mkdir /tmp/spark-yarn && \
    /usr/lib/hadoop/hadoop-2.8.5/bin/hdfs dfs -ls /tmp && \
    sleep 1 && echo "start-yarn" && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/start-yarn.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    sleep 1 && echo "start-history-server" && \
    /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/sbin/start-history-server.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    /usr/lib/hadoop/hadoop-2.8.5/bin/hdfs dfs -ls README.txt && \
    cd /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/ && \
    /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/bin/spark-submit --deploy-mode cluster --class org.apache.spark.examples.JavaWordCount examples/jars/spark-examples*.jar README.txt

RUN service ssh start && \
    sleep 5 && echo "stop-history-server" && \
    /usr/lib/spark/spark-2.4.3-bin-hadoop2.7/sbin/stop-history-server.sh && \
    sleep 5 && echo "stop-yarn" && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/stop-yarn.sh && \
    sleep 5 && echo "stop-dfs" && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/stop-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps
