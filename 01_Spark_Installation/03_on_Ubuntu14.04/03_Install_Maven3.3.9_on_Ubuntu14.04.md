# Remove Maven on Ubuntu 14.04
```{bash}
root@cdb7333e2dec:/# apt-get purge maven maven2 maven3
```

# Install Maven3.3.9 on Ubuntu14.04
```{bash}
root@f242ad934e35:/# add-apt-repository ppa:andrei-pozolotin/maven3

root@f242ad934e35:/# apt-get update

root@f242ad934e35:/# apt-get install maven3

root@f242ad934e35:/# mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/share/maven3
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "4.4.0-31-generic", arch: "amd64", family: "unix"
```

# Docker commit this container
```{bash}
root@cd5e1b2fb32a:/# exit
exit

rwoo@rwoo-A610:~$ docker commit ubuntu14.04 ubuntu:14.04_2_Maven3
sha256:2a8b5d0229c405ce4b4f2d69fa03b9d09613fbb640a270d932eb3ffe90a3f51d

rwoo@rwoo-A610:~$ docker rm ubuntu14.04 
ubuntu14.04

rwoo@rwoo-A610:~$ docker rmi ubuntu:14.04_1_JDK8 
Untagged: ubuntu:14.04_1_JDK8

rwoo@rwoo-A610:~$ docker run -it -e JAVA_HOME=/usr/lib/jvm/java-8-oracle --name ubuntu14.04 ubuntu:14.04_2_Maven3 

root@db38f6a3d4b4:/# mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/share/maven3
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "4.4.0-31-generic", arch: "amd64", family: "unix"
```
