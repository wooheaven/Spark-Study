```
scala> val a = sc.parallelize(Array(2, 4, 1), 2)
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:24

scala> a.glom.collect
res0: Array[Array[Int]] = Array(Array(2), Array(4, 1))

scala> val conf = sc.hadoopConfiguration
conf: org.apache.hadoop.conf.Configuration = Configuration: core-default.xml, core-site.xml, mapred-default.xml, mapred-site.xml, yarn-default.xml, yarn-site.xml, hdfs-default.xml, hdfs-site.xml, __spark_hadoop_conf__.xml

scala> val fs = org.apache.hadoop.fs.FileSystem.get(conf)
fs: org.apache.hadoop.fs.FileSystem = DFS[DFSClient[clientName=DFSClient_NONMAPREDUCE_58349785_1, ugi=root (auth:SIMPLE)]]

scala> val path = new org.apache.hadoop.fs.Path("hdfs:///user/root/saveTest")
path: org.apache.hadoop.fs.Path = hdfs:/user/root/saveTest

scala> fs.exists(path))
res3: Boolean = false

scala> a.saveAsTextFile("hdfs:///user/root/saveTest")

scala> fs.exists(path))
res5: Boolean = true

scala> val tmp = fs.listLocatedStatus(path)
tmp: org.apache.hadoop.fs.RemoteIterator[org.apache.hadoop.fs.LocatedFileStatus] = org.apache.hadoop.hdfs.DistributedFileSystem$DirListingIterator@287e35df

scala> while (tmp.hasNext) {
     |   println(tmp.next.getPath.toString)
     | }
hdfs://localhost:9000/user/root/saveTest/_SUCCESS
hdfs://localhost:9000/user/root/saveTest/part-00000
hdfs://localhost:9000/user/root/saveTest/part-00001

scala> fs.delete(path, true)
res7: Boolean = true

scala> fs.exists(path))
res8: Boolean = false
```
