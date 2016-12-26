logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("io.spray" % "sbt-revolver" % "0.8.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.2")

// Binary version (2.11) for dependency org.scala-lang#scala-library;2.11.8 warning is scalafmt problem. wait for upgrade.
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.4.8")

// Java のコマンドラインアプリケーションをデプロイ
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.1")