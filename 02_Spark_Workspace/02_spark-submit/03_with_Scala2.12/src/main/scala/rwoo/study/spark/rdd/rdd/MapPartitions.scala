package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object MapPartitionsTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.mapPartitions")
    val rddA = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7), 3)
    println(customToString(rddA.glom().collect()))

    mapPartitions_with_Explicit(rddA)
    mapPartitions_with_Implicit(rddA)
  }

  def mapPartitions_with_Explicit(rdd: RDD[Int]) = {
    def f(iter: Iterator[Int]): Iterator[Any] = {
      List(iter.sum).iterator
    }

    val result = rdd.mapPartitions(f)
    println(customToString2(result.glom().collect()))
  }

  def customToString2(a: Array[Array[Any]]): String = {
    val str = for (l <- a) yield l.mkString("{", ",", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }

  def mapPartitions_with_Implicit(rdd: RDD[Int]) = {
    val result = rdd.mapPartitions(iter => List(iter.sum).iterator)
    println(customToString(result.glom().collect()))
  }

  def customToString(a: Array[Array[Int]]): String = {
    val str = for (l <- a) yield l.mkString("{", ",", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }
}
