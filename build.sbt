

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      scalaVersion := "2.11.8",
      version      := "1.0.0"
    )),
    name := "sbt-docker",
    libraryDependencies ++= Dependencies.dep
  )
