package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object CoalesceTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.coalesce")
    val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10), 3)
    println(customToString(rddA.glom().collect()))
    println(customToString(rddA.coalesce(2).glom().collect()))
  }

  def customToString(a: Array[Array[Int]]): String = {
    val str = for (l <- a) yield l.mkString("{", ",", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }
}
