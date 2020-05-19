package rwoo.study.spark.rdd.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.SparkContext

object AggregateTest {
  val log = log4j.LogManager.getLogger(getClass.getName)


  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val sc = new SparkContext("local[*]", "RDD.aggregate")
    val a = sc.parallelize(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)

    def zeroValue = (Array[Int](), 0)

    def seqOp = (data: (Array[Int], Int), item: Int)
    => (data._1 :+ item, data._2 + item)

    def combOp = (d1: (Array[Int], Int), d2: (Array[Int], Int))
    => (d1._1.union(d2._1), d1._2 + d2._2)

    val b = a.aggregate(zeroValue)(seqOp, combOp)
    println(customToString(a.glom().collect()))
    println(customToString2(b))

    def customToString(a: Array[Array[Int]]): String = {
      val str = for (l <- a) yield l.mkString("[", ",", "]")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }

    def customToString2(a: (Array[Int], Int)): String = {
      val str = a._1.mkString("[", ",", "]") + " : " + a._2.toString()
      str
    }
  }
}
