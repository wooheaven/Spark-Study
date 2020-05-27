package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object MapPartitionsWithIndexTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.mapPartitionsWithIndex")
    val rddA = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7), 3)
    println(customToString(rddA.glom().collect()))

    mapPartitionsWithIndex_with_Explicit(rddA)
    mapPartitionsWithIndex_with_IMplicit(rddA)
  }

  def mapPartitionsWithIndex_with_Explicit(rdd: RDD[Int]) = {
    def f(partitionIndex: Int, iter: Iterator[Int]) = {
      (partitionIndex, iter.sum).productIterator
    }

    val result = rdd.mapPartitionsWithIndex(f)
    println(customToString2(result.glom().collect()))
  }

  def mapPartitionsWithIndex_with_IMplicit(rdd: RDD[Int]): Unit = {
    val result = rdd.mapPartitionsWithIndex(
      (partitionIndex, iter) => (partitionIndex, iter.sum).productIterator)
    println(customToString2(result.glom().collect()))
  }

  def customToString2(a: Array[Array[Any]]): String = {
    val str = for (l <- a) yield l.mkString("{", ",", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }

  def customToString(a: Array[Array[Int]]): String = {
    val str = for (l <- a) yield l.mkString("{", ",", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }
}
