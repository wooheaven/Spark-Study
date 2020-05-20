package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object TakeOrderedTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.takeOrdered")
    val rddA = sc.parallelize(List(1, 2, 3, 2, 3, 10))
    rddA.takeOrdered(3).foreach(println)
    rddA.takeOrdered(3)(new StringOrdering).foreach(println)
  }
}
