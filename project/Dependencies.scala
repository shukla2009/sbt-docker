import sbt._

object Dependencies {

  lazy val version = new {
    val scalaTest = "3.0.0"
    val scalaCheck = "1.13.4"
    val spark = "2.2.0"
    val akka = "2.5.3"
    val uap = "0.1.2"
    val cache = "0.9.4"
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

  lazy val akka = new {
    lazy val actor = "com.typesafe.akka" %% "akka-actor" % version.akka
    lazy val cluster = "com.typesafe.akka" %% "akka-cluster" % version.akka
    lazy val clusterMetrics = "com.typesafe.akka" % "akka-cluster-metrics_2.11" % version.akka
    lazy val clusterTool = "com.typesafe.akka" %% "akka-cluster-tools" % version.akka
    lazy val testkit = "com.typesafe.akka" %% "akka-testkit" % version.akka % "test"
  }

  lazy val config = "com.typesafe" % "config" % "1.3.1"
  lazy val jdbc = "org.xerial" % "sqlite-jdbc" % "3.8.11.2"
  lazy val cache = new {
    lazy val scala = "com.github.cb372" %% "scalacache-core" % version.cache
    lazy val eh = "com.github.cb372" %% "scalacache-ehcache" % version.cache
    lazy val redis = "com.github.cb372" %% "scalacache-redis" % version.cache
  }

  val dep: Seq[ModuleID] = Seq(
    spark.core,
    spark.sql,
    spark.kinesis,
    spark.cassandra,
    cache.scala,
    cache.redis,
    config
  )
}
