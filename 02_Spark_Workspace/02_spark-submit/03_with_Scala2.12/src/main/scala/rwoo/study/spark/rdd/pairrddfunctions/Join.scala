package rwoo.study.spark.rdd.pairrddfunctions

import org.apache.spark.SparkContext

object JoinTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "PairRDDFunctions.join")
    val rddA = sc.parallelize(List(("A", 2), ("B", 2)))
    val rddB = sc.parallelize(List(("B", 3), ("C", 3)))

    println(customToString(rddA.join(rddB).collect()))
    println(customToString2(rddA.leftOuterJoin(rddB).collect()))
    println(customToString3(rddA.rightOuterJoin(rddB).collect()))
    println(customToString4(rddA.fullOuterJoin(rddB).collect()))
  }

  def customToString(l: Array[(String, (Int, Int))]): String = {
    val str = l.mkString("{\n\t", ",\n\t", "\n}")
    str
  }

  def customToString2(l: Array[(String, (Int, Option[Int]))]): String = {
    val str = l.mkString("{\n\t", ",\n\t", "\n}")
    str
  }

  def customToString3(l: Array[(String, (Option[Int], Int))]): String = {
    val str = l.mkString("{\n\t", ",\n\t", "\n}")
    str
  }

  def customToString4(l: Array[(String, (Option[Int], Option[Int]))]): String = {
    val str = l.mkString("{\n\t", ",\n\t", "\n}")
    str
  }
}
