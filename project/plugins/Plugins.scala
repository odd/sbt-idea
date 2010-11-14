/**
 * Copyright (C) 2010, Mikko Peltonen
 * Licensed under the new BSD License.
 * See the LICENSE file for details.
 */

import sbt._
import java.net.URL

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val repo = "GH-pages repo" at "http://mpeltonen.github.com/maven/"
  //val idea = "com.github.mpeltonen" % "sbt-idea-plugin" % "0.1-SNAPSHOT"
  val scripted = "org.scala-tools.sbt" % "scripted" % "0.7.4"
  val snuggletex_repo = "snuggletex_repo" at "http://www2.ph.ed.ac.uk/maven2"
  val t_repo = "t_repo" at "http://tristanhunt.com:8081/content/groups/public/"
  val posterous = "net.databinder" % "posterous-sbt" % "0.1.6"
  val technically = Resolver.url("technically.us", new URL("http://databinder.net/repo/"))(Resolver.ivyStylePatterns)
}
