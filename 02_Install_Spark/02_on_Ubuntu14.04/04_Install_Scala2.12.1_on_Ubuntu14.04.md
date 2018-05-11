# reference
```{bash}
https://www.scala-lang.org/files/archive/
```

# Install Scala2.12.1 on Ubuntu14.04
```{bash}
root@f242ad934e35:/# cd home

root@f242ad934e35:/home# apt-get install wget

root@f242ad934e35:/home# wget https://www.scala-lang.org/files/archive/scala-2.12.1.deb

root@f242ad934e35:/home# dpkg -i scala-2.12.1.deb 

root@f242ad934e35:/home# scala -version
Scala code runner version 2.12.1 -- Copyright 2002-2016, LAMP/EPFL and Lightbend, Inc.
```

# docker commit this container
```{bash}
root@db38f6a3d4b4:/home# exit
exit

rwoo@rwoo-A610:~$ docker commit ubuntu14.04 ubuntu:14.04_3_Scala2.12.1
sha256:9fbad05e76b826d65794ad2c82b179a78d0b9a6d7b0ddb3b47699fa2f8f1b210

rwoo@rwoo-A610:~$ docker rm ubuntu14.04 
ubuntu14.04

rwoo@rwoo-A610:~$ docker rmi ubuntu:14.04_2_Maven3 
Untagged: ubuntu:14.04_2_Maven3

rwoo@rwoo-A610:~$ docker run -it -e JAVA_HOME=/usr/lib/jvm/java-8-oracle --name ubuntu14.04 ubuntu:14.04_3_Scala2.12.1 

root@4d2f4a52b3db:/# scala -version
Scala code runner version 2.12.1 -- Copyright 2002-2016, LAMP/EPFL and Lightbend, Inc.
```
