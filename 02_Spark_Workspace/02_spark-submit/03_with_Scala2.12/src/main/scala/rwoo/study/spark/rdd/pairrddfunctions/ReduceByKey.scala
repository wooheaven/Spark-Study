package rwoo.study.spark.rdd.pairrddfunctions

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object ReduceByKeyTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "PairRDDFunctions.reduceByKey")
    val rddA = sc.parallelize(List(("A", 1.0), ("B", 2.0), ("C", 3.0), ("A", 4.0)))
    val rddB = rddA.reduceByKey(_ + _)

    print(customToString(rddA.collect()))
    print(customToString(rddB.collect()))

    def customToString(l: Array[(String, Double)]): String = {
      val str = for (t <- l) yield t._1 + " : " + t._2
      str.mkString("{\n\t", "\n\t", "\n}\n")
    }
  }
}
