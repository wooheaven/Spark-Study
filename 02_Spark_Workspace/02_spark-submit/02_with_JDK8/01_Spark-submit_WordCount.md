# build and deploy
```
$ pwd
/home/ubuntu/02_Documents/10_Spark_WorkSpace/Spark-Study/02_Spark_Workspace/spark2WithJDK8

$ mvn package

$ md5sum target/spark2WithJDK8-1.0-SNAPSHOT.jar 
3d49a426351f8c0885ac6c2e27f41a2b  target/spark2WithJDK8-1.0-SNAPSHOT.jar

$ docker cp target/spark2WithJDK8-1.0-SNAPSHOT.jar spark:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7/examples/jars

root@d357da7f302f:/# cd $SPARK_HOME/

root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# md5sum examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar 
3d49a426351f8c0885ac6c2e27f41a2b  examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar
```

# spark-submit
```
root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# spark-submit \
> --deploy-mode client \
> --class rwoo.study.spark.example.WordCount \
> --num-executors 1 \
> --driver-memory 512m \
> --executor-memory 512m \
> --executor-cores 1 \
> examples/jars/spark2WithJDK8-1.0-SNAPSHOT.jar \
> hdfs:///user/root/README.txt hdfs:///user/root/output/

root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -ls /user/root/output
Found 3 items
-rw-r--r--   1 root supergroup          0 2019-10-23 03:05 /user/root/output/_SUCCESS
-rw-r--r--   1 root supergroup        836 2019-10-23 03:05 /user/root/output/part-00000
-rw-r--r--   1 root supergroup        738 2019-10-23 03:05 /user/root/output/part-00001

root@d357da7f302f:/usr/lib/spark/spark-2.4.4-bin-hadoop2.7# hdfs dfs -cat /user/root/output/part-00000 | tail
(country,,1)
(cryptographic,3)
(currently,1)
(details,1)
(distribution,2)
(eligible,1)
(encryption,3)
(exception,1)
(export,1)
(following,1)
```
