import sbt._

object Dependencies {

  lazy val version = new {
    val scalaTest = "3.0.0"
    val scalaCheck = "1.13.4"
    val spark = "2.2.0"
    val akka = "2.5.3"
    val uap = "0.1.2"
  }

  lazy val library = new {
    val test = "org.scalatest" %% "scalatest" % version.scalaTest % Test
    val check = "org.scalacheck" %% "scalacheck" % version.scalaCheck % Test
  }


  lazy val spark = new {
    lazy val core = "org.apache.spark" %% "spark-core" % version.spark //% "provided"
    lazy val sql = "org.apache.spark" %% "spark-sql" % version.spark //% "provided"
    lazy val kinesis = "org.apache.spark" %% "spark-streaming-kinesis-asl" % version.spark //% "provided"
    lazy val cassandra = "com.datastax.spark" %% "spark-cassandra-connector" % "2.0.3" //% "provided"

  }

  lazy val config = "com.typesafe" % "config" % "1.3.1"

  val dep: Seq[ModuleID] = Seq(
    spark.core,
    spark.sql,
    spark.kinesis,
    spark.cassandra,
    config
  )
}
