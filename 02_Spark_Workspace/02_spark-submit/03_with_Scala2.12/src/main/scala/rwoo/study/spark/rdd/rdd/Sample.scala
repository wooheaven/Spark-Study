package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext

object SampleTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.sample")
    val x = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    val y = x.sample(false, 0.5, 30)
    println(customToString(y.collect()))

    def customToString(a: Array[Int]): String = {
      val str = a.mkString("{", ",", "}")
      str
    }
  }
}
