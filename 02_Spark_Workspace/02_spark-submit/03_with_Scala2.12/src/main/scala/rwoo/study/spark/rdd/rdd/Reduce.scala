package rwoo.study.spark.rdd.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object ReduceTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "RDD.reduce")
    val a = sc.parallelize(Array(1, 2, 3, 4))
    println(a.reduce(_ + _))
    println(a.reduce((x, y) => x + y))
    println(a.reduce(_ * _))
    println(a.reduce((x, y) => x * y))
  }
}
