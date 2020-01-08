package rwoo.study.spark.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object KeyByTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local", "RDD.keyBy")
    val rddA = sc.parallelize(Array("John", "Fred", "Anna", "James"))
    val rddB = rddA.keyBy(x => x.charAt(0)).sortByKey()
    rddB.foreach(println)
  }
}
