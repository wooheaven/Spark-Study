package rwoo.study.spark.rdd.rdd

import org.apache.spark.SparkContext

object UnionTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.union")
    val a = sc.parallelize(Array(1, 2, 3), 2)
    val b = sc.parallelize(Array(3, 4), 2)
    val c = a.union(b)
    println(customToString(a.collect()))
    println(customToString(b.collect()))
    println(customToString(c.collect()))
    println(customToString2(a.glom().collect()))
    println(customToString2(b.glom().collect()))
    println(customToString2(c.glom().collect()))

    def customToString(a: Array[Int]): String = {
      val str = a.mkString("{", ",", "}")
      str
    }

    def customToString2(a: Array[Array[Int]]): String = {
      val str = for (l <- a) yield l.mkString("{", ",", "}")
      str.mkString("{\n\t", ",\n\t", "\n}")
    }
  }
}
