ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.gu.scalaschool"
ThisBuild / organizationName := "The Guardian"

lazy val root = (project in file("."))
  .settings(
    name := "scala-school-2019",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.8",
      "joda-time" % "joda-time" % "2.10.5"
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
