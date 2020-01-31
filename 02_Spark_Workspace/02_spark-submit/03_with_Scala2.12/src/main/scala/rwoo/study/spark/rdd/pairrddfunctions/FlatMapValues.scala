package rwoo.study.spark.rdd.pairrddfunctions

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object FlatMapValuesTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "PairRDDFunctions.flatMapValues")
    val rddA = sc.parallelize(List(("A", List("C", "D")), ("C", List("A")), ("D", List("B", "C")), ("B", List("A"))))
    val rddB = rddA.flatMapValues(x => x)
    val rddC = rddB.groupByKey()

    println(customToString(rddA.collect()))
    println(customToString2(rddB.collect()))
    println(customToString3(rddC.collect()))

    def customToString(a: Array[(String, List[String])]): String = {
      val str = for (t <- a) yield t._1 + " : " + t._2.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }

    def customToString2(a: Array[(String, String)]): String = {
      val str = for (t <- a) yield t._1 + " : " + t._2
      str.mkString("{\n\t", ",\n\t", "\n}")
    }

    def customToString3(a: Array[(String, Iterable[String])]): String = {
      val str = for (t <- a) yield t._1 + " : " + t._2.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }
  }
}
