package rwoo.study.spark.rdd.pairrddfunctions

import org.apache.spark.SparkContext

object CountByKeyTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "PairRDDFunctions.countByKey")
    val rddA = sc.parallelize(Array(('J', "James"), ('F', "Fred"), ('A', "Anna"), ('J', "John")))
    val countDict = rddA.countByKey()
    println(countDict)
  }
}
