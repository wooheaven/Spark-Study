package rwoo.study.spark.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.{SparkConf, SparkContext}

object FlatMapTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val conf = new SparkConf().setAppName("RDD.flatMap").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rddA = sc.parallelize(List("I am a boy", "You are a girl"))
    val rddB = rddA.flatMap(v => v.split(" "))
    println(customToString(rddA.collect()))
    println(customToString(rddB.collect()))
  }

  def customToString(a: Array[String]): String = {
    val str = for (l <-a) yield l.mkString("{", "", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }
}
