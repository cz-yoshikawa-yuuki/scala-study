name := """adapter"""

version := "1.0-SNAPSHOT"

//resolvers ++= WebAppBuild.resolvers

scalaVersion := WebAppBuild.scalaV

libraryDependencies ++= WebAppBuild.dependency

// for @Lenses macro support
addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)

updateOptions := updateOptions.value.withCachedResolution(true)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:reflectiveCalls",
  "-language:implicitConversions")

sources in (Compile, doc) := Seq.empty

scalaSource in Compile := baseDirectory.value / "app"
scalaSource in Test := baseDirectory.value / "test"

// コンパイル時に不要なArtifactを作成しない
publishArtifact in (Compile, packageDoc) := false

// scalafmt
reformatOnCompileSettings

crossPaths := false
