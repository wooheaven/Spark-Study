package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object KeyByTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.keyBy")
    val rddA = sc.parallelize(Array("John", "Fred", "Anna", "James"))
    val rddB = rddA.keyBy(x => x.charAt(0)).sortByKey()
    rddB.foreach(println)
  }
}
