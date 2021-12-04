name := "UtItAssignment"

version := "0.1"

scalaVersion := "2.13.7"

lazy val module1 = project.in(file("module1"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % "test",
      "org.mockito" %% "mockito-scala" % "1.16.46" % "test"
    ))

lazy val module2 = project.in(file("module2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % "test",
      "org.mockito" %% "mockito-scala" % "1.16.46" % "test"
    ))