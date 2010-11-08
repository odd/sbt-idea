/**
 * Copyright (C) 2010, Mikko Peltonen, Jon-Anders Teigen
 * Licensed under the new BSD License.
 * See the LICENSE file for details.
 */

import sbt._

class SbtIdeaProject(info:ProjectInfo) extends ParentProject(info) {
  override def managedStyle = ManagedStyle.Maven
  lazy val publishTo = Resolver.file("GitHub Pages", new java.io.File("../mpeltonen.github.com/maven/"))

  lazy val core = project("sbt-idea-core", "sbt-idea-core", new Core(_))
  lazy val plugin = project("sbt-idea-plugin", "sbt-idea-plugin", new PluginProject(_), core)
  lazy val processor = project("sbt-idea-processor", "sbt-idea-processor", new ProcessorProject(_), core)
  lazy val tests = project("sbt-idea-tests", "sbt-idea-tests", new ScriptedTests(_), plugin)
  override def deliverProjectDependencies = super.deliverProjectDependencies.toList - tests.projectID

  class Core(info:ProjectInfo) extends DefaultProject(info) {
    override def unmanagedClasspath = super.unmanagedClasspath +++ info.sbtClasspath
  }

  class ScriptedTests(info: ProjectInfo) extends DefaultProject(info) with test.SbtScripted {
    val commonsIo = "commons-io" % "commons-io" % "1.4" withSources()
    override def scriptedSbt = "0.7.4"
    override def publishAction = task { None }
    override def deliverAction = task { None }
  }
}
