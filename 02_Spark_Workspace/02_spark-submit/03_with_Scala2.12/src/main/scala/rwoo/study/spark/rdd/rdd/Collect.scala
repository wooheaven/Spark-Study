package rwoo.study.spark.rdd.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object CollectTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "RDD.collect")
    val a = sc.parallelize(Array(1, 2, 3))
    println(customToString(a.collect()))

    def customToString(a: Array[Int]): String = {
      val str = a.mkString("{", ",", "}")
      str
    }
  }
}
