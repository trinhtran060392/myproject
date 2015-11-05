name := """rest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  cache,
  "com.trinhtv3.services.student" % "student" % "1.0-SNAPSHOT"
)

resolvers ++= Seq(
	Resolver.sonatypeRepo("snapshots"),
	Resolver.mavenLocal
)