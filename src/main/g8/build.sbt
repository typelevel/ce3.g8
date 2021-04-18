ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := $if(scala3.truthy)$"3.0.0-RC2"$else$"2.13.5"$endif$

lazy val root = (project in file(".")).settings(
  name := "$name;format="norm"$",
  libraryDependencies ++= Seq(
    // "core" module - IO, IOApp, schedulers
    // This pulls in the kernel and std modules automatically.
    "org.typelevel" %% "cats-effect" % "3.0.2",
    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
    "org.typelevel" %% "cats-effect-kernel" % "3.0.2",
    // standard "effect" library (Queues, Console, Random etc.)
    "org.typelevel" %% "cats-effect-std" % "3.0.2"$if(scala3.truthy)$$else$,
    // better monadic for compiler plugin as suggested by documentation
    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")$endif$$if(testlib-use-cats-effect-testing-specs2.truthy)$,
    "org.typelevel" %% "cats-effect-testing-specs2" % "1.0.1" % Test$else$$endif$$if(testlib-use-munit-cats-effect-3.truthy)$,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.1" % Test$else$$endif$

  )
)
