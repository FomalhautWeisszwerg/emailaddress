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
      "org.scalatest" %% "scalatest" % "3.2.11" % Test,
      "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % "test",
      "org.pegdown" % "pegdown" % "1.6.0" % Test,
    ),
    crossScalaVersions := Seq("2.13.8")
  )
