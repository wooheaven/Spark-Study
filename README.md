╠═1 Install Spark  
║░╠═1 Spark Version  
║░║░╚═1 [Spark, Java, Hadoop, Scala, Python, R : version compatibility](01_Install_Spark/01_Spark_version/01_Spark_Java_Hadoop_Scala_Python_R_version.md)  
║░╠═2 on CentOS 6.9  
║░║░╠═1 [docker pull centos:6.9](01_Install_Spark/02_on_CentOS6.9/01_Run_CentOS6.9_on_docker.md)  
║░║░╠═2 [install JDK8](01_Install_Spark/02_on_CentOS6.9/02_Install_JDK8_on_CentOS6.9_docker_container.md)  
║░║░╠═3 [install Maven3.3.9](01_Install_Spark/02_on_CentOS6.9/03_Install_Maven3.3.9_on_CentOS6.9_docker_container.md)  
║░║░╠═4 [install Scala2.12.1](01_Install_Spark/02_on_CentOS6.9/04_Install_Scala2.12.1_on_CentOS6.9_docker_container.md)  
║░║░╚═5 [install Sbt0.13.15](01_Install_Spark/02_on_CentOS6.9/05_Install_Sbt0.13.15_on_CentOS6.9_docker_container.md)  
║░╠═2 on Ubuntu 14.04  
║░║░╠═1 [docker pull ubuntu:14.04](01_Install_Spark/03_on_Ubuntu14.04/01_Run_Ubuntu14.04_on_docker.md)  
║░║░╠═2 [install JDK8](01_Install_Spark/03_on_Ubuntu14.04/02_Install_JDK8_on_Ubuntu14.04.md)  
║░║░╠═3 [install Maven3.3.9](01_Install_Spark/03_on_Ubuntu14.04/03_Install_Maven3.3.9_on_Ubuntu14.04.md)  
║░║░╠═4 [install Scala2.12.1](01_Install_Spark/03_on_Ubuntu14.04/04_Install_Scala2.12.1_on_Ubuntu14.04.md)  
║░║░╠═5 [install Sbt0.13.15](01_Install_Spark/03_on_Ubuntu14.04/05_Install_Sbt0.13.15_on_Ubuntu14.04.md)  
║░║░╠═6 [install ssh](01_Install_Spark/03_on_Ubuntu14.04/06_Install_ssh_on_Ubuntu14.04.md)  
║░║░╠═7 [install hadoop2.7.3](01_Install_Spark/03_on_Ubuntu14.04/07_Install_Hadoop2.7.3_on_Ubuntu14.04.md)  
║░║░╚═8 [install spark2.1.0](01_Install_Spark/03_on_Ubuntu14.04/08_Install_Spark2.1.0_on_Ubuntu14.04.md)  
║░╠═2 on Ubuntu 16.04  
║░║░╠═1 [install ssh](01_Install_Spark/04_on_Ubuntu16.04/01_install_ssh/00_install_ssh.md)  
║░║░╠═2 [install jdk8](01_Install_Spark/04_on_Ubuntu16.04/02_install_jdk8/00_install_jdk8.md)  
║░║░╠═3 [install hadoop2.8.5](01_Install_Spark/04_on_Ubuntu16.04/03_install_hadoop2.8.5/00_install_hadoop2.8.5.md)  
║░║░╠═4 install spark2.4.3 with resource manager  
║░║░║░╠═1 [with spark standalone](01_Install_Spark/04_on_Ubuntu16.04/04_install_spark2.4.3/01_spark_standalone/00_install_spark2.4.3.md)  
║░║░║░╚═2 [with hadoop yarn](01_Install_Spark/04_on_Ubuntu16.04/04_install_spark2.4.3/02_hadoop_yarn/00_install_spark2.4.3.md)  

# Example of Spark

| RDD Operation                                                                                            | Transformation / Action | Narrow / Wide |
|----------------------------------------------------------------------------------------------------------|-------------------------|---------------|
| [1st Map](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapTest.java)                 | T                       | N             |
| [2nd FlatMap](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapTest.java)         | T                       | N             |
| [3rd Filter](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FilterTest.java)           | T                       | N             |
| [4th Reduce](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ReduceTest.java)           | A                       | W             |
| [5th ReduceByKey](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ReduceByKeyTest.java) | T                       | W             |
| [6th GroupBy](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/GroupByTest.java)         | T                       | W             |
| [7th GroupByKey](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/GroupByKeyTest.java)   | T                       | W             |
| [8th Join](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/JoinTest.java)               | T                       | W             |
| [9th CoGroup](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/CoGroupTest.java)         | T                       | W             |
| [10th Union](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/UnionTest.java)            | T                       | N             |
| [11th Collect](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/CollectTest.java)        | A                       |               |
| [12th Take](01_Spark_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/TakeTest.java)              | A                       |               |

[List\<Tuple2\<String,String\>\> to JavaPairRDD\<String,String\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/ListTupleToJavaPairRDDTest.java)

[Join, Left, Right, Full Outer Join with List\<Tuple2\<String,Integer\>\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/JoinTest.java)

[MapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapToDoubleTest.java)

[FlatMapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapToDoubleTest.java)

[Column to Rows as Pivot](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ColumnToRowsTest.java)

# Spark Official examples 
| RDD API Examples | Link                                                                                                         |
|------------------|--------------------------------------------------------------------------------------------------------------|
| Word Count       | [Scala on spark-shell --master spark](01_Spark_Workspace/01_spark-shell/01_master_spark/01_Word_Count.md)    |
|                  | [Scala on spark-shell --master yarn](01_Spark_Workspace/01_spark-shell/02_master_yarn/01_Word_Count.md)      |
|                  | [Java8 on spark-submit --master yarn](01_Spark_Workspace/spark2WithJDK8/01_Spark-submit_WordCount.md)        |
|                  | [Java8 source code](01_Spark_Workspace/spark2WithJDK8/src/main/java/rwoo/study/spark/example/WordCount.java) |

# Config of Spark

[Config of IntelliJ IBus](03_Config_Spark/01_IBus_Config_for_IntelliJ.md)

# Spark Document 

[RDD paper](04_Spark_Document/01_Resilient_Distributed_Datasets_Essay_to_Korean.md)
