package rwoo.study.spark.rdd

import org.apache.log4j
import org.apache.log4j.Level
import org.apache.spark.{SparkConf, SparkContext}

object CacheTest {
  val log = log4j.LogManager.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.setLevel(Level.INFO)
    val conf = new SparkConf().setAppName("RDD.cache").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rddA = sc.parallelize(List("b", "a", "c"))
    val result = rddA.map(v => (v, 1)).cache()
    result.foreach(tuple => {
      log.info("map result element " + tuple.toString())
    })
  }
}
