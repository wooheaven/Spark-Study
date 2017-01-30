# Install JDK8 on Ubuntu14.04
```{bash}
$ sudo apt-add-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
$ sudo dpkg -l oracle-java8-installer
$ sudo update-alternatives --config java
$ sudo update-alternatives --config javac

$ vi ~/.profile
...
JAVA_HOME=/usr/lib/jvm/java-8-oracle/
...

$ source ~/.profile

$ java -version
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)

$ javac -version
javac 1.8.0_121

$ echo $JAVA_HOME
/usr/lib/jvm/java-8-oracle
```
