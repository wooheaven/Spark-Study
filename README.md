╠═1 Spark Installation  
║░╠═1 Install on Ubuntu 16.04  
║░║░╠═1 [install ssh](01_Spark_Installation/01_on_Ubuntu16.04/01_install_ssh/00_install_ssh.md)  
║░║░╠═2 [install jdk8](01_Spark_Installation/01_on_Ubuntu16.04/02_install_jdk8/00_install_jdk8.md)  
║░║░╠═3 [install hadoop2.8.5](01_Spark_Installation/01_on_Ubuntu16.04/03_install_hadoop2.8.5/00_install_hadoop2.8.5.md)  
║░║░╠═4 install spark2.4.4 with resource manager  
║░║░║░╠═1 [with spark standalone](01_Spark_Installation/01_on_Ubuntu16.04/04_install_spark2.4.4/01_spark_standalone/00_install_spark2.4.3.md)  
║░║░║░╚═2 [with hadoop yarn](01_Spark_Installation/01_on_Ubuntu16.04/04_install_spark2.4.4/02_hadoop_yarn/00_install_spark2.4.4.md)  
║░║░╚═5 [install jupyter and connect to pyspark](01_Spark_Installation/01_on_Ubuntu16.04/05_install_jupyter/00_install_jupyter_and_connect_pyspark.md)  
║░╠═2 Version Compatibility  
║░║░╚═1 [Spark, Java, Hadoop, Scala, Python, R : version compatibility](01_Spark_Installation/02_Spark_version/01_Spark_Java_Hadoop_Scala_Python_R_version.md)  
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
║░░░╚═2 [Pi Estimation](02_Spark_Workspace/03_pyspark/02_Pi_Estimation/01_Pi_Estimation.ipynb)  
╚═3 Spark Document  
░░╠═1 RDD API doc  
░░║░╠═1 Java  
░░║░║░╠═1 [PairFlatMapFunction](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFlatMapFunction.html)  
░░║░║░║░╚═1 [example : CustomPairFlatMapFunction](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/pairflatmapfunction/CustomPairFlatMapFunction.java)  
░░║░║░╚═2 [Partitioner](https://spark.apache.org/docs/latest/api/java/org/apache/spark/Partitioner.html)  
░░║░║░░░╚═1 [example : CustomPartitioner](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/partitioner/CustomPartitioner.java)  
░░║░╚═2 Scala  
░░║░░░╚═1 [flatMap](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@flatMap[U](f:T=%3ETraversableOnce[U])(implicitevidence$4:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U])  
░░║░░░░░╠═1 [example on spark-shell : flatMap case map](03_Spark_Document/01_RDD_API_doc/02_Scala/01_flatMap/01_flatMap_case_map_example.md)  
░░║░░░░░╚═2 [example on spark-shell : flatMap](03_Spark_Document/01_RDD_API_doc/02_Scala/01_flatMap/02_flatMap_example.md)  
░░╠═2 RDD paper  
░░║░╚═1 [RDD paper in Korean](03_Spark_Document/02_RDD_paper/01_Resilient_Distributed_Datasets_Essay_to_Korean.md)  
░░╠═3 [RDD programming guide](https://spark.apache.org/docs/latest/rdd-programming-guide.html)  
░░║░╚═1 [RDD](https://spark.apache.org/docs/latest/rdd-programming-guide.html#resilient-distributed-datasets-rdds)  
░░║░░░╠═1 [RDD Operations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#rdd-operations)  
░░║░░░║░╠═1 [Transformations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#transformations)  
░░║░░░║░║░╠═1 cartesian(otherDataset)  
░░║░░░║░║░╠═2 coalesce(numPartitions)  
░░║░░░║░║░╠═3 distinct([numPartitions]))  
░░║░░░║░║░╠═4 filter(func)  
░░║░░░║░║░╠═5 flatMap(func)  
░░║░░░║░║░╠═6 glom()  
░░║░░░║░║░╠═7 groupBy()  
░░║░░░║░║░╠═8 groupByKey([numPartitions])  
░░║░░░║░║░╠═9 intersection(otherDataset)  
░░║░░░║░║░╠═10 keyBy(func)  
░░║░░░║░║░╠═11 map(func)  
░░║░░░║░║░╠═12 mapPartitions(func)  
░░║░░░║░║░╠═13 mapPartitionsWithIndex(func)  
░░║░░░║░║░╠═14 partitionBy(numPartitions)  
░░║░░░║░║░╠═15 pipe(command, [envVars])  
░░║░░░║░║░╠═16 reduceByKey(func, [numPartitions])  
░░║░░░║░║░╠═17 sample(withReplacement, fraction, seed)  
░░║░░░║░║░╠═18 sortByKey([ascending], [numPartitions])  
░░║░░░║░║░╠═19 union(otherDataset)  
░░║░░░║░║░╚═20 zip(other)  
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
░░╠═4 Pair RDD functions doc  
░░║░╠═1 Scala  
░░║░║░╠═1 [flatMapValues](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@flatMapValues[U](f:V=%3ETraversableOnce[U]):org.apache.spark.rdd.RDD[(K,U)])  
░░║░║░║░╚═1 [example on spark-shell : flatMapValues](03_Spark_Document/04_Pair_RDD_functions_doc/01_for_Scala/01_flatMapValues_example.md)  
░░║░║░╠═2 [groupByKey](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@groupByKey():org.apache.spark.rdd.RDD[(K,Iterable[V])])  
░░║░║░║░╚═1 [example on spark-shell : groupByKey](03_Spark_Document/04_Pair_RDD_functions_doc/01_for_Scala/02_groupByKey_example.md)  
░░║░║░╠═3 [join](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@join[W](other:org.apache.spark.rdd.RDD[(K,W)]):org.apache.spark.rdd.RDD[(K,(V,W))])  
░░║░║░║░╚═1 [example on spark-shell : join](03_Spark_Document/04_Pair_RDD_functions_doc/01_for_Scala/03_join_example.md)  
░░║░║░╠═4 [mapValues](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@mapValues[U](f:V=%3EU):org.apache.spark.rdd.RDD[(K,U)])  
░░║░║░║░╚═1 [example on spark-shell : mapValues](03_Spark_Document/04_Pair_RDD_functions_doc/01_for_Scala/04_mapValues_example.md)  
░░║░║░╚═5 [reduceByKey](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@reduceByKey(func:(V,V)=%3EV):org.apache.spark.rdd.RDD[(K,V)])  
░░║░║░░░╚═1 [example on spark-shell : reduceByKey](03_Spark_Document/04_Pair_RDD_functions_doc/01_for_Scala/05_reduceByKey_example.md)  
░░║░╚═2 Java  
░░║░░░╚═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#partitionBy-org.apache.spark.Partitioner-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/PartitionByTest.java) of JavaPairRDD.partitionBy  
░░╠═5 Java : [Spark Java API (JavaDoc)](https://spark.apache.org/docs/latest/api/java/index.html)  
░░║░╚═1 package [org.apache.spark.api.java](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/package-summary.html)  
░░║░░░╠═1 package [function](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/package-summary.html)  
░░║░░░║░╠═1 interface  
░░║░░░║░║░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/FlatMapFunction.html), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsTest.java#L73) of FlatMapFunction  
░░║░░░║░║░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function.html), example of Function  
░░║░░░║░║░║░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapValuesTest.java#L63) which map value to new pair  
░░║░░░║░║░║░╠═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/SortByTest.java#L64) which convert String toLowerCase  
░░║░░░║░║░║░╚═3 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GroupByTest.java#L49) which assign element to a group  
░░║░░░║░║░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function2.html), example of Function2  
░░║░░░║░║░║░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsWithIndexTest.java#L73) which each partition sum of RDD  
░░║░░░║░║░║░╚═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/ReduceByKeyTest.java#L64) which calculate x, y to x+y  
░░║░░░║░║░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFlatMapFunction.html), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/FlatMapToPairTest.java#L87) of PairFlatMapFunction  
░░║░░░║░║░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFunction.html), example of PairFunction  
░░║░░░║░║░║░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapToPairTest.java#L89) which pair with JavaPairRDD  
░░║░░░║░║░║░╚═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapToPairTest.java#L65) which pair with JavaRDD  
░░║░░░║░║░╚═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/VoidFunction.html), example of VoidFunction  
░░║░░░║░║░░░╠═1 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ForeachTest.java#L65) which foreach print and append to a file  
░░║░░░║░║░░░╚═2 [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ForeachPartitionTest.java#L71) which foreachPartition print and append to a file  
░░║░░░╠═2 class [JavaPairRDD.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html)  
░░║░░░║░╚═1 method  
░░║░░░║░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#flatMapToPair-org.apache.spark.api.java.function.PairFlatMapFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/FlatMapToPairTest.java) of JavaPairRDD.flatMapToPair  
░░║░░░║░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#groupByKey--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/GroupByKeyTest.java) of JavaPairRDD.groupByKey  
░░║░░░║░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#join-org.apache.spark.api.java.JavaPairRDD-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/JoinTest.java) of JavaPairRDD.join  
░░║░░░║░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapToPairTest.java) of JavaPairRDD.maptoPair  
░░║░░░║░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapValues-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapValuesTest.java) of JavaPairRDD.mapValues  
░░║░░░║░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#partitionBy-org.apache.spark.Partitioner-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/PartitionByTest.java) of JavaPairRDD.partitionBy  
░░║░░░║░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#sortByKey-java.util.Comparator-boolean-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/SortByKeyTest.java) of JavaPairRDD.sortByKey  
░░║░░░║░░░╚═8 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#reduceByKey-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/ReduceByKeyTest.java) of JavaPairRDD.reduceByKey  
░░║░░░╚═3 class [JavaRDD.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html)  
░░║░░░░░╚═1 method  
░░║░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#aggregate-U-org.apache.spark.api.java.function.Function2-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/AggregateTest.java) of JavaRDD.aggregate  
░░║░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#cache--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/FlatMapToPairTest.java#L32) of JavaRDD.cache  
░░║░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#cartesian-org.apache.spark.api.java.JavaRDDLike-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/CartesianTest.java) of JavaRDD.cartesian  
░░║░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#coalesce-int-boolean-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/CoalesceTest.java) of JavaRDD.coalesce  
░░║░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#distinct--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/DistinctTest.java) of JavaRDD.distinct  
░░║░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#filter-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FilterTest.java) of JavaRDD.filter  
░░║░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#flatMap-org.apache.spark.api.java.function.FlatMapFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FlatMapTest.java) of JavaRDD.flatMap  
░░║░░░░░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#fold-T-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FoldTest.java) of JavaRDD.fold  
░░║░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#foreach-org.apache.spark.api.java.function.VoidFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ForeachTest.java) of JavaRDD.foreach  
░░║░░░░░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#foreachPartition-org.apache.spark.api.java.function.VoidFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ForeachPartitionTest.java) of JavaRDD.foreachPartition  
░░║░░░░░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#getNumPartitions--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GetNumPartitionsTest.java) of JavaRDD.getNumPartitions  
░░║░░░░░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#glom--), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GlomTest.java) of JavaRDD.glom  
░░║░░░░░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#groupBy-org.apache.spark.api.java.function.Function-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GroupByTest.java) of JavaRDD.groupBy  
░░║░░░░░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#intersection-org.apache.spark.api.java.JavaRDD-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/IntersectionTest.java) of JavaRDD.intersection  
░░║░░░░░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#keyBy-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/KeyByTest.java) of JavaRDD.keyBy  
░░║░░░░░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#map-org.apache.spark.api.java.function.Function-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapTest.java) of JavaRDD.map  
░░║░░░░░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitions-org.apache.spark.api.java.function.FlatMapFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsTest.java) of JavaRDD.mapPartitions  
░░║░░░░░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitionsWithIndex-org.apache.spark.api.java.function.Function2-boolean-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsWithIndexTest.java) of JavaRDD.mapPartitionsWithIndex  
░░║░░░░░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapToPairTest.java) of JavaRDD.maptoPair  
░░║░░░░░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#pipe-java.lang.String-), [example argument error](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/PipeTest.java) of JavaRDD.pipe  
░░║░░░░░░░╠═21 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#reduce-org.apache.spark.api.java.function.Function2-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ReduceTest.java) of JavaRDD.reduce  
░░║░░░░░░░╠═22 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#sample-boolean-double-long-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/SampleTest.java) of JavaRDD.sample  
░░║░░░░░░░╠═23 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#sortBy-org.apache.spark.api.java.function.Function-boolean-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/SortByTest.java) of JavaRDD.sortBy  
░░║░░░░░░░╠═24 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#take-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TakeTest.java) of JavaRDD.take  
░░║░░░░░░░╠═25 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#takeOrdered-int-java.util.Comparator-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TakeOrderedTest.java) of JavaRDD.takeOrdered  
░░║░░░░░░░╠═26 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#takeSample-boolean-int-long-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TakeSampleTest.java) of JavaRDD.takeSample  
░░║░░░░░░░╠═27 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#top-int-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TopTest.java) of JavaRDD.top  
░░║░░░░░░░╠═28 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#union-org.apache.spark.api.java.JavaRDD-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/UnionTest.java) of JavaRDD.union  
░░║░░░░░░░╚═29 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#zip-org.apache.spark.api.java.JavaRDDLike-), [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ZipTest.java) of JavaRDD.zip  
░░╠═6 Python API [doc](https://spark.apache.org/docs/latest/api/python/)  
░░║░╚═1 package pyspark [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/) on modules, [source code](https://github.com/apache/spark/tree/v2.4.4/python/pyspark) on Github  
░░║░░░╠═1 package sql [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/) on modules  
░░║░░░║░╚═1 file session.py [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/session.html) on modules and [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py) on Github, class SparkSession [doc](https://spark.apache.org/docs/latest/api/python/pyspark.sql.html#pyspark.sql.SparkSession)  
░░║░░░║░░░╚═1 method RDD.toDF (monkey patch of RDD) [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py#L44) on Github, [example](03_Spark_Document/06_Python/01_package_pyspark/01_package_sql/01_file_session.py/05_example/01_RDD.toDF_example.ipynb) on Jupyter notebook  
░░║░░░╚═2 file rdd.py [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/rdd.html#RDD) on modules and [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/rdd.py) on Github, class RDD [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD)  
░░║░░░░░╚═1 method  
░░║░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.aggregate), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/01_RDD.aggregate.ipynb) on Jupyter notebook of RDD.aggregate  
░░║░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.cache), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/02_RDD.cache_examle.ipynb) on Jupyter notebook of RDD.cache  
░░║░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.cartesian), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/03_RDD.cartesian_example.ipynb) on Jupyter notebook of RDD.cartesian  
░░║░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/rdd.html#RDD.coalesce), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/04_RDD.coalesce_example.ipynb) on Jupyter notebook of RDD.coalesce  
░░║░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.distinct), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/05_RDD.distinct_example.ipynb) on Jupyter notebook of RDD.distinct  
░░║░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.filter), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/06_RDD.filter_example.ipynb) on Jupyter notebook of RDD.filter  
░░║░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.flatMap), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/07_RDD.flatMap_example.ipynb) on Jupyter notebook of RDD.flatMap  
░░║░░░░░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.flatMapValues), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/08_RDD.flatMapValue_example.ipynb) on Jupyter notebook of RDD.flatMapValue  
░░║░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.fold), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/09_RDD.fold_example.ipynb) on Jupyter notebook of RDD.fold  
░░║░░░░░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.foreach), [example can't work](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/10_RDD.foreach_example.ipynb) on Jupyter notebook of RDD.foreach  
░░║░░░░░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.foreachPartition), [example can't work](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/11_RDD.foreachPartition_example.ipynb) on Jupyter notebook of RDD.foreachPartition  
░░║░░░░░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.getNumPartitions), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/12_RDD.getNumPartitions_example.ipynb) on Jupyter notebook of RDD.getNumPartitions  
░░║░░░░░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.glom), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/13_RDD.glom_example.ipynb) on Jupyter notebook of RDD.glom  
░░║░░░░░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.groupBy), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/14_RDD.groupBy_example.ipynb) on Jupyter notebook of RDD.groupBy  
░░║░░░░░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.groupByKey), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/15_RDD.groupByKey_example.ipynb) on Jupyter notebook of RDD.groupByKey  
░░║░░░░░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.intersection), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/16_RDD.itersection_example.ipynb) on Jupyter notebook of RDD.intersection  
░░║░░░░░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.keyBy), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/17_RDD.keyBy_example.ipynb) on Jupyter notebook of RDD.keyBy  
░░║░░░░░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.map), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/18_RDD.map_example.ipynb) on Jupyter notebook of RDD.map  
░░║░░░░░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitions), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/19_RDD.mapPartitions_example.ipynb) on Jupyter notebook of RDD.mapPartitions  
░░║░░░░░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitionsWithIndex), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/20_RDD.mapPartitionsWithIndex_example.ipynb) on Jupyter notebook of RDD.mapPartitionsWithIndex  
░░║░░░░░░░╠═21 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.partitionBy), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/21_RDD.partitionBy_example.ipynb) on Jupyter notebook of RDD.partitionBy  
░░║░░░░░░░╠═22 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.pipe), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/22_RDD.pipe_example.ipynb) on Jupyter notebook of RDD.pipe  
░░║░░░░░░░╠═23 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.reduce), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/23_RDD.reduce_example.ipynb) on Jupyter notebook of RDD.reduce  
░░║░░░░░░░╠═24 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sample), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/24_RDD.sample_example.ipynb) on Jupyter notebook of RDD.sample  
░░║░░░░░░░╠═25 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortBy), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/25_RDD.sortBy_example.ipynb) on Jupyter notebook of RDD.sortBy  
░░║░░░░░░░╠═26 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortByKey), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/26_RDD.sortByKey_example.ipynb) on Jupyter notebook of RDD.sortByKey  
░░║░░░░░░░╠═27 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.take), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/27_RDD.take_example.ipynb) on Jupyter notebook of RDD.take  
░░║░░░░░░░╠═28 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.takeOrdered), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/28_RDD.takeOrdered_example.ipynb) on Jupyter notebook of RDD.takeOrdered  
░░║░░░░░░░╠═29 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.takeSample), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/29_RDD.takeSample_example.ipynb) on Jupyter notebook of RDD.takeSample  
░░║░░░░░░░╠═30 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.top), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/30_RDD.top_example.ipynb) on Jupyter notebook of RDD.top  
░░║░░░░░░░╠═31 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.SparkContext.union), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/31_RDD.union_example.ipynb) on Jupyter notebook of RDD.union  
░░║░░░░░░░╚═32 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.zip), [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/32_RDD.zip_example.ipynb) on Jupyter notebook of RDD.zip  
░░╚═7 Scala API [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.package)  
░░░░╚═1 package org.apache.spark [source code](https://github.com/apache/spark/tree/v2.4.4/core/src/main/scala/org/apache/spark) on Github  
░░░░░░╚═1 package rdd [source code](https://github.com/apache/spark/tree/v2.4.4/core/src/main/scala/org/apache/spark/rdd) on Github  
░░░░░░░░╠═1 class PairRDDFunctions [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions), [source code](https://github.com/apache/spark/blob/v2.4.4/core/src/main/scala/org/apache/spark/rdd/PairRDDFunctions.scala) on Github  
░░░░░░░░║░╚═1 Value Members  
░░░░░░░░║░░░╚═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@partitionBy(partitioner:org.apache.spark.Partitioner):org.apache.spark.rdd.RDD[(K,V)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/PartitionBy.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/01_class_PairRDDFunctions/01_Value_Members/01_PairRDDFunctions.partitionBy_example.md) on spark-shell of RDD.partitionBy  
░░░░░░░░╚═2 class RDD [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD), [source code](https://github.com/apache/spark/tree/v2.4.4/core/src/main/scala/org/apache/spark/rdd/RDD.scala) on Github  
░░░░░░░░░░╚═1 Concrete Value Members  
░░░░░░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@cache():RDD.this.type), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Cache.scala#L15) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/01_RDD.cache_example.md) on spark-shell of RDD.cache  
░░░░░░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@coalesce(numPartitions:Int,shuffle:Boolean,partitionCoalescer:Option[org.apache.spark.rdd.PartitionCoalescer])(implicitord:Ordering[T]):org.apache.spark.rdd.RDD[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Coalesce.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/02_RDD.coalesce_example.md) on spark-shell of RDD.coalesce  
░░░░░░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@fold(zeroValue:T)(op:(T,T)=%3ET):T), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Fold.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/03_RDD.fold_example.md) on spark-shell of RDD.fold  
░░░░░░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@getNumPartitions:Int), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/GetNumPartitions.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/04_RDD.getNumPartitions_example.md) on spark-shell of RDD.getNumPartitions  
░░░░░░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@keyBy[K](f:T=%3EK):org.apache.spark.rdd.RDD[(K,T)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/KeyBy.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/05_RDD.keyBy_example.md) on spark-shell of RDD.keyBy  
░░░░░░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@map[U](f:T=%3EU)(implicitevidence$3:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Map.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/06_RDD.map_example.md) on spark-shell of RDD.map  
░░░░░░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@take(num:Int):Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Take.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/07_RDD.take_example.md) on spark-shell of RDD.take  
░░░░░░░░░░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@takeOrdered(num:Int)(implicitord:Ordering[T]):Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/TakeOrdered.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/08_RDD.takeOrdered_example.md) on spark-shell of RDD.takeOrdered  
░░░░░░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@top(num:Int)(implicitord:Ordering[T]):Array[T]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Top.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/09_RDD.top_example.md) on spark-shell of RDD.top  
░░░░░░░░░░░░╚═10 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@zip[U](other:org.apache.spark.rdd.RDD[U])(implicitevidence$10:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[(T,U)]), [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Zip.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/02_class_RDD/01_Concrete_Value_Members/10_RDD.zip_example.md) on spark-shell of RDD.zip  

# Example of Spark

| RDD Operation                                                                                            | Transformation / Action | Narrow / Wide |
|----------------------------------------------------------------------------------------------------------|-------------------------|---------------|
| [1st Map](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapTest.java)                 | T                       | N             |
| [2nd FlatMap](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapTest.java)         | T                       | N             |
| [3rd Filter](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FilterTest.java)           | T                       | N             |
| [4th Reduce](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ReduceTest.java)           | A                       | W             |
| [5th ReduceByKey](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ReduceByKeyTest.java) | T                       | W             |
| [6th GroupBy](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/GroupByTest.java)         | T                       | W             |
| [7th GroupByKey](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/GroupByKeyTest.java)   | T                       | W             |
| [8th Join](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/JoinTest.java)               | T                       | W             |
| [9th CoGroup](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/CoGroupTest.java)         | T                       | W             |
| [10th Union](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/UnionTest.java)            | T                       | N             |
| [11th Collect](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/CollectTest.java)        | A                       |               |
| [12th Take](02_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/TakeTest.java)              | A                       |               |

[List\<Tuple2\<String,String\>\> to JavaPairRDD\<String,String\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/ListTupleToJavaPairRDDTest.java)

[Join, Left, Right, Full Outer Join with List\<Tuple2\<String,Integer\>\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/JoinTest.java)

[MapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapToDoubleTest.java)

[FlatMapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapToDoubleTest.java)

[Column to Rows as Pivot](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ColumnToRowsTest.java)
