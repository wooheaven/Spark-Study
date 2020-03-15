package rwoo.study.spark.rdd.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object UnionTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "RDD.union")
    val a = sc.parallelize(Array(1, 3, 5))
    val b = sc.parallelize(Array(2, 4, 6))
    val c = a.union(b)
    println(customToString(c.collect()))

    def customToString(a: Array[Int]): String = {
      val str = a.mkString("{", ",", "}")
      str
    }
  }
}
