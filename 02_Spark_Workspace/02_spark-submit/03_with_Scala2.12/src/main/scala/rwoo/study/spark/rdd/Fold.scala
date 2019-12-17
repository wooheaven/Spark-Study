package rwoo.study.spark.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.{SparkConf, SparkContext}

object FoldTest {
  def main(args: Array[String]): Unit = {
    val log = log4j.LogManager.getLogger("Fold Test Log")
    log.setLevel(Level.INFO)
    val conf = new SparkConf().setAppName("RDD.fold").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rddA = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
    val result = rddA.fold(0)(_+_)
    log.info("Fold result =" + result)
  }
}
