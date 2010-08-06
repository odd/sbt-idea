import sbt._
class IdeaPluginProject(info: ProjectInfo) extends PluginProject(info) {
  override def managedStyle = ManagedStyle.Maven
  val publishTo = Resolver.file("maven-local", Path.userHome / ".m2" / "repository" asFile)
  //lazy val publishTo = Resolver.file("GitHub Pages", new java.io.File("../mpeltonen.github.com/maven/")) 
  val sourceArtifact = Artifact(artifactID, "source", "jar", Some("source"), Nil, None)
  val docsArtifact = Artifact(artifactID, "docs", "jar", Some("docs"), Nil, None)
}
