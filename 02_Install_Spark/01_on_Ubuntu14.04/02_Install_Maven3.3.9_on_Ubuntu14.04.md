# Install Maven3.3.9 on Ubuntu14.04
```{bash}
$ mvn -v
The program 'mvn' can be found in the following packages:
 * maven
 * maven2
Try: sudo apt-get install <selected package>

$ sudo apt-get purge maven maven2 maven3
$ sudo add-apt-repository ppa:andrei-pozolotin/maven3
$ sudo apt-get update
$ sudo apt-get install maven3
$ sudo dpkg -l maven3
$ mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T01:41:47+09:00)
Maven home: /usr/share/maven3
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.2.0-27-generic", arch: "amd64", family: "unix"
```
