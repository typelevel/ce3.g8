ThisBuild / tlBaseVersion := "0.0"
ThisBuild / tlCiReleaseTags := false
ThisBuild / tlCiReleaseBranches := Nil
ThisBuild / tlCiDependencyGraphJob := false
ThisBuild / githubWorkflowJavaVersions := List(JavaSpec.temurin("17"))
ThisBuild / githubWorkflowBuild := List(
  WorkflowStep.Sbt(List("g8Test"), name = Some("Test generated template"))
)

lazy val root = (project in file("."))
  .settings(
    name := "ce3.g8",
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    // These are duplicated here for Scala Steward
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.5.5",
      "org.typelevel" %% "cats-effect-kernel" % "3.5.5",
      "org.typelevel" %% "cats-effect-std" % "3.5.5",
      "org.typelevel" %% "cats-effect-testing-specs2" % "1.5.0" % Test,
      "org.typelevel" %% "munit-cats-effect" % "2.0.0" % Test
    ),
    // Add sbt plugins here, so that scala steward updates them in the g8 template
    addSbtPlugin("org.typelevel" % "sbt-tpolecat" % "0.5.2"),
  )
