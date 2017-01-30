# Install JDK8 on Ubuntu14.04
```{bash}
sudo apt-add-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo update-alternatives --config java
sudo update-alternatives --config javac

vi ~/.profile
...
JAVA_HOME=/usr/lib/jvm/java-8-oracle/
...

source ~/.profile

echo $JAVA_HOME
```
