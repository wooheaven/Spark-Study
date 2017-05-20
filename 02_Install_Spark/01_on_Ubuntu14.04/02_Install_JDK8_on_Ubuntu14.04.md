# preInstall before install JDK8 on Ubuntu 14.04
```{bash}
root@f242ad934e35:/# apt-get update

root@f242ad934e35:/# apt-get install vim

root@f242ad934e35:/# apt-get install software-properties-common

root@f242ad934e35:/# apt-get update
```

# Install JDK8 on Ubuntu 14.04
```{bash}
root@f242ad934e35:/# apt-get install oracle-java8-installer

root@f242ad934e35:/# apt-get install oracle-java8-set-default

root@f242ad934e35:/# java -version
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```

# export JAVA_HOME 
```{bash}
root@f242ad934e35:/home# vi ~/.profile 

root@f242ad934e35:/home# tail -2 ~/.profile 
# JDK8
export JAVA_HOME=/usr/lib/jvm/java-8-oracle

root@f242ad934e35:/home# source ~/.profile

root@f242ad934e35:/home# echo $JAVA_HOME 
/usr/lib/jvm/java-8-oracle
```
