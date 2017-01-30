# Install SBT0.13.13 on Ubuntu14.04
```{bash}
$ echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
$ sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
$ sudo apt-get update
$ sudo apt-get install sbt
$ sudo dpkg -l sbt
$ sbt about
[info] Set current project to root-01_on_ubuntu14-04 (in build file:/home/rwoo/02_WorkSpace/Spark-Java-Study/01_Install_Spark/01_on_Ubuntu14.04/)
[info] This is sbt 0.13.13
[info] The current project is {file:/home/rwoo/02_WorkSpace/Spark-Java-Study/01_Install_Spark/01_on_Ubuntu14.04/}root-01_on_ubuntu14-04 0.1-SNAPSHOT
[info] The current project is built against Scala 2.10.6
[info] Available Plugins: sbt.plugins.IvyPlugin, sbt.plugins.JvmPlugin, sbt.plugins.CorePlugin, sbt.plugins.JUnitXmlReportPlugin, sbt.plugins.Giter8TemplatePlugin
[info] sbt, sbt plugins, and build definitions are using Scala 2.10.6
```
