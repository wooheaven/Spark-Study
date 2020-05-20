package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object TakeTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.take")
    val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10))
    rddA.take(4).foreach(println)
  }
}
