// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "ce3.g8",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List(
      "-Xms1024m",
      "-Xmx1024m",
      "-XX:ReservedCodeCacheSize=128m",
      "-Xss2m",
      "-Dfile.encoding=UTF-8"
    ),
    resolvers += Resolver.url(
      "typesafe",
      url("https://repo.typesafe.com/typesafe/ivy-releases/")
    )(Resolver.ivyStylePatterns),
    ThisBuild / githubWorkflowPublishTargetBranches := Seq(),
    ThisBuild / githubWorkflowBuild := Seq(WorkflowStep.Sbt(List("g8Test"), name = Some("Testing template"))),
    // These are duplicated here for Scala Steward
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.2.5",
      "org.typelevel" %% "cats-effect-kernel" % "3.2.5",
      "org.typelevel" %% "cats-effect-std" % "3.2.5",
      "org.typelevel" %% "cats-effect-testing-specs2" % "1.2.0" % Test,
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.5" % Test
    )
  )
