# Install SBT0.13.15 on CentOS6.9
```{bash}
[root@febc1daa88f8 /]# cd /etc/yum.repos.d/

[root@febc1daa88f8 yum.repos.d]# curl https://bintray.com/sbt/rpm/rpm > bintray-sbt-rpm.repo
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
159   159    0   159    0     0    131      0 --:--:--  0:00:01 --:--:--   924

[root@febc1daa88f8 yum.repos.d]# ll
total 32
-rw-r--r-- 1 root root 1991 Mar 28 10:25 CentOS-Base.repo
-rw-r--r-- 1 root root  647 Mar 28 10:25 CentOS-Debuginfo.repo
-rw-r--r-- 1 root root  630 Mar 28 10:25 CentOS-Media.repo
-rw-r--r-- 1 root root 7989 Mar 28 10:25 CentOS-Vault.repo
-rw-r--r-- 1 root root  289 Mar 28 10:25 CentOS-fasttrack.repo
-rw-r--r-- 1 root root  159 May 24 13:06 bintray-sbt-rpm.repo
-rw-r--r-- 1 root root  445 May 16  2016 epel-apache-maven.repo

[root@febc1daa88f8 yum.repos.d]# yum install sbt

[root@febc1daa88f8 /]# sbt about
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
[root@febc1daa88f8 yum.repos.d]# exit
exit

rwoo@rwoo-A610:~$ docker commit centos6.9 centos:6.9_5_sbt0.13.15 
sha256:bcfe6a1aa9e58233f549c53c234e6f6ae3ef8540f7fd4f87c9e4a51ae376b78a

rwoo@rwoo-A610:~$ docker rmi centos:6.9_4_scala 
Untagged: centos:6.9_4_scala
Deleted: sha256:0ff55d2f68d0639447cf4a8317e4c263907a10698d7b59cbfbb9729c9dad733e
Deleted: sha256:329a63b8976eb55d9ef4f33845e6ad0420c8e09d1781c2549594a58c8017254c

rwoo@rwoo-A610:~$ docker start centos6.9 
centos6.9

rwoo@rwoo-A610:~$ docker attach centos6.9 

[root@febc1daa88f8 /]# sbt about
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
