name := "scala-java-sbt-practice"

ThisBuild / organization := "com.ngdangdat"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.12.10"

lazy val commonSettings = Seq(target := { baseDirectory.value / "target" })

lazy val root: Project = (project in file("."))
  .aggregate(core, server)
  .dependsOn(core, server)
  .settings(
    commonSettings,
    aggregate in assembly := false,
    name := "Java Scala mixed project"
  )

lazy val core: Project = (project in file("core"))
  .settings(commonSettings)
lazy val server: Project = (project in file("server"))
  .settings(commonSettings)
  .dependsOn(core)

mainClass in (Compile, run) := Some("com.ngdangdat.Main")
