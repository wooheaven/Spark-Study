package rwoo.study.spark.rdd.pairrddfunctions

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object MapValuesTest {
  val log = log4j.LogManager.getLogger(getClass.getName)


  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "PairRDDFunctions.mapValues")
    val rddA = sc.parallelize(List(("A", List("C", "D")), ("C", List("A")), ("D", List("B", "C")), ("B", List("A"))))
    val rddB = rddA.mapValues(x => 1.0)

    println(customToString(rddA.collect()))
    println(customToString2(rddB.collect()))

    def customToString(a: Array[(String, List[String])]): String = {
      val str = for (t <- a) yield t._1 + " : " + t._2.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }

    def customToString2(a: Array[(String, Double)]): String = {
      val str = for (t <- a) yield t._1 + " : " + t._2
      str.mkString("{\n\t", ",\n\t", "\n}")
    }
  }
}
