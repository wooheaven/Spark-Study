package rwoo.study.spark.rdd.doublerddfunctions

import org.apache.spark.SparkContext

object MeanTest{

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.mean")
    val a = sc.parallelize(Array(2, 4, 10))

    println(a.mean())
  }
}
