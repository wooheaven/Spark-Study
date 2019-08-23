# preInstall before install JDK8 on Ubuntu 14.04
```{bash}
root@2f20912ae212:/# apt-get update

root@2f20912ae212:/# apt-get install vim

root@2f20912ae212:/# apt-get install software-properties-common

root@2f20912ae212:/# add-apt-repository ppa:webupd8team/java

root@2f20912ae212:/# apt-get update
```

# Install JDK8 on Ubuntu 14.04
```{bash}
root@2f20912ae212:/# apt-get install oracle-java8-installer

root@2f20912ae212:/# apt-get install oracle-java8-set-default

root@2f20912ae212:/# java -version
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```

# docker commit this container and export JAVA_HOME on ubuntu 14.04 docker container
```{bash}
root@2f20912ae212:/# which java
/usr/bin/java

root@2f20912ae212:/# ll /usr/bin/java
lrwxrwxrwx 1 root root 22 May 23 16:52 /usr/bin/java -> /etc/alternatives/java*

root@2f20912ae212:/# ll /etc/alternatives/java
lrwxrwxrwx 1 root root 39 May 23 16:52 /etc/alternatives/java -> /usr/lib/jvm/java-8-oracle/jre/bin/java*

root@2f20912ae212:/# exit
exit

rwoo@rwoo-A610:~$ docker commit ubuntu14.04 ubuntu:14.04_1_JDK8
sha256:c460470ca634b9384c285a84bc8d23709e1a3e68bc54c6cb2b9281fcfcdf7c5a

rwoo@rwoo-A610:~$ docker rm ubuntu14.04 
ubuntu14.04

rwoo@rwoo-A610:~$ docker run -it -e JAVA_HOME=/usr/lib/jvm/java-8-oracle --name ubuntu14.04 ubuntu:14.04_1_JDK8 

root@cd5e1b2fb32a:/# echo $JAVA_HOME
/usr/lib/jvm/java-8-oracle
```
