package rwoo.study.spark.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object GetNumPartitionsTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
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