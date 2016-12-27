import sbt._
import Keys._

name := "webapp-study"

version := "1.0"

lazy val root = (project in file("."))
  .aggregate(adapter, domain, usecase, other)
  .dependsOn(adapter, domain, usecase, other)

lazy val adapter = (project in file("modules/adapter")).dependsOn(usecase, other)

lazy val domain = (project in file("modules/domain")).dependsOn(other)

lazy val usecase = (project in file("modules/usecase")).dependsOn(domain, other)

lazy val other = project in file("modules/other")

scalaVersion := WebAppBuild.scalaV

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint")

libraryDependencies ++= WebAppBuild.dependency

scalaSource in Compile := baseDirectory.value / "app"

Revolver.settings

scalafmtConfig in ThisBuild := Some(file(".scalafmt.conf"))

// wait for scalafmt version up.
// reformatOnCompileSettings

enablePlugins(JavaAppPackaging)