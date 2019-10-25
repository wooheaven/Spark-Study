# build and deploy
```
$ pwd
/home/ubuntu/02_Documents/10_Spark_WorkSpace/Spark-Study/02_Spark_Workspace/spark2WithJDK8

$ mvn package

$ md5sum target/spark2WithJDK8-1.0-SNAPSHOT.jar 
29969c8aeed723936e0f251a607a670c  target/spark2WithJDK8-1.0-SNAPSHOT.jar

$ docker cp target/spark2WithJDK8-1.0-SNAPSHOT.jar spark:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7/examples/jars

root@d357da7f302f:/# cd $SPARK_HOME/

root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# md5sum examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar 
29969c8aeed723936e0f251a607a670c  examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar
```

# spark-submit
```
root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# spark-submit \
> --deploy-mode client \
> --class rwoo.study.spark.example.PageRank \
> examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar \
> hdfs:///user/root/pageLinks.txt hdfs:///user/root/output/ 1

root@5657c0030c10:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -ls /user/root/output
Found 3 items
-rw-r--r--   1 root supergroup          0 2019-10-25 07:50 /user/root/output/_SUCCESS
-rw-r--r--   1 root supergroup         20 2019-10-25 07:50 /user/root/output/part-00000
-rw-r--r--   1 root supergroup         31 2019-10-25 07:50 /user/root/output/part-00001
root@5657c0030c10:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -text /user/root/output/part-00000
(B,0.575)
(D,0.575)
root@5657c0030c10:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -text /user/root/output/part-00001
(A,1.8499999999999999)
(C,1.0)
```
