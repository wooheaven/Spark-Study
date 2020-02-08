package rwoo.study.spark.rdd.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object MapPartitionsWithIndexTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "RDD.mapPartitionsWithIndex")
    val rddA = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7), 3)

    def f(partitionIndex: Int, iter: Iterator[Int]) = {
      (partitionIndex, iter.sum).productIterator
    }

    val rddB = rddA.mapPartitionsWithIndex(f)

    println(customToString(rddA.glom().collect()))
    println(customToString2(rddB.glom().collect()))

    def customToString(a: Array[Array[Int]]): String = {
      val str = for (l <- a) yield l.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }

    def customToString2(a: Array[Array[Any]]): String = {
      val str = for (l <- a) yield l.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }
  }
}
