# Example of Spark

RDD Operation | Transformation / Action | Narrow / Wide  
--- | --- | ---
[1st Map](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapTest.java) | T | N 
[2nd FlatMap](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapTest.java) | T | N
[3rd Filter](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FilterTest.java) | T | N
[4th Reduce](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ReduceTest.java) | A | W
[5th ReduceByKey](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ReduceByKeyTest.java) | T | W
[6th GroupBy](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/GroupByTest.java) | T | W
[7th GroupByKey](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/GroupByKeyTest.java) | T | W
[8th Join](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/JoinTest.java) | T | W
[9th CoGroup](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/CoGroupTest.java) | T | W
[10th Union](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/UnionTest.java) | T | N

[List\<Tuple2\<String,String\>\> to JavaPairRDD\<String,String\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/ListTupleToJavaPairRDDTest.java)

[Join, Left, Right, Full Outer Join with List\<Tuple2\<String,Integer\>\>](01_Spark_Java_Workspace/spark2WithJDK7/src/test/java/javapairrdd/JoinTest.java)

[MapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/MapToDoubleTest.java)

[FlatMapToDouble with List\<Tuple2\<Double,Double\>\>](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/FlatMapToDoubleTest.java)

[WordCount](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/WordCountTest.java)

[Column to Rows as Pivot](01_Spark_Java_Workspace/spark2WithJDK8/src/test/java/rwoo/study/spark/ColumnToRowsTest.java)

# Install of Spark on CentOS6.9

[1 Install CentOS6.9 on docker](02_Install_Spark/02_on_CentOS6.9/01_Run_CentOS6.9_on_docker.md)

[2 Install JDK8 on CentOS6.9 on docker container](02_Install_Spark/02_on_CentOS6.9/02_Install_JDK8_on_CentOS6.9_docker_container.md)

[3 Install Maven3.3.9 on CentOS6.9 on docker container](02_Install_Spark/02_on_CentOS6.9/03_Install_Maven3.3.9_on_CentOS6.9_docker_container.md)

[4 Install Scala2.12.1 on CentOS6.9 docker container](02_Install_Spark/02_on_CentOS6.9/04_Install_Scala2.12.1_on_CentOS6.9_docker_container.md)

[5_Install Sbt0.13.15 on CentOS6.9 docker container](02_Install_Spark/02_on_CentOS6.9/05_Install_Sbt0.13.15_on_CentOS6.9_docker_container.md)

# Install of Spark on Ubuntu14.04

[1 Dockerfile](02_Install_Spark/01_on_Ubuntu14.04/Dockerfile)

[2 Docer Build](02_Install_Spark/01_on_Ubuntu14.04/DockerBuild.md)

[1 Install Ubuntu14.04 on Docker](02_Install_Spark/01_on_Ubuntu14.04/01_Run_Ubuntu14.04_on_docker.md)

[2 Install JDK8 on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/02_Install_JDK8_on_Ubuntu14.04.md)

[3 Install Maven3.3.9 on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/03_Install_Maven3.3.9_on_Ubuntu14.04.md)

[4 Install Scala2.12.1 on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/04_Install_Scala2.12.1_on_Ubuntu14.04.md)

[5 Install Sbt0.13.15 on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/05_Install_Sbt0.13.15_on_Ubuntu14.04.md)

[6 Install ssh on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/06_Install_ssh_on_Ubuntu14.04.md)

[7 Install Hadoop2.7.3 on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/07_Install_Hadoop2.7.3_on_Ubuntu14.04.md)

[8 Install Spark2.1.0 on Ubuntu14.04](02_Install_Spark/01_on_Ubuntu14.04/08_Install_Spark2.1.0_on_Ubuntu14.04.md)

# Config of Spark

[Config of IntelliJ IBus](03_Config_Spark/01_IBus_Config_for_IntelliJ.md)

# Spark Document 

[RDD paper](04_Spark_Document/01_Resilient_Distributed_Datasets_Essay_to_Korean.md)
