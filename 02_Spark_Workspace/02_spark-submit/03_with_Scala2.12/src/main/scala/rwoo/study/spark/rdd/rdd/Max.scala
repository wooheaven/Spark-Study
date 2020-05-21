package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext

object MaxTest{

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.max")
    val a = sc.parallelize(Array(2, 4, 10))

    println(a.max())
    println(a.max()(ord = new Ordering[Int]() {
      override def compare(x: Int, y: Int): Int = {
        Ordering[String].compare(x.toString, y.toString)
      }
    }))
  }
}
