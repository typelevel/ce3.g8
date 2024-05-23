import org.typelevel.sbt.tpolecat.*

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := $if(scala3.truthy)$"3.4.0"$else$"2.13.13"$endif$

$if(!use-fatal-warnings.truthy)$// This disables fatal-warnings for local development. To enable it in CI set the `SBT_TPOLECAT_CI` environment variable in your pipeline.
// See https://github.com/typelevel/sbt-tpolecat/?tab=readme-ov-file#modes
ThisBuild / tpolecatDefaultOptionsMode := VerboseMode
$endif$

lazy val root = (project in file(".")).settings(
  name := "$name;format="norm"$",
  libraryDependencies ++= Seq(
    // "core" module - IO, IOApp, schedulers
    // This pulls in the kernel and std modules automatically.
    "org.typelevel" %% "cats-effect" % "3.5.3",
    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
    "org.typelevel" %% "cats-effect-kernel" % "3.5.3",
    // standard "effect" library (Queues, Console, Random etc.)
    "org.typelevel" %% "cats-effect-std" % "3.5.3"$if(scala3.truthy)$$else$,
    // better monadic for compiler plugin as suggested by documentation
    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")$endif$$if(testlib-use-cats-effect-testing-specs2.truthy)$,
    "org.typelevel" %% "cats-effect-testing-specs2" % "1.5.0" % Test$else$$endif$$if(testlib-use-munit-cats-effect-3.truthy)$,
    "org.typelevel" %% "munit-cats-effect" % "2.0.0" % Test$else$$endif$
  )
)
