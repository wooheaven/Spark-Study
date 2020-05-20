package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext

object CollectTest {

  def main(args: Array[String]): Unit = {

    val sc = new SparkContext("local[*]", "RDD.collect")
    val a = sc.parallelize(Array(1, 2, 3))
    println(customToString(a.collect()))

    def customToString(a: Array[Int]): String = {
      val str = a.mkString("{", ",", "}")
      str
    }
  }
}
