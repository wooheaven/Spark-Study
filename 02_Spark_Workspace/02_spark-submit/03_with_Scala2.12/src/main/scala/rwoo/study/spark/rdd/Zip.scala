package rwoo.study.spark.rdd

import org.apache.spark.SparkContext

object ZipTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.zip")
    val rddA = sc.parallelize(Array(1, 2, 3))
    val rddB = rddA.map(x => x * x)
    val rddC = rddA.zip(rddB)

    println(customToString(rddA.glom().collect()))
    println(customToString(rddB.glom().collect()))
    println(customToString2(rddC.glom().collect()))

    def customToString(a: Array[Array[Int]]): String = {
      val str = for (l <- a) yield l.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }

    def customToString2(a: Array[Array[(Int, Int)]]): String = {
      val str = for (l <- a) yield l.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }
  }
}
