package rwoo.study.spark.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object TakeTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "RDD.take")
    val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10))
    rddA.take(4).foreach(println)
  }
}
