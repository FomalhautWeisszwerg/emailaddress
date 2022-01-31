val appName = "emailaddress"

lazy val emailaddress = Project(appName, file("."))
//  .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning, SbtArtifactory)
//  .settings(majorVersion := 3)
//  .settings(makePublicallyAvailableOnBintray := true)
  .settings(
    scalacOptions ++= Seq(
      "-feature",
      "-language:implicitConversions"
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-json" % "2.9.2" % Provided,
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.pegdown" % "pegdown" % "1.6.0" % Test,
      "org.scalacheck" %% "scalacheck" % "1.13.5" % Test
    ),
    crossScalaVersions := Seq("2.13.8")
  )
