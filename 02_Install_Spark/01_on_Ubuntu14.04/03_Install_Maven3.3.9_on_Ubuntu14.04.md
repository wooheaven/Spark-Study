# Install add-apt-repository
```{bash}
root@cdb7333e2dec:/# apt-get install python-software-properties
root@cdb7333e2dec:/# apt-get install software-properties-common
```

# Install Maven3.3.9 on Ubuntu14.04
```{bash}
root@cdb7333e2dec:/# apt-get purge maven maven2 maven3
root@cdb7333e2dec:/# add-apt-repository ppa:andrei-pozolotin/maven3
root@cdb7333e2dec:/# apt-get update
root@cdb7333e2dec:/# apt-get install maven3

root@cdb7333e2dec:/# sudo dpkg -l maven3
Desired=Unknown/Install/Remove/Purge/Hold
| Status=Not/Inst/Conf-files/Unpacked/halF-conf/Half-inst/trig-aWait/Trig-pend
|/ Err?=(none)/Reinst-required (Status,Err: uppercase=bad)
||/ Name                                          Version                     Architecture                Description
+++-=============================================-===========================-===========================-===============================================================================================
ii  maven3                                        3.3.9-001                   all                         Maven Distro.

root@cdb7333e2dec:/# mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/share/maven3
Java version: 1.7.0_131, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-openjdk-amd64/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "4.4.0-31-generic", arch: "amd64", family: "unix"

root@cdb7333e2dec:/# update-alternatives --config java
There are 2 choices for the alternative java (providing /usr/bin/java).

  Selection    Path                                            Priority   Status
------------------------------------------------------------
* 0            /usr/lib/jvm/java-7-openjdk-amd64/jre/bin/java   1071      auto mode
  1            /opt/jdk1.8.0_121/bin/java                       1         manual mode
  2            /usr/lib/jvm/java-7-openjdk-amd64/jre/bin/java   1071      manual mode

Press enter to keep the current choice[*], or type selection number: 1
update-alternatives: using /opt/jdk1.8.0_121/bin/java to provide /usr/bin/java (java) in manual mode

root@cdb7333e2dec:/# update-alternatives --config jar
There are 2 choices for the alternative jar (providing /usr/bin/jar).

  Selection    Path                                       Priority   Status
------------------------------------------------------------
* 0            /usr/lib/jvm/java-7-openjdk-amd64/bin/jar   1071      auto mode
  1            /opt/jdk1.8.0_121/bin/jar                   1         manual mode
  2            /usr/lib/jvm/java-7-openjdk-amd64/bin/jar   1071      manual mode

Press enter to keep the current choice[*], or type selection number: 1
update-alternatives: using /opt/jdk1.8.0_121/bin/jar to provide /usr/bin/jar (jar) in manual mode

root@cdb7333e2dec:/# update-alternatives --config javac
There are 2 choices for the alternative javac (providing /usr/bin/javac).

  Selection    Path                                         Priority   Status
------------------------------------------------------------
* 0            /usr/lib/jvm/java-7-openjdk-amd64/bin/javac   1071      auto mode
  1            /opt/jdk1.8.0_121/bin/javac                   1         manual mode
  2            /usr/lib/jvm/java-7-openjdk-amd64/bin/javac   1071      manual mode

Press enter to keep the current choice[*], or type selection number: 1
update-alternatives: using /opt/jdk1.8.0_121/bin/javac to provide /usr/bin/javac (javac) in manual mode

root@cdb7333e2dec:/# mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/share/maven3
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: /opt/jdk1.8.0_121/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "4.4.0-31-generic", arch: "amd64", family: "unix"
```
