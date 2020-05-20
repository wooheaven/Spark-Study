package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext

object DistinctTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.Distinct")
    val a = sc.parallelize(Array(1, 2, 3, 2))
    val b = a.distinct()
    println(customToString(a.collect()))
    println(customToString(b.collect()))

    def customToString(a: Array[Int]): String = {
      val str = a.mkString("{", ",", "}")
      str
    }
  }
}
