import AssemblyKeys._ // put this at the top of the file
import libraries._

name := "learning-spark-mini-example"
version := "1.0"
scalaVersion := "2.10.4"
libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "1.3.0" % "provided"
)
