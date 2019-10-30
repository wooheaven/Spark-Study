# build and deploy
```
$ pwd
/home/ubuntu/02_Documents/10_Spark_WorkSpace/Spark-Study/02_Spark_Workspace/spark2WithJDK8

$ mvn package

$ md5sum target/spark2WithJDK8-1.0-SNAPSHOT.jar 
c489485960f9e913014087292b8477e4  target/spark2WithJDK8-1.0-SNAPSHOT.jar

$ docker cp target/spark2WithJDK8-1.0-SNAPSHOT.jar spark:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7/examples/jars

root@d357da7f302f:/# cd $SPARK_HOME/

root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# md5sum examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar 
c489485960f9e913014087292b8477e4  examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar
```

# spark-submit
```
root@5657c0030c10:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# spark-submit \
> --deploy-mode client \
> --class rwoo.study.spark.example.PiEstimation \
> examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar \
> hdfs:///user/root/numbers.txt hdfs:///user/root/output

root@5657c0030c10:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -ls output/
Found 2 items
-rw-r--r--   1 root supergroup          0 2019-10-30 05:22 output/_SUCCESS
-rw-r--r--   1 root supergroup         19 2019-10-30 05:22 output/part-00000

root@5657c0030c10:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -cat output/part-00000
3.1363136313631363
```
