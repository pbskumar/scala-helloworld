import org.apache.spark._
import org.apache.log4j.{Level, LogManager}

object HelloWorld {
  def main(args: Array[String]): Unit = {
	val log = LogManager.getRootLogger
	log.setLevel(Level.WARN)
	
	val conf = new SparkConf()
	conf.set("spark.master", "local")
	conf.set("spark.app.name", "hello")
	
	val sc = new SparkContext(conf)
	
	val rdd1 = sc.range(1, 100)
	rdd1.collect.foreach(println)
    
	log.warn("Execution Complete!")
	sc.stop()
  }
}