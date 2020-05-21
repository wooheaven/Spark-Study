╠═1 Spark Installation  
║░╠═1 Install on Ubuntu 16.04  
║░║░╠═1 [install ssh](01_Spark_Installation/01_on_Ubuntu16.04/01_install_ssh/00_install_ssh.md)  
║░║░╠═2 [install jdk8](01_Spark_Installation/01_on_Ubuntu16.04/02_install_jdk8/00_install_jdk8.md)  
║░║░╠═3 [install hadoop2.8.5](01_Spark_Installation/01_on_Ubuntu16.04/03_install_hadoop2.8.5/00_install_hadoop2.8.5.md)  
║░║░╠═4 install spark2.4.4 with resource manager  
║░║░║░╠═1 [with spark standalone](01_Spark_Installation/01_on_Ubuntu16.04/04_install_spark2.4.4/01_spark_standalone/00_install_spark2.4.3.md)  
║░║░║░╚═2 [with hadoop yarn](01_Spark_Installation/01_on_Ubuntu16.04/04_install_spark2.4.4/02_hadoop_yarn/00_install_spark2.4.4.md)  
║░║░╚═5 [install jupyter and connect to pyspark](01_Spark_Installation/01_on_Ubuntu16.04/05_install_jupyter/00_install_jupyter_and_connect_pyspark.md)  
║░╠═2 Version Compatibility : [Spark, Java, Hadoop, Scala, Python, R : version compatibility](01_Spark_Installation/02_Spark_version/01_Spark_Java_Hadoop_Scala_Python_R_version.md)  
║░╚═3 ETC  
║░░░╚═1 [Solution : WARN spark.yarn.archive](01_Spark_Installation/03_ETC/01_Solution_of_WARN_spark_yarn_archive.md)  
╠═2 Spark Workspace  
║░╠═1 spark-shell  
║░║░╠═1 WordCount  
║░║░║░╠═1 [on spark](02_Spark_Workspace/01_spark-shell/01_WordCount/01_on_spark.md)  
║░║░║░╚═2 [on yarn](02_Spark_Workspace/01_spark-shell/01_WordCount/02_on_yarn.md)  
║░║░╠═2 PageRank  
║░║░║░╠═1 [on yarn](02_Spark_Workspace/01_spark-shell/02_PageRank/01_on_yarn.md)  
║░║░║░╚═2 [on yarn with graphframes](02_Spark_Workspace/01_spark-shell/02_PageRank/02_on_yarn_with_graphframes.md)  
║░║░╚═3 Pi Estimation  
║░║░░░╚═1 [on yarn](02_Spark_Workspace/01_spark-shell/03_Pi_Estimation/01_on_yarn.md)  
║░╠═2 spark-submit  
║░║░╠═1 WordCount  
║░║░║░╚═1 with JDK8  
║░║░║░░░╠═1 [Console Log](02_Spark_Workspace/02_spark-submit/02_with_JDK8/01_Spark-submit_WordCount.md)  
║░║░║░░░╚═2 [Source code](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/example/WordCount.java)  
║░║░╠═2 PageRank  
║░║░║░╚═1 with JDK8  
║░║░║░░░╠═1 [Console Log](02_Spark_Workspace/02_spark-submit/02_with_JDK8/02_Spark-submit_PageRank.md)  
║░║░║░░░╚═2 [Source code](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/example/PageRank.java)  
║░║░╚═3 Pi Estimation  
║░║░░░╚═1 with JDK8  
║░║░░░░░╠═1 [Console Log](02_Spark_Workspace/02_spark-submit/02_with_JDK8/03_Spark-submit_PiEstimation.md)  
║░║░░░░░╚═2 [Source code](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/example/PiEstimation.java)  
║░╚═3 pyspark  
║░░░╠═1 [Data Replication](02_Spark_Workspace/03_pyspark/01_Data_Replication/01_Data_Replication.ipynb)  
║░░░╠═2 [PageRank](02_Spark_Workspace/03_pyspark/02_PageRank/01_PageRank.ipynb)  
║░░░╚═3 [Pi Estimation](02_Spark_Workspace/03_pyspark/03_Pi_Estimation/01_Pi_Estimation.ipynb)  
╚═3 Spark Document  
░░╠═1 RDD paper  
░░║░╚═1 [RDD paper in Korean](03_Spark_Document/02_RDD_paper/01_Resilient_Distributed_Datasets_Essay_to_Korean.md)  
░░╠═2 [RDD programming guide](https://spark.apache.org/docs/latest/rdd-programming-guide.html)  
░░║░╚═1 [RDD](https://spark.apache.org/docs/latest/rdd-programming-guide.html#resilient-distributed-datasets-rdds)  
░░║░░░╠═1 [RDD Operations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#rdd-operations)  
░░║░░░║░╠═1 [Transformations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#transformations)  
░░║░░░║░║░╠═1 cartesian(otherDataset)  
░░║░░░║░║░╠═2 coalesce(numPartitions)  
░░║░░░║░║░╠═3 distinct([numPartitions]))  
░░║░░░║░║░╠═4 filter(func)  
░░║░░░║░║░╠═5 flatMap(func)  
░░║░░░║░║░╠═6 flatMapValues(func)  
░░║░░░║░║░╠═7 glom()  
░░║░░░║░║░╠═8 groupBy()  
░░║░░░║░║░╠═9 groupByKey([numPartitions])  
░░║░░░║░║░╠═10 intersection(otherDataset)  
░░║░░░║░║░╠═11 join(otherDataset, [numPartitions])  
░░║░░░║░║░╠═12 keyBy(func)  
░░║░░░║░║░╠═13 map(func)  
░░║░░░║░║░╠═14 mapPartitions(func)  
░░║░░░║░║░╠═15 mapPartitionsWithIndex(func)  
░░║░░░║░║░╠═16 mapValues(func)  
░░║░░░║░║░╠═17 partitionBy(numPartitions)  
░░║░░░║░║░╠═18 pipe(command, [envVars])  
░░║░░░║░║░╠═19 reduceByKey(func, [numPartitions])  
░░║░░░║░║░╠═20 sample(withReplacement, fraction, seed)  
░░║░░░║░║░╠═21 sortByKey([ascending], [numPartitions])  
░░║░░░║░║░╠═22 union(otherDataset)  
░░║░░░║░║░╚═23 zip(other)  
░░║░░░║░╚═2 [Actions](https://spark.apache.org/docs/latest/rdd-programming-guide.html#actions)  
░░║░░░║░░░╠═1 aggregate(zeroValue, seqOp, combOp)  
░░║░░░║░░░╠═2 collect()  
░░║░░░║░░░╠═3 fold(zeroValue, op)  
░░║░░░║░░░╠═4 foreach(func)  
░░║░░░║░░░╠═5 foreachPartition(func)  
░░║░░░║░░░╠═6 getNumPartitions()  
░░║░░░║░░░╠═7 saveAsTextFile(path)  
░░║░░░║░░░╠═8 reduce(func)  
░░║░░░║░░░╠═9 take(n)  
░░║░░░║░░░╠═10 takeOrdered(n, [ordering])  
░░║░░░║░░░╠═11 takeSample(withReplacement, num, [seed])  
░░║░░░║░░░╚═12 top(n, [ordering])  
░░║░░░╚═2 [RDD Persistemce](https://spark.apache.org/docs/latest/rdd-programming-guide.html#rdd-persistence)  
░░╠═3 Java : [Spark Java API (JavaDoc)](https://spark.apache.org/docs/latest/api/java/index.html)  
░░║░╚═1 package [org.apache.spark.api.java](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/package-summary.html)  
░░║░░░╠═1 package [function](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/package-summary.html)  
░░║░░░║░╠═1 interface  
░░║░░░║░║░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/FlatMapFunction.html), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapPartitionsTest.java#L73) of FlatMapFunction  
░░║░░░║░║░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function.html), example of Function  
░░║░░░║░║░║░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/MapValuesTest.java#L63) which map value to new pair  
░░║░░░║░║░║░╠═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/SortByTest.java#L64) which convert String toLowerCase  
░░║░░░║░║░║░╚═3 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/GroupByTest.java#L49) which assign element to a group  
░░║░░░║░║░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function2.html), example of Function2  
░░║░░░║░║░║░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapPartitionsWithIndexTest.java#L73) which each partition sum of RDD  
░░║░░░║░║░║░╚═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/ReduceByKeyTest.java#L64) which calculate x, y to x+y  
░░║░░░║░║░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFlatMapFunction.html), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/FlatMapToPairTest.java#L87) of PairFlatMapFunction  
░░║░░░║░║░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFunction.html), example of PairFunction  
░░║░░░║░║░║░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/MapToPairTest.java#L89) which pair with JavaPairRDD  
░░║░░░║░║░║░╚═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapToPairTest.java#L65) which pair with JavaRDD  
░░║░░░║░║░╚═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/VoidFunction.html), example of VoidFunction  
░░║░░░║░║░░░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/ForeachTest.java#L65) which foreach print and append to a file  
░░║░░░║░║░░░╚═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/ForeachPartitionTest.java#L71) which foreachPartition print and append to a file  
░░║░░░╠═2 class [JavaPairRDD.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html)  
░░║░░░║░╚═1 method  
░░║░░░║░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#flatMapToPair-org.apache.spark.api.java.function.PairFlatMapFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/FlatMapToPairTest.java) of JavaPairRDD.flatMapToPair  
░░║░░░║░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#flatMapValues-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/FlatMapValuesTest.java) of JavaPairRDD.flatMapValues  
░░║░░░║░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#groupByKey--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/GroupByKeyTest.java) of JavaPairRDD.groupByKey  
░░║░░░║░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#join-org.apache.spark.api.java.JavaPairRDD-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/JoinTest.java) of JavaPairRDD.join  
░░║░░░║░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/MapToPairTest.java) of JavaPairRDD.maptoPair  
░░║░░░║░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapValues-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/MapValuesTest.java) of JavaPairRDD.mapValues  
░░║░░░║░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#partitionBy-org.apache.spark.Partitioner-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/PartitionByTest.java) of JavaPairRDD.partitionBy  
░░║░░░║░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#sortByKey-java.util.Comparator-boolean-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/SortByKeyTest.java) of JavaPairRDD.sortByKey  
░░║░░░║░░░╚═9 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#reduceByKey-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/ReduceByKeyTest.java) of JavaPairRDD.reduceByKey  
░░║░░░╠═3 class [JavaRDD.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html)  
░░║░░░║░╚═1 method  
░░║░░░║░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#aggregate-U-org.apache.spark.api.java.function.Function2-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/AggregateTest.java) of JavaRDD.aggregate : sum and product of values  
░░║░░░║░░░╠═2 doc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/AggregateKeepValuesTest.java) of JavaRDD.aggregate : sum of values with keep values  
░░║░░░║░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#cache--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javapairrdd/FlatMapToPairTest.java#L32) of JavaRDD.cache  
░░║░░░║░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#coalesce-int-boolean-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/CoalesceTest.java) of JavaRDD.coalesce  
░░║░░░║░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#distinct--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/DistinctTest.java) of JavaRDD.distinct  
░░║░░░║░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#filter-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/FilterTest.java) of JavaRDD.filter  
░░║░░░║░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#flatMap-org.apache.spark.api.java.function.FlatMapFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/FlatMapTest.java) of JavaRDD.flatMap  
░░║░░░║░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#fold-T-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/FoldTest.java) of JavaRDD.fold  
░░║░░░║░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#foreach-org.apache.spark.api.java.function.VoidFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/ForeachTest.java) of JavaRDD.foreach  
░░║░░░║░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#foreachPartition-org.apache.spark.api.java.function.VoidFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/ForeachPartitionTest.java) of JavaRDD.foreachPartition  
░░║░░░║░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#getNumPartitions--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/GetNumPartitionsTest.java) of JavaRDD.getNumPartitions  
░░║░░░║░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#glom--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/GlomTest.java) of JavaRDD.glom  
░░║░░░║░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#groupBy-org.apache.spark.api.java.function.Function-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/GroupByTest.java) of JavaRDD.groupBy  
░░║░░░║░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#intersection-org.apache.spark.api.java.JavaRDD-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/IntersectionTest.java) of JavaRDD.intersection  
░░║░░░║░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#keyBy-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/KeyByTest.java) of JavaRDD.keyBy  
░░║░░░║░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#map-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapTest.java) of JavaRDD.map  
░░║░░░║░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitions-org.apache.spark.api.java.function.FlatMapFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapPartitionsTest.java) of JavaRDD.mapPartitions  
░░║░░░║░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitionsWithIndex-org.apache.spark.api.java.function.Function2-boolean-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapPartitionsWithIndexTest.java) of JavaRDD.mapPartitionsWithIndex  
░░║░░░║░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/MapToPairTest.java) of JavaRDD.maptoPair  
░░║░░░║░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#pipe-java.lang.String-), [example argument error](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/PipeTest.java) of JavaRDD.pipe  
░░║░░░║░░░╠═21 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#reduce-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/ReduceTest.java) of JavaRDD.reduce  
░░║░░░║░░░╠═22 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#sample-boolean-double-long-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/SampleTest.java) of JavaRDD.sample  
░░║░░░║░░░╠═23 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#sortBy-org.apache.spark.api.java.function.Function-boolean-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/SortByTest.java) of JavaRDD.sortBy  
░░║░░░║░░░╠═24 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#take-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/TakeTest.java) of JavaRDD.take  
░░║░░░║░░░╠═25 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#takeOrdered-int-java.util.Comparator-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/TakeOrderedTest.java) of JavaRDD.takeOrdered  
░░║░░░║░░░╠═26 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#takeSample-boolean-int-long-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/TakeSampleTest.java) of JavaRDD.takeSample  
░░║░░░║░░░╠═27 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#top-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/TopTest.java) of JavaRDD.top  
░░║░░░║░░░╚═28 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#union-org.apache.spark.api.java.JavaRDD-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javardd/UnionTest.java) of JavaRDD.union  
░░║░░░╚═4 Interface [JavaRDDLike.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDDLike.html)  
░░║░░░░░╚═1 method  
░░║░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDDLike.html#cartesian-org.apache.spark.api.java.JavaRDDLike-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javarddlike/CartesianTest.java) of JavaRDDLike.cartesian  
░░║░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDDLike.html#collect--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javarddlike/CollectTest.java) of JavaRDDLike.collect  
░░║░░░░░░░╚═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDDLike.html#zip-org.apache.spark.api.java.JavaRDDLike-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/javarddlike/ZipTest.java) of JavaRDD.zip  
░░╠═4 Python API [doc](https://spark.apache.org/docs/latest/api/python/)  
░░║░╚═1 package pyspark [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/) on modules, [source code](https://github.com/apache/spark/tree/v2.4.4/python/pyspark) on Github  
░░║░░░╠═1 package sql [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/) on modules  
░░║░░░║░╚═1 file session.py [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/session.html) on modules and [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py) on Github, class SparkSession [doc](https://spark.apache.org/docs/latest/api/python/pyspark.sql.html#pyspark.sql.SparkSession)  
░░║░░░║░░░╚═1 method RDD.toDF (monkey patch of RDD) [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py#L44) on Github, [example](03_Spark_Document/04_Python/01_package_pyspark/01_package_sql/01_file_session.py/05_example/01_RDD.toDF_example.ipynb) on Jupyter notebook  
░░║░░░╚═2 file rdd.py [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/rdd.html#RDD) on modules and [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/rdd.py) on Github, class RDD [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD)  
░░║░░░░░╚═1 method  
░░║░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.aggregate), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/01_RDD.aggregate_example.ipynb) on Jupyter notebook of RDD.aggregate : sum and product of values  
░░║░░░░░░░╠═2 doc, [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/02_RDD.aggregateKeepValues_example.ipynb) on Jupyter notebook of RDD.aggregateKeepValues : sum of values with keep values  
░░║░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.cache), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/03_RDD.cache_examle.ipynb) on Jupyter notebook of RDD.cache  
░░║░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.cartesian), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/04_RDD.cartesian_example.ipynb) on Jupyter notebook of RDD.cartesian  
░░║░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/rdd.html#RDD.coalesce), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/05_RDD.coalesce_example.ipynb) on Jupyter notebook of RDD.coalesce  
░░║░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.collect), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/06_RDD.collect_example.ipynb) on Jupyter notebook of RDD.collect  
░░║░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.distinct), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/07_RDD.distinct_example.ipynb) on Jupyter notebook of RDD.distinct  
░░║░░░░░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.filter), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/08_RDD.filter_example.ipynb) on Jupyter notebook of RDD.filter  
░░║░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.flatMap), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/09_RDD.flatMap_example.ipynb) on Jupyter notebook of RDD.flatMap  
░░║░░░░░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.flatMapValues), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/10_RDD.flatMapValue_example.ipynb) on Jupyter notebook of RDD.flatMapValue  
░░║░░░░░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.fold), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/11_RDD.fold_example.ipynb) on Jupyter notebook of RDD.fold  
░░║░░░░░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.foreach), [example can't work](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/12_RDD.foreach_example.ipynb) on Jupyter notebook of RDD.foreach  
░░║░░░░░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.foreachPartition), [example can't work](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/13_RDD.foreachPartition_example.ipynb) on Jupyter notebook of RDD.foreachPartition  
░░║░░░░░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.getNumPartitions), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/14_RDD.getNumPartitions_example.ipynb) on Jupyter notebook of RDD.getNumPartitions  
░░║░░░░░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.glom), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/15_RDD.glom_example.ipynb) on Jupyter notebook of RDD.glom  
░░║░░░░░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.groupBy), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/16_RDD.groupBy_example.ipynb) on Jupyter notebook of RDD.groupBy  
░░║░░░░░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.groupByKey), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/17_RDD.groupByKey_example.ipynb) on Jupyter notebook of RDD.groupByKey  
░░║░░░░░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.intersection), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/18_RDD.itersection_example.ipynb) on Jupyter notebook of RDD.intersection  
░░║░░░░░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.join), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/19_RDD.join_example.ipynb) on Jupyter notebook of RDD.join  
░░║░░░░░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.keyBy), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/20_RDD.keyBy_example.ipynb) on Jupyter notebook of RDD.keyBy  
░░║░░░░░░░╠═21 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.map), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/21_RDD.map_example.ipynb) on Jupyter notebook of RDD.map  
░░║░░░░░░░╠═22 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitions), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/22_RDD.mapPartitions_example.ipynb) on Jupyter notebook of RDD.mapPartitions  
░░║░░░░░░░╠═23 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitionsWithIndex), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/23_RDD.mapPartitionsWithIndex_example.ipynb) on Jupyter notebook of RDD.mapPartitionsWithIndex  
░░║░░░░░░░╠═24 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapValues), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/24_RDD.mapValues_example.ipynb) on Jupyter notebook of RDD.mapValues  
░░║░░░░░░░╠═25 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.max), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/25_RDD.max_example.ipynb) on Jupyter notebook of RDD.max  
░░║░░░░░░░╠═26 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mean), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/26_RDD.mean_example.ipynb) on Jupyter notebook of RDD.mean  
░░║░░░░░░░╠═27 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.partitionBy), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/27_RDD.partitionBy_example.ipynb) on Jupyter notebook of RDD.partitionBy  
░░║░░░░░░░╠═28 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.pipe), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/28_RDD.pipe_example.ipynb) on Jupyter notebook of RDD.pipe  
░░║░░░░░░░╠═29 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.reduce), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/29_RDD.reduce_example.ipynb) on Jupyter notebook of RDD.reduce  
░░║░░░░░░░╠═30 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.reduceByKey), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/30_RDD.reduceByKey_example.ipynb) on Jupyter notebook of RDD.reduceByKey  
░░║░░░░░░░╠═31 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sample), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/31_RDD.sample_example.ipynb) on Jupyter notebook of RDD.sample  
░░║░░░░░░░╠═32 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortBy), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/32_RDD.sortBy_example.ipynb) on Jupyter notebook of RDD.sortBy  
░░║░░░░░░░╠═33 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortByKey), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/33_RDD.sortByKey_example.ipynb) on Jupyter notebook of RDD.sortByKey  
░░║░░░░░░░╠═34 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.stdev), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/34_RDD.stdev_example.ipynb) on Jupyter notebook of RDD.stdev  
░░║░░░░░░░╠═35 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sum), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/35_RDD.sum_example.ipynb) on Jupyter notebook of RDD.sum  
░░║░░░░░░░╠═36 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.take), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/36_RDD.take_example.ipynb) on Jupyter notebook of RDD.take  
░░║░░░░░░░╠═37 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.takeOrdered), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/37_RDD.takeOrdered_example.ipynb) on Jupyter notebook of RDD.takeOrdered  
░░║░░░░░░░╠═38 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.takeSample), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/38_RDD.takeSample_example.ipynb) on Jupyter notebook of RDD.takeSample  
░░║░░░░░░░╠═39 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.top), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/39_RDD.top_example.ipynb) on Jupyter notebook of RDD.top  
░░║░░░░░░░╠═40 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.SparkContext.union), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/40_RDD.union_example.ipynb) on Jupyter notebook of RDD.union  
░░║░░░░░░░╚═41 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.zip), [example](03_Spark_Document/04_Python/01_package_pyspark/02_file_rdd.py/03_example/41_RDD.zip_example.ipynb) on Jupyter notebook of RDD.zip  
░░╚═5 Scala API [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.package)  
░░░░╚═1 package org.apache.spark [source code](https://github.com/apache/spark/tree/v2.4.4/core/src/main/scala/org/apache/spark) on Github  
░░░░░░╚═1 package rdd [source code](https://github.com/apache/spark/tree/v2.4.4/core/src/main/scala/org/apache/spark/rdd) on Github  
░░░░░░░░╠═1 class DoubleRDDFunctions [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.DoubleRDDFunctions), [source code](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/rdd/DoubleRDDFunctions.scala) on Github  
░░░░░░░░║░╚═1 Value Members  
░░░░░░░░║░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.DoubleRDDFunctions@mean():Double), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/doublerddfunctions/Mean.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/01_class_DoubleRDDFunctions/01_Value_Members/01_DoubleRDDFunctions.mean_example.md) on spark-shell of DoubleRDDFunctions.mean  
░░░░░░░░║░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.DoubleRDDFunctions@stdev():Double), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/doublerddfunctions/Stdev.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/01_class_DoubleRDDFunctions/01_Value_Members/02_DoubleRDDFunctions.stdev_example.md) on spark-shell of DoubleRDDFunctions.stdev  
░░░░░░░░║░░░╚═3 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.DoubleRDDFunctions@sum():Double), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/doublerddfunctions/Sum.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/01_class_DoubleRDDFunctions/01_Value_Members/03_DoubleRDDFunctions.sum_example.md) on spark-shell of DoubleRDDFunctions.sum  
░░░░░░░░╠═2 class PairRDDFunctions [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions), [source code](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/rdd/PairRDDFunctions.scala) on Github  
░░░░░░░░║░╚═1 Value Members  
░░░░░░░░║░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@flatMapValues[U](f:V=%3ETraversableOnce[U]):org.apache.spark.rdd.RDD[(K,U)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/pairrddfunctions/FlatMapValues.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/02_class_PairRDDFunctions/01_Value_Members/01_PairRDDFunctions.flatMapValues_example.md) on spark-shell of PairRDDFunctions.flatMapValues  
░░░░░░░░║░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@groupByKey():org.apache.spark.rdd.RDD[(K,Iterable[V])]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/pairrddfunctions/GroupByKey.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/02_class_PairRDDFunctions/01_Value_Members/02_PairRDDFunctions.groupByKey_example.md) on spark-shell of PairRDDFunctions.groupByKey  
░░░░░░░░║░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@join[W](other:org.apache.spark.rdd.RDD[(K,W)]):org.apache.spark.rdd.RDD[(K,(V,W))]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/pairrddfunctions/Join.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/02_class_PairRDDFunctions/01_Value_Members/03_PairRDDFunctions.join_example.md) on spark-shell of PairRDDFunctions.join  
░░░░░░░░║░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@mapValues[U](f:V=%3EU):org.apache.spark.rdd.RDD[(K,U)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/pairrddfunctions/MapValues.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/02_class_PairRDDFunctions/01_Value_Members/04_PairRDDFunctions.mapValues_example.md) on spark-shell of PairRDDFunctions.mapValues  
░░░░░░░░║░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@partitionBy(partitioner:org.apache.spark.Partitioner):org.apache.spark.rdd.RDD[(K,V)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/pairrddfunctions/PartitionBy.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/02_class_PairRDDFunctions/01_Value_Members/05_PairRDDFunctions.partitionBy_example.md) on spark-shell of PairRDDFunctions.partitionBy  
░░░░░░░░║░░░╚═6 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@reduceByKey(func:(V,V)=%3EV):org.apache.spark.rdd.RDD[(K,V)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/pairrddfunctions/ReduceByKey.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/02_class_PairRDDFunctions/01_Value_Members/06_PairRDDFunctions.reduceByKey_example.md) on spark-shell of PairRDDFunctions.reduceByKey  
░░░░░░░░╚═3 class RDD [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD), [source code](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/rdd/RDD.scala) on Github  
░░░░░░░░░░╚═1 Concrete Value Members  
░░░░░░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@aggregate[U](zeroValue:U)(seqOp:(U,T)=%3EU,combOp:(U,U)=%3EU)(implicitevidence$31:scala.reflect.ClassTag[U]):U), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Aggregate.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/01_RDD.aggregate_example.md) on spark-shell of RDD.aggregate : sum and product of values  
░░░░░░░░░░░░╠═2 doc, [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/AggregateKeepValues.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/02_RDD.aggregateKeepValues_example.md) on spark-shell of RDD.aggregate : sum of values with keep values  
░░░░░░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@cache():RDD.this.type), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Cache.scala#L15) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/03_RDD.cache_example.md) on spark-shell of RDD.cache  
░░░░░░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@coalesce(numPartitions:Int,shuffle:Boolean,partitionCoalescer:Option[org.apache.spark.rdd.PartitionCoalescer])(implicitord:Ordering[T]):org.apache.spark.rdd.RDD[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Coalesce.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/04_RDD.coalesce_example.md) on spark-shell of RDD.coalesce  
░░░░░░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@collect():Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Collect.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/05_RDD.collect_example.md) on spark-shell of RDD.collect  
░░░░░░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@distinct(numPartitions:Int)(implicitord:Ordering[T]):org.apache.spark.rdd.RDD[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Distinct.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/06_RDD.distinct_example.md) on spark-shell of RDD.distinct  
░░░░░░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@flatMap[U](f:T=%3ETraversableOnce[U])(implicitevidence$4:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/FlatMap.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/07_RDD.flatMap_example.md) on spark-shell of RDD.flatMap : Sentence to words  
░░░░░░░░░░░░╠═8 doc, example on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/08_RDD.flatMapCase_example.md) on spark-shell of RDD.flatMap : PageRank's CurrentLinks to NextLinks  
░░░░░░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@fold(zeroValue:T)(op:(T,T)=%3ET):T), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Fold.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/09_RDD.fold_example.md) on spark-shell of RDD.fold  
░░░░░░░░░░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@getNumPartitions:Int), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/GetNumPartitions.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/10_RDD.getNumPartitions_example.md) on spark-shell of RDD.getNumPartitions  
░░░░░░░░░░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@keyBy[K](f:T=%3EK):org.apache.spark.rdd.RDD[(K,T)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/KeyBy.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/11_RDD.keyBy_example.md) on spark-shell of RDD.keyBy  
░░░░░░░░░░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@map[U](f:T=%3EU)(implicitevidence$3:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Map.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/12_RDD.map_example.md) on spark-shell of RDD.map  
░░░░░░░░░░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@mapPartitionsWithIndex[U](f:(Int,Iterator[T])=%3EIterator[U],preservesPartitioning:Boolean)(implicitevidence$9:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/MapPartitionsWithIndex.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/13_RDD.mapPartitionsWithIndex_example.md) on spark-shell of RDD.mapPartitionsWithIndex  
░░░░░░░░░░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@max()(implicitord:Ordering[T]):T), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Max.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/14_RDD.max_example.md) on spark-shell of RDD.max  
░░░░░░░░░░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@reduce(f:(T,T)=%3ET):T), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Reduce.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/14_RDD.reduce_example.md) on spark-shell of RDD.reduce  
░░░░░░░░░░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@sample(withReplacement:Boolean,fraction:Double,seed:Long):org.apache.spark.rdd.RDD[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Sample.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/15_RDD.sample_example.md) on spark-shell of RDD.sample  
░░░░░░░░░░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@take(num:Int):Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Take.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/16_RDD.take_example.md) on spark-shell of RDD.take  
░░░░░░░░░░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@takeOrdered(num:Int)(implicitord:Ordering[T]):Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/TakeOrdered.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/17_RDD.takeOrdered_example.md) on spark-shell of RDD.takeOrdered  
░░░░░░░░░░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@top(num:Int)(implicitord:Ordering[T]):Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Top.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/18_RDD.top_example.md) on spark-shell of RDD.top  
░░░░░░░░░░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@union(other:org.apache.spark.rdd.RDD[T]):org.apache.spark.rdd.RDD[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/rdd/Union.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/19_RDD.union_example.md) on spark-shell of RDD.union  
░░░░░░░░░░░░╚═21 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@zip[U](other:org.apache.spark.rdd.RDD[U])(implicitevidence$10:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[(T,U)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Zip.scala) on spark-submit, [example](03_Spark_Document/05_Scala/01_package_org.apache.spark/01_package_rdd/03_class_RDD/01_Concrete_Value_Members/20_RDD.zip_example.md) on spark-shell of RDD.zip  

# Example of Spark

[List\<Tuple2\<String,String\>\> to JavaPairRDD\<String,String\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/ListTupleToJavaPairRDDTest.java)

[MapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapToDoubleTest.java)

[FlatMapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapToDoubleTest.java)

[Column to Rows as Pivot](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ColumnToRowsTest.java)
