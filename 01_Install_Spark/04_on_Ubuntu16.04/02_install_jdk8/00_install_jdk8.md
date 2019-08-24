```
$ cat Dockerfile 
FROM ubuntu:16.04_1st_ssh

RUN mkdir /usr/lib/jvm
ADD jdk-8u221-linux-x64.tar.gz /usr/lib/jvm
RUN ls -als /usr/lib/jvm

RUN echo "" >> ~/.bashrc && \
    echo "# JAVA" >> ~/.bashrc && \
    echo "JAVA_HOME=/usr/lib/jvm/jdk1.8.0_221" >> ~/.bashrc && \
    echo "PATH=\$PATH:\$JAVA_HOME/bin" >> ~/.bashrc && \
    cat -n ~/.bashrc | tail -3

$ cat 01_docker_build.sh 
docker build --rm -t ubuntu:16.04_2nd_jdk8 . 

$ cat 02_docker_run.sh 
docker run -it --name spark ubuntu:16.04_2nd_jdk8

$ ./01_docker_build.sh 
$ ./02_docker_run.sh

 * Starting OpenBSD Secure Shell server sshd                             [ OK ]
root@139f7e8400c0:/# which java
/usr/lib/jvm/jdk1.8.0_221/bin/java

root@139f7e8400c0:/# java -version
java version "1.8.0_221"
Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
```
