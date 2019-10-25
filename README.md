╠═1 Spark Installation  
║░╠═1 Spark Version Compatibility  
║░║░╚═1 [Spark, Java, Hadoop, Scala, Python, R : version compatibility](01_Spark_Installation/01_Spark_version/01_Spark_Java_Hadoop_Scala_Python_R_version.md)  
║░╠═2 on CentOS 6.9  
║░║░╠═1 [docker pull centos:6.9](01_Spark_Installation/02_on_CentOS6.9/01_Run_CentOS6.9_on_docker.md)  
║░║░╠═2 [install JDK8](01_Spark_Installation/02_on_CentOS6.9/02_Install_JDK8_on_CentOS6.9_docker_container.md)  
║░║░╠═3 [install Maven3.3.9](01_Spark_Installation/02_on_CentOS6.9/03_Install_Maven3.3.9_on_CentOS6.9_docker_container.md)  
║░║░╠═4 [install Scala2.12.1](01_Spark_Installation/02_on_CentOS6.9/04_Install_Scala2.12.1_on_CentOS6.9_docker_container.md)  
║░║░╚═5 [install Sbt0.13.15](01_Spark_Installation/02_on_CentOS6.9/05_Install_Sbt0.13.15_on_CentOS6.9_docker_container.md)  
║░╠═2 on Ubuntu 14.04  
║░║░╠═1 [docker pull ubuntu:14.04](01_Spark_Installation/03_on_Ubuntu14.04/01_Run_Ubuntu14.04_on_docker.md)  
║░║░╠═2 [install JDK8](01_Spark_Installation/03_on_Ubuntu14.04/02_Install_JDK8_on_Ubuntu14.04.md)  
║░║░╠═3 [install Maven3.3.9](01_Spark_Installation/03_on_Ubuntu14.04/03_Install_Maven3.3.9_on_Ubuntu14.04.md)  
║░║░╠═4 [install Scala2.12.1](01_Spark_Installation/03_on_Ubuntu14.04/04_Install_Scala2.12.1_on_Ubuntu14.04.md)  
║░║░╠═5 [install Sbt0.13.15](01_Spark_Installation/03_on_Ubuntu14.04/05_Install_Sbt0.13.15_on_Ubuntu14.04.md)  
║░║░╠═6 [install ssh](01_Spark_Installation/03_on_Ubuntu14.04/06_Install_ssh_on_Ubuntu14.04.md)  
║░║░╠═7 [install hadoop2.7.3](01_Spark_Installation/03_on_Ubuntu14.04/07_Install_Hadoop2.7.3_on_Ubuntu14.04.md)  
║░║░╚═8 [install spark2.1.0](01_Spark_Installation/03_on_Ubuntu14.04/08_Install_Spark2.1.0_on_Ubuntu14.04.md)  
║░╠═2 on Ubuntu 16.04  
║░║░╠═1 [install ssh](01_Spark_Installation/04_on_Ubuntu16.04/01_install_ssh/00_install_ssh.md)  
║░║░╠═2 [install jdk8](01_Spark_Installation/04_on_Ubuntu16.04/02_install_jdk8/00_install_jdk8.md)  
║░║░╠═3 [install hadoop2.8.5](01_Spark_Installation/04_on_Ubuntu16.04/03_install_hadoop2.8.5/00_install_hadoop2.8.5.md)  
║░║░╠═4 install spark2.4.4 with resource manager  
║░║░║░╠═1 [with spark standalone](01_Spark_Installation/04_on_Ubuntu16.04/04_install_spark2.4.4/01_spark_standalone/00_install_spark2.4.3.md)  
║░║░║░╚═2 [with hadoop yarn](01_Spark_Installation/04_on_Ubuntu16.04/04_install_spark2.4.4/02_hadoop_yarn/00_install_spark2.4.4.md)  
╠═2 Spark Workspace  
║░╠═1 spark-shell  
║░║░╠═1 WordCount  
║░║░║░╠═1 [on spark](02_Spark_Workspace/01_spark-shell/01_WordCount/01_on_spark.md)  
║░║░║░╚═2 [on yarn](02_Spark_Workspace/01_spark-shell/01_WordCount/02_on_yarn.md)  
║░║░╠═2 PageRank  
║░║░║░╠═1 [on yarn](02_Spark_Workspace/01_spark-shell/02_PageRank/01_on_yarn.md)  
║░║░║░╚═2 [on yarn with graphframes](02_Spark_Workspace/01_spark-shell/02_PageRank/02_on_yarn_with_graphframes.md)  
║░╠═2 spark-submit  
║░║░╠═1 WordCount  
║░║░║░╚═1 with JDK8  
║░║░║░░░╠═1 [Console Log](02_Spark_Workspace/02_spark-submit/02_with_JDK8/01_Spark-submit_WordCount.md)  
║░║░║░░░╚═2 [Source code](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/main/java/rwoo/study/spark/example/WordCount.java)  
║░║░╚═2 PageRank  
║░╚═3  
╚═3 Spark Document  
░░╠═1 RDD paper  
░░║░╚═1 [RDD paper in Korean](03_Spark_Document/01_RDD_paper/01_Resilient_Distributed_Datasets_Essay_to_Korean.md)  
░░╠═2 RDD API doc  
░░╚═3 pair RDD functions doc  
░░░░╠═1 Scala  
░░░░║░╠═1 flatMapValues  
░░░░║░║░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@flatMapValues[U](f:V=%3ETraversableOnce[U]):org.apache.spark.rdd.RDD[(K,U)])  
░░░░║░║░╚═2 [example on spark-shell](03_Spark_Document/03_pair_RDD_functions_doc/01_for_Scala/01_flatMapValues_example.md)  
░░░░║░╠═2 groupByKey  
░░░░║░║░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@groupByKey():org.apache.spark.rdd.RDD[(K,Iterable[V])])  
░░░░║░║░╚═2 [example on spark-shell](03_Spark_Document/03_pair_RDD_functions_doc/01_for_Scala/02_groupByKey_example.md)  
░░░░║░╠═3 join  
░░░░║░║░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@join[W](other:org.apache.spark.rdd.RDD[(K,W)]):org.apache.spark.rdd.RDD[(K,(V,W))])  
░░░░║░║░╚═2 [example on spark-shell](03_Spark_Document/03_pair_RDD_functions_doc/01_for_Scala/03_join_example.md)  
░░░░║░╠═4 mapValues  
░░░░║░║░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@mapValues[U](f:V=%3EU):org.apache.spark.rdd.RDD[(K,U)])  
░░░░║░║░╚═2 [example on spark-shell](03_Spark_Document/03_pair_RDD_functions_doc/01_for_Scala/04_mapValues_example.md)  
░░░░║░╚═5 reduceByKey  
░░░░║░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions@reduceByKey(func:(V,V)=%3EV):org.apache.spark.rdd.RDD[(K,V)])  
░░░░║░░░╚═2 [example on spark-shell](03_Spark_Document/03_pair_RDD_functions_doc/01_for_Scala/05_reduceByKey_example.md)  
░░░░╚═2 Java  
░░░░░░╚═1 join  
░░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#join-org.apache.spark.api.java.JavaPairRDD-)  
░░░░░░░░╚═2 [JoinTest : source code](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/JoinTest.java)  

# Example of Spark

░░░░╚═2 Java  
░░░░░░╚═1 join  
░░░░░░░░╠═1 [doc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/api/java/JavaPairRDD.html#join-org.apache.spark.api.java.JavaPairRDD-)  
░░░░░░░░╚═2 [JoinTest : source code](02_Spark_Workspace/02_spark-submit/02_with_JDK8/src/test/java/rwoo/study/spark/JoinTest.java)  

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
