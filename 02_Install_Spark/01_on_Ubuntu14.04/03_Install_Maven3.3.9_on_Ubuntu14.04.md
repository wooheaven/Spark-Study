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
