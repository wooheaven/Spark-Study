FROM ubuntu:16.04_2nd_jdk8

RUN mkdir /usr/lib/hadoop
ADD hadoop-2.8.5.tar.gz /usr/lib/hadoop
RUN ls -als /usr/lib/hadoop

RUN echo "" >> ~/.bashrc && \
    echo "# Hadoop" >> ~/.bashrc && \
    echo "HADOOP_HOME=/usr/lib/hadoop/hadoop-2.8.5" >> ~/.bashrc && \
    echo "PATH=\$PATH:\$HADOOP_HOME/bin:\$HADOOP_HOME/sbin" >> ~/.bashrc && \
    echo HADOOP_MAPRED_HOME=\$HADOOP_HOME>> ~/.bashrc && \
    echo HADOOP_COMMON_HOME=\$HADOOP_HOME >> ~/.bashrc && \
    echo HADOOP_HDFS_HOME=\$HADOOP_HOME >> ~/.bashrc && \
    echo YARN_HOME=\$HADOOP_HOME >> ~/.bashrc && \
    echo HADOOP_COMMON_LIB_NATIVE_DIR=\$HADOOP_HOME/lib/native >> ~/.bashrc && \
    echo HADOOP_OPTS=\"-Djava.library.path=\$HADOOP_COMMON_LIB_NATIVE_DIR\" >> ~/.bashrc && \
    cat -n ~/.bashrc | tail -9

RUN cd /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/ && \
    sed -i "s/JAVA_HOME=\${JAVA_HOME}/JAVA_HOME=\/usr\/lib\/jvm\/jdk1.8.0_221/" hadoop-env.sh && \
    cat -n hadoop-env.sh | head -25 | tail -2

RUN cd /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/ && \ 
    sed -i 's/<\/configuration>/    <property>/' core-site.xml && \
    echo "        <name>fs.default.name</name>" >> core-site.xml && \
    echo "        <value>hdfs://localhost:9000</value>" >> core-site.xml && \
    echo "    </property>" >> core-site.xml && \
    echo "</configuration>" >> core-site.xml && \
    cat -n core-site.xml | tail -6

RUN cd /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/ && \ 
    sed -i 's/<\/configuration>/    <property>/' yarn-site.xml && \
    echo "        <name>yarn.nodemanager.aux-services</name>" >> yarn-site.xml && \
    echo "        <value>mapreduce_shuffle</value>" >> yarn-site.xml && \
    echo "    </property>" >> yarn-site.xml && \
    echo "    <property>" >> yarn-site.xml && \
    echo "        <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>" >> yarn-site.xml && \
    echo "        <value>org.apache.hadoop.mapred.ShuffleHandler</value>" >> yarn-site.xml && \
    echo "    </property>" >> yarn-site.xml && \
    echo "</configuration>" >> yarn-site.xml && \
    cat -n yarn-site.xml | tail -13

RUN cd /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/ && \ 
    cp mapred-site.xml.template mapred-site.xml && \
    sed -i 's/<\/configuration>/    <property>/' mapred-site.xml && \
    echo "        <name>mapreduce.framework.name</name>" >> mapred-site.xml && \
    echo "        <value>yarn</value>" >> mapred-site.xml && \
    echo "    </property>" >> mapred-site.xml && \
    echo "</configuration>" >> mapred-site.xml && \
    cat -n mapred-site.xml | tail -7

RUN cd /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/ && \ 
    sed -i 's/<\/configuration>/    <property>/' hdfs-site.xml && \
    echo "        <name>dfs.replication</name>" >> hdfs-site.xml && \
    echo "        <value>1</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "    <property>" >> hdfs-site.xml && \
    echo "        <name>dfs.namenode.name.dir</name>" >> hdfs-site.xml && \
    echo "        <value>file:/usr/lib/hadoop/hadoop-2.8.5/hdfs/namenode</value>" >> hdfs-site.xml && \
    echo "    </property>" >> hdfs-site.xml && \
    echo "    <property>" >> hdfs-site.xml && \
    echo "        <name>dfs.namenode.data.dir</name>" >> hdfs-site.xml && \
    echo "        <value>file:/usr/lib/hadoop/hadoop-2.8.5/hdfs/datanode</value>" >> hdfs-site.xml && \
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

RUN cat /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/slaves && \ 
    cp /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/slaves /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/master && \
    cat /usr/lib/hadoop/hadoop-2.8.5/etc/hadoop/master

RUN cd /usr/lib/hadoop/hadoop-2.8.5/ && \ 
    mkdir hdfs && \
    mkdir hdfs/namenode && \
    mkdir hdfs/datanode && \
    /usr/lib/hadoop/hadoop-2.8.5/bin/hdfs namenode -format

RUN ls -als /usr/lib/hadoop/hadoop-2.8.5/hdfs/namenode/current

RUN service ssh start && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/start-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \ 
    /usr/lib/hadoop/hadoop-2.8.5/sbin/start-yarn.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps && \
    cd /usr/lib/hadoop/hadoop-2.8.5/ && \ 
    bin/hdfs dfs -ls / && \
    bin/hdfs dfs -mkdir /user && \
    bin/hdfs dfs -mkdir /user/root && \
    bin/hdfs dfs -put README.txt && \
    bin/hdfs dfs -ls && \
    bin/hdfs dfs -ls /user/root && \
    bin/hadoop jar /usr/lib/hadoop/hadoop-2.8.5/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.8.5.jar wordcount README.txt output/ && \
    bin/hdfs dfs -text output/part-r-00000 | head -5 && \
    bin/hdfs dfs -rmr output/ && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/stop-yarn.sh && \
    /usr/lib/hadoop/hadoop-2.8.5/sbin/stop-dfs.sh && \
    /usr/lib/jvm/jdk1.8.0_221/bin/jps
