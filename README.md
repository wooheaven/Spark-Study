╠═1 Spark Installation  
║░╠═1 Spark Version Compatibility  
║░║░╚═1 [Spark, Java, Hadoop, Scala, Python, R : version compatibility](01_Spark_Installation/01_Spark_version/01_Spark_Java_Hadoop_Scala_Python_R_version.md)  
║░╠═2 on CentOS 6.9  
║░║░╠═1 [docker pull centos:6.9](01_Spark_Installation/02_on_CentOS6.9/01_Run_CentOS6.9_on_docker.md)  
║░║░╠═2 [install JDK8](01_Spark_Installation/02_on_CentOS6.9/02_Install_JDK8_on_CentOS6.9_docker_container.md)  
║░║░╠═3 [install Maven3.3.9](01_Spark_Installation/02_on_CentOS6.9/03_Install_Maven3.3.9_on_CentOS6.9_docker_container.md)  
║░║░╠═4 [install Scala2.12.1](01_Spark_Installation/02_on_CentOS6.9/04_Install_Scala2.12.1_on_CentOS6.9_docker_container.md)  
║░║░╚═5 [install Sbt0.13.15](01_Spark_Installation/02_on_CentOS6.9/05_Install_Sbt0.13.15_on_CentOS6.9_docker_container.md)  
║░╠═3 on Ubuntu 14.04  
║░║░╠═1 [docker pull ubuntu:14.04](01_Spark_Installation/03_on_Ubuntu14.04/01_Run_Ubuntu14.04_on_docker.md)  
║░║░╠═2 [install JDK8](01_Spark_Installation/03_on_Ubuntu14.04/02_Install_JDK8_on_Ubuntu14.04.md)  
║░║░╠═3 [install Maven3.3.9](01_Spark_Installation/03_on_Ubuntu14.04/03_Install_Maven3.3.9_on_Ubuntu14.04.md)  
║░║░╠═4 [install Scala2.12.1](01_Spark_Installation/03_on_Ubuntu14.04/04_Install_Scala2.12.1_on_Ubuntu14.04.md)  
║░║░╠═5 [install Sbt0.13.15](01_Spark_Installation/03_on_Ubuntu14.04/05_Install_Sbt0.13.15_on_Ubuntu14.04.md)  
║░║░╠═6 [install ssh](01_Spark_Installation/03_on_Ubuntu14.04/06_Install_ssh_on_Ubuntu14.04.md)  
║░║░╠═7 [install hadoop2.7.3](01_Spark_Installation/03_on_Ubuntu14.04/07_Install_Hadoop2.7.3_on_Ubuntu14.04.md)  
║░║░╚═8 [install spark2.1.0](01_Spark_Installation/03_on_Ubuntu14.04/08_Install_Spark2.1.0_on_Ubuntu14.04.md)  
║░╠═4 on Ubuntu 16.04  
║░║░╠═1 [docker pull ubuntu:16.04](01_Spark_Installation/04_on_Ubuntu16.04/01_docker_pull/01_docker_pull_ubuntu_16.04.md)  
║░║░╠═2 [install ssh](01_Spark_Installation/04_on_Ubuntu16.04/02_install_ssh/00_install_ssh.md)  
║░║░╠═3 [install jdk8](01_Spark_Installation/04_on_Ubuntu16.04/03_install_jdk8/00_install_jdk8.md)  
║░║░╠═4 [install hadoop2.8.5](01_Spark_Installation/04_on_Ubuntu16.04/04_install_hadoop2.8.5/00_install_hadoop2.8.5.md)  
║░║░╠═5 install spark2.4.4 with resource manager  
║░║░║░╠═1 [with spark standalone](01_Spark_Installation/04_on_Ubuntu16.04/05_install_spark2.4.4/01_spark_standalone/00_install_spark2.4.3.md)  
║░║░║░╚═2 [with hadoop yarn](01_Spark_Installation/04_on_Ubuntu16.04/05_install_spark2.4.4/02_hadoop_yarn/00_install_spark2.4.4.md)  
║░║░╚═6 [install jupyter and connect to pyspark](01_Spark_Installation/04_on_Ubuntu16.04/06_install_jupyter/00_install_jupyter_and_connect_pyspark.md)  
║░╚═5 ETC  
║░░░╚═1 [Solution : WARN spark.yarn.archive](01_Spark_Installation/05_ETC/01_Solution_of_WARN_spark_yarn_archive.md)  
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
░░║░║░╠═2 [PairFunction](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/PairFunction.html)  
░░║░║░║░╚═1 [example : CustomPairFunction](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/pairfunction/CustomPairFunction.java)  
░░║░║░╚═3 [Partitioner](https://spark.apache.org/docs/latest/api/java/org/apache/spark/Partitioner.html)  
░░║░║░░░╚═1 [example : CustomPartitioner](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/partitioner/CustomPartitioner.java)  
░░║░╚═2 Scala  
░░║░░░╠═1 [flatMap](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@flatMap[U](f:T=%3ETraversableOnce[U])(implicitevidence$4:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U])  
░░║░░░║░╠═1 [example on spark-shell : flatMap case map](03_Spark_Document/01_RDD_API_doc/02_Scala/01_flatMap/01_flatMap_case_map_example.md)  
░░║░░░║░╚═2 [example on spark-shell : flatMap](03_Spark_Document/01_RDD_API_doc/02_Scala/01_flatMap/02_flatMap_example.md)  
░░║░░░╚═2 [map](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD@map[U](f:T=%3EU)(implicitevidence$3:scala.reflect.ClassTag[U]):org.apache.spark.rdd.RDD[U])  
░░║░░░░░╚═1 [example on spark-shell : map](03_Spark_Document/01_RDD_API_doc/02_Scala/02_map/01_map_example.md)  
░░╠═2 RDD paper  
░░║░╚═1 [RDD paper in Korean](03_Spark_Document/02_RDD_paper/01_Resilient_Distributed_Datasets_Essay_to_Korean.md)  
░░╠═3 [RDD programming guide](https://spark.apache.org/docs/latest/rdd-programming-guide.html)  
░░║░╚═1 [RDD](https://spark.apache.org/docs/latest/rdd-programming-guide.html#resilient-distributed-datasets-rdds)  
░░║░░░╚═1 [RDD Operations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#rdd-operations)  
░░║░░░░░╠═1 [Transformations](https://spark.apache.org/docs/latest/rdd-programming-guide.html#transformations)  
░░║░░░░░║░╠═1 map(func)  
░░║░░░░░║░╠═2 flatMap(func)  
░░║░░░░░║░╠═3 mapPartitions(func)  
░░║░░░░░║░╠═4 mapPartitionsWithIndex(func)  
░░║░░░░░║░╠═5 cartesian(otherDataset)  
░░║░░░░░║░╚═6 glom()  
░░║░░░░░╚═2 [Actions](https://spark.apache.org/docs/latest/rdd-programming-guide.html#actions)  
░░║░░░░░░░╠═1 collect()  
░░║░░░░░░░╠═2 saveAsTextFile(path)  
░░║░░░░░░░╚═3 getNumPartitions()  
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
░░║░░░╠═2 [groupByKey](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#groupByKey--)  
░░║░░░║░╚═1 [source code : groupByKey](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/GroupByKeyTest.java)  
░░║░░░╠═3 [join](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#join-org.apache.spark.api.java.JavaPairRDD-)  
░░║░░░║░╚═1 [source code : join](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/JoinTest.java)  
░░║░░░╠═4 [mapToPair](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapToPair-org.apache.spark.api.java.function.PairFunction-)  
░░║░░░║░╚═1 [example : mapToPair](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapToPairTest.java)  
░░║░░░╠═5 [mapValues](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#mapValues-org.apache.spark.api.java.function.Function-)  
░░║░░░║░╚═1 [source code : mapValues](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/MapValuesTest.java)  
░░║░░░╠═6 [partitionBy](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#partitionBy-org.apache.spark.Partitioner-)  
░░║░░░║░╚═1 [source code : partitionBy](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/PartitionByTest.java)  
░░║░░░╚═7 [reduceByKey](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#reduceByKey-org.apache.spark.api.java.function.Function2-)  
░░║░░░░░╚═1 [source code : reduceByKey](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/pairrdd/ReduceByKeyTest.java)  
░░╠═5 Java : [Spark Java API (JavaDoc)](https://spark.apache.org/docs/latest/api/java/index.html)  
░░║░╚═1 [package org.apache.spark.api.java on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/package-summary.html)  
░░║░░░╠═1 [package function on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/package-summary.html)  
░░║░░░║░╠═1 interface  
░░║░░░║░║░╠═1 [FlatMapFunction on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/FlatMapFunction.html)  
░░║░░░║░║░╠═2 [Function        on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function.html)  
░░║░░░║░║░╚═3 [Function2       on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/function/Function2.html)  
░░║░░░║░╚═2 example implements  
░░║░░░║░░░╠═1 [CustomFlatMapFunction  implements FlatMapFunction example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/flatmapfunction/CustomFlatMapFunction.java)  
░░║░░░║░░░╠═2 [CustomFunctionCountOne implements Function        example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunctionCountOne.java)  
░░║░░░║░░░╚═3 CustomFunction2~ implements Function2  
░░║░░░║░░░░░╠═1 [CustomFunction2IndexSum implements Function2 example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunction2IndexSum.java)  
░░║░░░║░░░░░╚═2 [CustomFunction2Sum      implements Function2 example on Source](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/function/CustomFunction2Sum.java)  
░░║░░░╚═2 [class JavaRDD on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html)  
░░║░░░░░╠═1 method  
░░║░░░░░║░╠═1 [JavaRDD.cartesian              on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#cartesian-org.apache.spark.api.java.JavaRDDLike-)  
░░║░░░░░║░╠═2 [JavaRDD.filter                 on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#filter-org.apache.spark.api.java.function.Function-)  
░░║░░░░░║░╠═3 [JavaRDD.flatMap                on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#flatMap-org.apache.spark.api.java.function.FlatMapFunction-)  
░░║░░░░░║░╠═4 [JavaRDD.getNumPartitions       on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#getNumPartitions--)  
░░║░░░░░║░╠═5 [JavaRDD.map                    on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#map-org.apache.spark.api.java.function.Function-)  
░░║░░░░░║░╠═6 [JavaRDD.mapPartitions          on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitions-org.apache.spark.api.java.function.FlatMapFunction-)  
░░║░░░░░║░╚═7 [JavaRDD.mapPartitionsWithIndex on JavaDoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaRDD.html#mapPartitionsWithIndex-org.apache.spark.api.java.function.Function2-boolean-)  
░░║░░░░░╚═2 example  
░░║░░░░░░░╠═1 [JavaRDD.cartesian              example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/CartesianTest.java)  
░░║░░░░░░░╠═2 [JavaRDD.filter                 example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FilterTest.java)  
░░║░░░░░░░╠═3 [JavaRDD.flatMap                example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/FlatMapTest.java)  
░░║░░░░░░░╠═4 [JavaRDD.getNumPartitions       example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/GetNumPartitionsTest.java)  
░░║░░░░░░░╠═5 [JavaRDD.map                    example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapTest.java)  
░░║░░░░░░░╠═6 [JavaRDD.mapPartitions          example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsTest.java)  
░░║░░░░░░░╚═7 [JavaRDD.mapPartitionsWithIndex example on JUnit Test](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/rdd/MapPartitionsWithIndexTest.java)  
░░╚═6 Python : [Spark Python API (Sphinx)](https://spark.apache.org/docs/latest/api/python/index.html), [Spark Python API on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/)  
░░░░╚═1 [package pyspark on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/)  
░░░░░░╠═1 [package sql on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/)  
░░░░░░║░╚═1 [file session.py on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/sql/session.html)  
░░░░░░║░░░╠═1 [SparkSession on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.sql.html#pyspark.sql.SparkSession)  
░░░░░░║░░░╠═2 [file session.py source on github](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py)  
░░░░░░║░░░╠═3 method  
░░░░░░║░░░╠═4 [monkey patch RDD RDD.toDF source on github](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/sql/session.py#L44)  
░░░░░░║░░░╚═5 example  
░░░░░░║░░░░░╚═1 [RDD.toDF on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/01_package_sql/01_file_session.py/05_example/01_RDD.toDF_example.ipynb)  
░░░░░░╚═2 [file rdd.py on modules](https://spark.apache.org/docs/latest/api/python/_modules/pyspark/rdd.html#RDD)  
░░░░░░░░╠═1 [RDD on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD)  
░░░░░░░░╠═2 [file rdd.py source on github](https://github.com/apache/spark/blob/v2.4.4/python/pyspark/rdd.py)  
░░░░░░░░╠═3 method  
░░░░░░░░║░╠═1 [RDD.cartesian              on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.cartesian)  
░░░░░░░░║░╠═2 [RDD.filter                 on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.filter)  
░░░░░░░░║░╠═3 [RDD.flatMap                on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.flatMap)  
░░░░░░░░║░╠═4 [RDD.getNumPartitions       on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.getNumPartitions)  
░░░░░░░░║░╠═5 [RDD.map                    on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.map)  
░░░░░░░░║░╠═6 [RDD.mapPartitions          on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitions)  
░░░░░░░░║░╠═7 [RDD.mapPartitionsWithIndex on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.mapPartitionsWithIndex)  
░░░░░░░░║░╚═8 [RDD.sortBy                 on Sphinx](https://spark.apache.org/docs/latest/api/python/pyspark.html#pyspark.RDD.sortBy)  
░░░░░░░░╚═4 example  
░░░░░░░░░░╠═1 [RDD.cartesian              on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/01_RDD.cartesian_example.ipynb)  
░░░░░░░░░░╠═2 [RDD.filter                 on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/02_RDD.filter_example.ipynb)  
░░░░░░░░░░╠═3 [RDD.flatMap                on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/03_RDD.flatMap_example.ipynb)  
░░░░░░░░░░╠═4 [RDD.getNumPartitions       on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/04_RDD.getNumPartitions_example.ipynb)  
░░░░░░░░░░╠═5 [RDD.map                    on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/05_RDD.map_example.ipynb)  
░░░░░░░░░░╠═6 [RDD.mapPartitions          on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/06_RDD.mapPartitions_example.ipynb)  
░░░░░░░░░░╠═7 [RDD.mapPartitionsWithIndex on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/07_RDD.mapPartitionsWithIndex_example.ipynb)  
░░░░░░░░░░╚═8 [RDD.sortBy                 on Jupyter notebook](03_Spark_Document/06_Python/01_package_pyspark/02_file_rdd.py/03_example/08_RDD.sortBy_example.ipynb)  

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
