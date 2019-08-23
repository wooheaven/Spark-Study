# Install SBT0.13.13 on Ubuntu14.04
```{bash}
root@4d2f4a52b3db:/# echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list

root@4d2f4a52b3db:/# apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823

root@4d2f4a52b3db:/# apt-get install apt-transport-https ca-certificates

root@4d2f4a52b3db:/# apt-get update

root@4d2f4a52b3db:/# apt-get install sbt

root@4d2f4a52b3db:/# dpkg -l sbt

root@4d2f4a52b3db:/# sbt about
WARN: No sbt.version set in project/build.properties, base directory: /
[warn] Executing in batch mode.
[warn]   For better performance, hit [ENTER] to switch to interactive mode, or
[warn]   consider launching sbt without any commands, or explicitly passing 'shell'
[info] Set current project to root (in build file:/)
[info] This is sbt 0.13.15
[info] The current project is {file:/}root 0.1-SNAPSHOT
[info] The current project is built against Scala 2.10.6
[info] Available Plugins: sbt.plugins.IvyPlugin, sbt.plugins.JvmPlugin, sbt.plugins.CorePlugin, sbt.plugins.JUnitXmlReportPlugin, sbt.plugins.Giter8TemplatePlugin
[info] sbt, sbt plugins, and build definitions are using Scala 2.10.6
```

# docker commit this container
```{bash}
root@4d2f4a52b3db:/# exit
exit

rwoo@rwoo-A610:~$ docker commit ubuntu14.04 ubuntu:14.04_4_SBT0.13.15
sha256:8e92c2553b8436bb25a826886efe68901d75926bce207084f4e28fed98a45a9d

rwoo@rwoo-A610:~$ docker rm ubuntu14.04 
ubuntu14.04

rwoo@rwoo-A610:~$ docker rmi ubuntu:14.04_3_Scala2.12.1 
Untagged: ubuntu:14.04_3_Scala2.12.1

rwoo@rwoo-A610:~$ docker run -it -e JAVA_HOME=/usr/lib/jvm/java-8-oracle --name ubuntu14.04 ubuntu:14.04_4_SBT0.13.15 

root@6d0df15b1122:/# sbt about
WARN: No sbt.version set in project/build.properties, base directory: /
[warn] Executing in batch mode.
[warn]   For better performance, hit [ENTER] to switch to interactive mode, or
[warn]   consider launching sbt without any commands, or explicitly passing 'shell'
[info] Set current project to root (in build file:/)
[info] This is sbt 0.13.15
[info] The current project is {file:/}root 0.1-SNAPSHOT
[info] The current project is built against Scala 2.10.6
[info] Available Plugins: sbt.plugins.IvyPlugin, sbt.plugins.JvmPlugin, sbt.plugins.CorePlugin, sbt.plugins.JUnitXmlReportPlugin, sbt.plugins.Giter8TemplatePlugin
[info] sbt, sbt plugins, and build definitions are using Scala 2.10.6
```
