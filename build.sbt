name := "scala-java-sbt-practice"

ThisBuild / organization := "com.example"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.12.10"

lazy val root: Project = (project in file("."))
  .aggregate(core, server)
  .settings(aggregate in assembly := false)

lazy val core: Project = (project in file("core"))

lazy val server: Project = (project in file("server"))
  .dependsOn(core)
