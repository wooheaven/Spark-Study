package rwoo.study.spark.rdd.rdd

import org.apache.spark.{SparkConf, SparkContext}

object FlatMapWithCaseTest {



  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDD.flatMap").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rddA = sc.parallelize(List(("A", List("C", "D")), ("C", List("A")), ("D", List("B", "C")), ("B", List("A"))))
    val rddB = rddA.mapValues(v => 1.0)
    val rddC = rddA.join(rddB)
    println(customToString(rddC.collect))

    val result = rddC.flatMap({
      case (url, (links, rank)) => links.map(dest => (dest, rank / links.size))
    })
    println(customToString2(result.collect))
  }

  def customToString(a: Array[(String, (List[String], Double))]): String = {
    val str = for (l <- a) yield (l._1 + " " + l._2._1.toString() + " " + l._2._2).mkString("{", "", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }

  def customToString2(a: Array[(String, Double)]): String = {
    val str = for (l <- a) yield (l._1 + " " + l._2).mkString("{", "", "}")
    str.mkString("{\n\t", ",\n\t", "\n}")
  }
}
