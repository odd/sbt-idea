import sbt._

class SbtIdeaProject(info:ProjectInfo) extends ParentProject(info) {
  override def managedStyle = ManagedStyle.Maven
  lazy val publishTo = Resolver.file("GitHub Pages", new java.io.File("../mpeltonen.github.com/maven/"))

  lazy val core = project("sbt-idea-core", "sbt-idea-core", new Core(_))
  lazy val plugin = project("sbt-idea-plugin", "sbt-idea-plugin", new PluginProject(_) with IdeaPlugin, core)
  lazy val processor = project("sbt-idea-processor", "sbt-idea-processor", new ProcessorProject(_) with IdeaPlugin, core)

  class Core(info:ProjectInfo) extends DefaultProject(info) {
    override def unmanagedClasspath = super.unmanagedClasspath +++ info.sbtClasspath
  }
}
