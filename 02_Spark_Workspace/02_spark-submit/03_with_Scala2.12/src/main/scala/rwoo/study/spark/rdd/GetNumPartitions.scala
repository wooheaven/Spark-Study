package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object GetNumPartitionsTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.getNumPartitions")
    val rddA = sc.parallelize(Array(1, 2, 3), 2)

    println(customToString(rddA.glom().collect()))
    println(rddA.getNumPartitions)

    def customToString(a: Array[Array[Int]]): String = {
      val str = for (l <- a) yield l.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }
  }
}