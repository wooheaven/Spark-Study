# Install Scala2.12.1 on CentOS6.9
```{bash}
[root@febc1daa88f8 /]# cd home/

[root@febc1daa88f8 home]# wget https://downloads.lightbend.com/scala/2.12.1/scala-2.12.1.rpm

[root@febc1daa88f8 home]# rpm -ivh scala-2.12.1.rpm 

[root@febc1daa88f8 home]# rpm -qa | grep scala
scala-2.12.1-1.noarch

[root@febc1daa88f8 home]# rpm -qi scala
Name        : scala                        Relocations: (not relocatable)
Version     : 2.12.1                            Vendor: lightbend
Release     : 1                             Build Date: Mon Dec  5 11:16:19 2016
Install Date: Sun May 21 15:17:28 2017         Build Host: ip-172-31-15-209.us-west-1.compute.internal
Group       : Development/Languages         Source RPM: scala-2.12.1-1.src.rpm
Size        : 631409570                        License: BSD
Signature   : (none)
URL         : http://github.com/scala/scala
Summary     : Scala Programming Language Distribution
Description :
Have the best of both worlds. Construct elegant class hierarchies for maximum code reuse and extensibility, implement their behavior using higher-order functions. Or anything in-between.

[root@febc1daa88f8 ~]# scala -version
Scala code runner version 2.12.1 -- Copyright 2002-2016, LAMP/EPFL and Lightbend, Inc.
```
