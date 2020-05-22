package rwoo.study.spark.rdd.rdd

import java.io.File

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.SparkContext

object SaveAsTextFileTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "RDD.saveAsTextFile")
    val a = sc.parallelize(Array(2, 4, 1), 2)
    val fs = FileSystem.get(sc.hadoopConfiguration)
    val pathStr = "./src/main/resources/rwoo/study/spark/rdd/rdd/SaveAsTextFile"
    val path = new Path(new File(pathStr).getCanonicalPath())
    if (fs.exists(path)) {
      fs.delete(path, true)
    }
    a.saveAsTextFile(pathStr)
    customPrint(fs, path)
  }

  def customPrint(fs: FileSystem, path:Path): Unit = {
    val tmp = fs.listFiles(path, true)
    while (tmp.hasNext) {
      println(tmp.next.getPath.toString)
    }
  }
}
