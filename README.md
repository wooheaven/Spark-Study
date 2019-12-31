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
░░║░░░╚═1 [RDD Operations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#rdd-operations)  
░░║░░░░░╠═1 [Transformations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#transformations)  
░░║░░░░░║░╠═1 cartesian(otherDataset)  
░░║░░░░░║░╠═2 distinct([numPartitions]))  
░░║░░░░░║░╠═3 flatMap(func)  
░░║░░░░░║░╠═4 glom()  
░░║░░░░░║░╠═5 groupBy()  
░░║░░░░░║░╠═6 groupByKey([numPartitions])  
░░║░░░░░║░╠═7 intersection(otherDataset)  
░░║░░░░░║░╠═8 map(func)  
░░║░░░░░║░╠═9 mapPartitions(func)  
░░║░░░░░║░╠═10 mapPartitionsWithIndex(func)  
░░║░░░░░║░╠═11 pipe(command, [envVars])  
░░║░░░░░║░╠═12 sample(withReplacement, fraction, seed)  
░░║░░░░░║░╠═13 sortByKey([ascending], [numPartitions])  
░░║░░░░░║░╚═14 union(otherDataset)  
░░║░░░░░╚═2 [Actions](https://spark.apache.org/docs/latest/rdd-programming-guide.html#actions)  
░░║░░░░░░░╠═1 aggregate(zeroValue, seqOp, combOp)  
░░║░░░░░░░╠═2 collect()  
░░║░░░░░░░╠═3 fold(zeroValue, op)  
░░║░░░░░░░╠═4 foreach(func)  
░░║░░░░░░░╠═5 foreachPartition(func)  
░░║░░░░░░░╠═6 getNumPartitions()  
░░║░░░░░░░╠═7 saveAsTextFile(path)  
░░║░░░░░░░╠═8 reduce(func)  
░░║░░░░░░░╠═9 take(n)  
░░║░░░░░░░╠═10 takeOrdered(n, [ordering])  
░░║░░░░░░░╠═11 takeSample(withReplacement, num, [seed])  
░░║░░░░░░░╚═12 top(n, [ordering])  
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
░░║░░░╠═1 [flatMapToPair](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#flatMapToPair-org.apache.spark.api.java.function.PairFlatMapFunction-)  
░░║░░░║░╚═1 [source code : flatMapToPair](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/FlatMapToPairTest.java)  
░░║░░░╠═2 [join](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#join-org.apache.spark.api.java.JavaPairRDD-)  
░░║░░░║░╚═1 [source code : join](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/JoinTest.java)  
░░║░░░╠═3 [mapValues](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapValues-org.apache.spark.api.java.function.Function-)  
░░║░░░║░╚═1 [source code : mapValues](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapValuesTest.java)  
░░║░░░╚═4 [partitionBy](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#partitionBy-org.apache.spark.Partitioner-)  
░░║░░░░░╚═1 [source code : partitionBy](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/PartitionByTest.java)  
░░╠═5 Java : [Spark Java API (JavaDoc)](https://spark.apache.org/docs/latest/api/java/index.html)  
░░║░╚═1 [package org.apache.spark.api.java](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/package-summary.html) on JavaDoc  
░░║░░░╠═1 [package function](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/package-summary.html) on JavaDoc  
░░║░░░║░╠═1 interface  
░░║░░░║░║░╠═1 [FlatMapFunction](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/FlatMapFunction.html) on JavaDoc  
░░║░░░║░║░╠═2 [Function](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function.html) on JavaDoc  
░░║░░░║░║░╠═3 [Function2](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function2.html) on JavaDoc  
░░║░░░║░║░╚═4 [PairFunction](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFunction.html) on JavaDoc  
░░║░░░║░╚═2 example implements  
░░║░░░║░░░╠═1 CustomFlatMapFunction~ implements FlatMapFunction  
░░║░░░║░░░║░╚═1 [CustomFlatMapFunction              implements FlatMapFunction example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/flatmapfunction/CustomFlatMapFunction.java)  
░░║░░░║░░░╠═2 CustomFunction~ implements Function  
░░║░░░║░░░║░╠═1 [CustomFunctionCountOne             implements Function  example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunctionCountOne.java)  
░░║░░░║░░░║░╠═2 [CustomFunctionToLowerCase          implements Function  example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunctionToLowerCase.java)  
░░║░░░║░░░║░╚═3 [CustomFunctionThreeGroup           implements Function  example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunctionThreeGroup.java)  
░░║░░░║░░░╠═3 CustomFunction2~ implements Function2  
░░║░░░║░░░║░╠═1 [CustomFunction2IndexSum            implements Function2 example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunction2IndexSum.java)  
░░║░░░║░░░║░╚═2 [CustomFunction2Sum                 implements Function2 example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunction2Sum.java)  
░░║░░░║░░░╠═4 CustomPairFunction~ implements PairFunction  
░░║░░░║░░░║░╠═1 [CustomPairFunctionDivideByItemSize implements PairFunction example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/pairfunction/CustomPairFunctionDivideByItemSize.java)  
░░║░░░║░░░║░╚═2 [CustomPairFunctionDivideBySpace    implements PairFunction example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/pairfunction/CustomPairFunctionDivideBySpace.java)  
░░║░░░║░░░╚═5 CustomVoidFunction~ implements VoidFunction  
░░║░░░║░░░░░╠═1 [CustomVoidFunctionAppendAndPrintWithElement  implements VoidFunction example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/voidfunction/CustomVoidfunctionAppendAndPrintWithElement.java)  
░░║░░░║░░░░░╚═2 [CustomVoidFunctionAppendAndPrintWithIterator implements VoidFunction example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/voidfunction/CustomVoidfunctionAppendAndPrintWithIterator.java)  
░░║░░░╠═2 [class JavaPairRDD.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html) on JavaDoc  
░░║░░░║░╠═1 method  
░░║░░░║░║░╠═1 [JavaPairRDD.groupByKey on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#groupByKey--)  
░░║░░░║░║░╠═2 [JavaPairRDD.mapToPair  on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-)  
░░║░░░║░║░╠═3 [JavaPairRDD.sortByKey  on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#sortByKey-java.util.Comparator-boolean-int-)  
░░║░░░║░║░╚═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#reduceByKey-org.apache.spark.api.java.function.Function2-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/ReduceByKeyTest.java) on JUnit Test of JavaPairRDD.reduceByKey  
░░║░░░║░╚═2 example  
░░║░░░║░░░╠═1 [JavaPairRDD.groupByKey example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/GroupByKeyTest.java)  
░░║░░░║░░░╠═2 [JavaPairRDD.maptoPair  example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapToPairTest.java)  
░░║░░░║░░░╚═3 [JavaPairRDD.sortByKey  example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/SortByKeyTest.java)  
░░║░░░╚═3 [class JavaRDD.class](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html) on JavaDoc  
░░║░░░░░╚═1 method  
░░║░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#aggregate-U-org.apache.spark.api.java.function.Function2-org.apache.spark.api.java.function.Function2-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/AggregateTest.java) on JUnit Test of JavaRDD.aggregate  
░░║░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#cartesian-org.apache.spark.api.java.JavaRDDLike-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/CartesianTest.java) on JUnit Test of JavaRDD.cartesian  
░░║░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#distinct--) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/DistinctTest.java) on JUnit Test of JavaRDD.distinct  
░░║░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#filter-org.apache.spark.api.java.function.Function-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FilterTest.java) on JUnit Test of JavaRDD.filter  
░░║░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#flatMap-org.apache.spark.api.java.function.FlatMapFunction-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FlatMapTest.java) on JUnit Test of JavaRDD.flatMap  
░░║░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#fold-T-org.apache.spark.api.java.function.Function2-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FoldTest.java) on JUnit Test of JavaRDD.fold  
░░║░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#foreach-org.apache.spark.api.java.function.VoidFunction-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ForeachTest.java) on JUnit Test of JavaRDD.foreach  
░░║░░░░░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#foreachPartition-org.apache.spark.api.java.function.VoidFunction-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ForeachPartitionTest.java) on JUnit Test of JavaRDD.foreachPartition  
░░║░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#getNumPartitions--) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GetNumPartitionsTest.java) on JUnit Test of JavaRDD.getNumPartitions  
░░║░░░░░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#glom--) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GlomTest.java) on JUnit Test of JavaRDD.glom  
░░║░░░░░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#groupBy-org.apache.spark.api.java.function.Function-int-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GroupByTest.java) on JUnit Test of JavaRDD.groupBy  
░░║░░░░░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#intersection-org.apache.spark.api.java.JavaRDD-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/IntersectionTest.java) on JUnit Test of JavaRDD.intersection  
░░║░░░░░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#map-org.apache.spark.api.java.function.Function-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapTest.java) on JUnit Test of JavaRDD.map  
░░║░░░░░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitions-org.apache.spark.api.java.function.FlatMapFunction-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsTest.java) on JUnit Test of JavaRDD.mapPartitions  
░░║░░░░░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitionsWithIndex-org.apache.spark.api.java.function.Function2-boolean-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsWithIndexTest.java) on JUnit Test of JavaRDD.mapPartitionsWithIndex  
░░║░░░░░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapToPairTest.java) on JUnit Test of JavaRDD.maptoPair  
░░║░░░░░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#pipe-java.lang.String-) on JavaDoc, [example argument error](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/PipeTest.java) on JUnit Test of JavaRDD.pipe  
░░║░░░░░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#reduce-org.apache.spark.api.java.function.Function2-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/ReduceTest.java) on JUnit Test of JavaRDD.reduce  
░░║░░░░░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#sample-boolean-double-long-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/SampleTest.java) on JUnit Test of JavaRDD.sample  
░░║░░░░░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#sortBy-org.apache.spark.api.java.function.Function-boolean-int-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/SortByTest.java) on JUnit Test of JavaRDD.sortBy  
░░║░░░░░░░╠═21 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#take-int-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TakeTest.java) on JUnit Test of JavaRDD.take  
░░║░░░░░░░╠═22 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#takeOrdered-int-java.util.Comparator-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TakeOrderedTest.java) on JUnit Test of JavaRDD.takeOrdered  
░░║░░░░░░░╠═23 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#takeSample-boolean-int-long-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TakeSampleTest.java) on JUnit Test of JavaRDD.takeSample  
░░║░░░░░░░╠═24 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#top-int-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/TopTest.java) on JUnit Test of JavaRDD.top  
░░║░░░░░░░╚═25 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#union-org.apache.spark.api.java.JavaRDD-) on JavaDoc, [example](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/UnionTest.java) on JUnit Test of JavaRDD.union  
░░╠═6 Python : [Spark Python API (Sphinx)](https://spark.apache.org/docs/latest/api/python/index.html), [Spark Python API on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/)  
░░║░╚═1 [package pyspark on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/)  
░░║░░░╠═1 [package sql on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/)  
░░║░░░║░╚═1 [file session.py on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/session.html)  
░░║░░░║░░░╠═1 [SparkSession on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.sql.html#pyspark.sql.SparkSession)  
░░║░░░║░░░╠═2 [file session.py source on github](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py)  
░░║░░░║░░░╚═3 method  
░░║░░░║░░░░░╚═1 [monkey patch RDD.toDF source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py#L44) on Github, [example](03_Spark_Document/06_Python/01_package_pyspark/01_package_sql/01_file_session.py/05_example/01_RDD.toDF_example.ipynb) on Jupyter notebook of RDD.toDF  
░░║░░░╚═2 [file rdd.py](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/rdd.html#RDD) on modules, [RDD](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD) on Sphinx, [source code](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/rdd.py) on github  
░░║░░░░░╚═1 method  
░░║░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.aggregate) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/01_RDD.aggregate.ipynb) on Jupyter notebook of RDD.aggregate  
░░║░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.cartesian) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/02_RDD.cartesian_example.ipynb) on Jupyter notebook of RDD.cartesian  
░░║░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.distinct) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/03_RDD.distinct_example.ipynb) on Jupyter notebook of RDD.distinct  
░░║░░░░░░░╠═4 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.filter) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/04_RDD.filter_example.ipynb) on Jupyter notebook of RDD.filter  
░░║░░░░░░░╠═5 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.flatMap) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/05_RDD.flatMap_example.ipynb) on Jupyter notebook of RDD.flatMap  
░░║░░░░░░░╠═6 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.fold) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/06_RDD.fold_example.ipynb) on Jupyter notebook of RDD.fold  
░░║░░░░░░░╠═7 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.foreach) on Sphinx, [example can't work](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/07_RDD.foreach_example.ipynb) on Jupyter notebook of RDD.foreach  
░░║░░░░░░░╠═8 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.foreachPartition) on Sphinx, [example can't work](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/08_RDD.foreachPartition_example.ipynb) on Jupyter notebook of RDD.foreachPartition  
░░║░░░░░░░╠═9 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.getNumPartitions) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/09_RDD.getNumPartitions_example.ipynb) on Jupyter notebook of RDD.getNumPartitions  
░░║░░░░░░░╠═10 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.glom) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/10_RDD.glom_example.ipynb) on Jupyter notebook of RDD.glom  
░░║░░░░░░░╠═11 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.groupBy) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/11_RDD.groupBy_example.ipynb) on Jupyter notebook of RDD.groupBy  
░░║░░░░░░░╠═12 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.groupByKey) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/12_RDD.groupByKey_example.ipynb) on Jupyter notebook of RDD.groupByKey  
░░║░░░░░░░╠═13 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.intersection) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/13_RDD.itersection_example.ipynb) on Jupyter notebook of RDD.intersection  
░░║░░░░░░░╠═14 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.map) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/14_RDD.map_example.ipynb) on Jupyter notebook of RDD.map  
░░║░░░░░░░╠═15 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitions) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/15_RDD.mapPartitions_example.ipynb) on Jupyter notebook of RDD.mapPartitions  
░░║░░░░░░░╠═16 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitionsWithIndex) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/16_RDD.mapPartitionsWithIndex_example.ipynb) on Jupyter notebook of RDD.mapPartitionsWithIndex  
░░║░░░░░░░╠═17 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.pipe) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/17_RDD.pipe_example.ipynb) on Jupyter notebook of RDD.pipe  
░░║░░░░░░░╠═18 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.reduce) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/18_RDD.reduce_example.ipynb) on Jupyter notebook of RDD.reduce  
░░║░░░░░░░╠═19 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sample) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/19_RDD.sample_example.ipynb) on Jupyter notebook of RDD.sample  
░░║░░░░░░░╠═20 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortBy) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/20_RDD.sortBy_example.ipynb) on Jupyter notebook of RDD.sortBy  
░░║░░░░░░░╠═21 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortByKey) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/21_RDD.sortByKey_example.ipynb) on Jupyter notebook of RDD.sortByKey  
░░║░░░░░░░╠═22 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.takeOrdered) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/22_RDD.takeOrdered_example.ipynb) on Jupyter notebook of RDD.takeOrdered  
░░║░░░░░░░╠═23 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.takeSample) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/23_RDD.takeSample_example.ipynb) on Jupyter notebook of RDD.takeSample  
░░║░░░░░░░╠═24 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.top) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/24_RDD.top_example.ipynb) on Jupyter notebook of RDD.top  
░░║░░░░░░░╚═25 [doc](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.SparkContext.union) on Sphinx, [example](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/25_RDD.union_example.ipynb) on Jupyter notebook of RDD.union  
░░╚═7 Scala : [Spark Scala API (Scaladoc)](https://spark.apache.org/docs/latest/api/scala/index.html#package)  
░░░░╚═1 [package org.apache.spark on Github](https://github.com/apache/spark/tree/master/core/src/main/scala/org/apache/spark)  
░░░░░░╚═1 [package rdd](https://github.com/apache/spark/tree/master/core/src/main/scala/org/apache/spark/rdd) on Github  
░░░░░░░░╚═1 [RDD.scala](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD) on Scaladoc, [source code](https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/rdd/RDD.scala) on Github  
░░░░░░░░░░╚═1 Concrete Value Members  
░░░░░░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@fold(zeroValue:T)(op:(T,T)=%3ET):T) on Scaladoc, [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Fold.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/01_class_RDD/01_Concrete_Value_Members/01_RDD.fold_example.md) on spark-shell of RDD.fold  
░░░░░░░░░░░░╠═2 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@map[U](f:T=%3EU)(implicitevidence$3:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U]) on Scaladoc, [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Map.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/01_class_RDD/01_Concrete_Value_Members/02_RDD.map_example.md) on spark-shell of RDD.map  
░░░░░░░░░░░░╠═3 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@takeOrdered(num:Int)(implicitord:Ordering[T]):Array[T]) on Scaladoc, [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/TakeOrdered.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/01_class_RDD/01_Concrete_Value_Members/03_RDD.takeOrdered_example.md) on spark-shell of RDD.takeOrdered  
░░░░░░░░░░░░╚═4 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@top(num:Int)(implicitord:Ordering[T]):Array[T]) on Scaladoc, [example](02_Spark_Workspace/02_spark-submit/03_with_Scala2.12/src/main/scala/rwoo/study/spark/rdd/Top.scala) on spark-submit, [example](03_Spark_Document/07_Scala/01_package_org.apache.spark/01_package_rdd/01_class_RDD/01_Concrete_Value_Members/04_RDD.top_example.md) on spark-shell of RDD.top  

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
