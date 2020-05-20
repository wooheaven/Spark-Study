package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object TopTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.top")
    val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10))
    rddA.top(3).foreach(println)
    rddA.top(3)(new StringOrdering).foreach(println)
  }
}

class StringOrdering extends Ordering[Int] {
  override def compare(x: Int, y: Int): Int = x.toString.compareTo(y.toString)
}
