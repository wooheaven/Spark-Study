package rwoo.study.spark.rdd.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object FlatMapTest {


  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDD.flatMap").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rddA = sc.parallelize(List("I am a boy", "You are a girl"))
    val rddB = sc.parallelize(List(1, 2, 3))

    sentenseToWords(rddA)
    listToList(rddB)
  }

  def sentenseToWords(rdd: RDD[String]): Unit = {
    val result = rdd.flatMap(v => v.split(" "))
    println(customToString(rdd.collect()))
    println(customToString(result.collect()))
  }

  def listToList(rdd: RDD[Int]): Unit = {
    val result = rdd.flatMap(v => List(v, v + 10, v + 20))
    println(customToString(result.collect()))
  }

  def customToString(a: Array[String]): String = {
    val str = for (l <- a) yield l.mkString("{", "", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }

  def customToString(a: Array[Int]): String = {
    val str = for (l <- a) yield l.toString.mkString("{", "", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }
}
