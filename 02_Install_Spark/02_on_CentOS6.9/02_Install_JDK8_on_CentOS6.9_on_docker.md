# Install JDK8 on CentOS6.9 
```{bash}
# wget
[root@febc1daa88f8 /]# yum install wget
Loaded plugins: fastestmirror, ovl
Setting up Install Process
base                                                                                                                                                                                  | 3.7 kB     00:00     
base/primary_db                                                                                                                                                                       | 4.7 MB     00:37     
extras                                                                                                                                                                                | 3.4 kB     00:00     
extras/primary_db                                                                                                                                                                     |  37 kB     00:00     
updates                                                                                                                                                                               | 3.4 kB     00:00     
updates/primary_db                                                                                                                                                                    | 821 kB     00:00     
Resolving Dependencies
--> Running transaction check
---> Package wget.x86_64 0:1.12-10.el6 will be installed
--> Finished Dependency Resolution

Dependencies Resolved

=============================================================================================================================================================================================
 Package                                   Arch                                        Version                                           Repository                                Size
=============================================================================================================================================================================================
Installing:
 wget                                      x86_64                                      1.12-10.el6                                       base                                      484 k

Transaction Summary
=============================================================================================================================================================================================
Install       1 Package(s)

Total download size: 484 k
Installed size: 1.8 M
Is this ok [y/N]: y
Downloading Packages:
wget-1.12-10.el6.x86_64.rpm                                                                                                                                                | 484 kB     00:03     
warning: rpmts_HdrFromFdno: Header V3 RSA/SHA1 Signature, key ID c105b9de: NOKEY
Retrieving key from file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
Importing GPG key 0xC105B9DE:
 Userid : CentOS-6 Key (CentOS 6 Official Signing Key) <centos-6-key@centos.org>
 Package: centos-release-6-9.el6.12.3.x86_64 (@CentOS/6.9)
 From   : /etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
Is this ok [y/N]: y
Running rpm_check_debug
Running Transaction Test
Transaction Test Succeeded
Running Transaction
  Installing : wget-1.12-10.el6.x86_64                                                                                                                                                    1/1 
install-info: No such file or directory for /usr/share/info/wget.info.gz
  Verifying  : wget-1.12-10.el6.x86_64                                                                                                                                                    1/1 

Installed:
  wget.x86_64 0:1.12-10.el6                                                                                                                                                                                  

Complete!

# Download jdk8 by wget
[root@febc1daa88f8 opt]# wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz"
--2017-05-14 16:21:29--  http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz
Resolving download.oracle.com... 23.76.153.42, 23.76.153.58
Connecting to download.oracle.com|23.76.153.42|:80... connected.
HTTP request sent, awaiting response... 302 Moved Temporarily
Location: https://edelivery.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz [following]
--2017-05-14 16:21:29--  https://edelivery.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz
Resolving edelivery.oracle.com... 104.74.249.60, 2600:1417:e:28e::2d3e, 2600:1417:e:28b::2d3e
Connecting to edelivery.oracle.com|104.74.249.60|:443... connected.
HTTP request sent, awaiting response... 302 Moved Temporarily
Location: http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz?AuthParam=1494779010_db45c7686f0adb6c5caf3f9dd8781fdd [following]
--2017-05-14 16:21:30--  http://download.oracle.com/otn-pub/java/jdk/8u121-b13/e9e7ea248e2c4826b92b3f075a80e441/jdk-8u121-linux-x64.tar.gz?AuthParam=1494779010_db45c7686f0adb6c5caf3f9dd8781fdd
Connecting to download.oracle.com|23.76.153.42|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 183246769 (175M) [application/x-gzip]
Saving to: `jdk-8u121-linux-x64.tar.gz'

100%[===================================================================================================================================================================>] 183,246,769 9.79M/s   in 18s     

2017-05-14 16:21:48 (9.98 MB/s) - `jdk-8u121-linux-x64.tar.gz' saved [183246769/183246769]

# Uncompress
[root@febc1daa88f8 opt]# tar xzf jdk-8u121-linux-x64.tar.gz 

[root@febc1daa88f8 opt]# ll
total 178960
-rw-r--r-- 1 root root 183246769 Dec 14 19:42 jdk-8u121-linux-x64.tar.gz
drwxr-xr-x 8 uucp  143      4096 Dec 13 00:50 jdk1.8.0_121

# alternatives install java,jar,javac,javaws
[root@febc1daa88f8 opt]# alternatives --install /usr/bin/java java /opt/jdk1.8.0_121/bin/java 1
[root@febc1daa88f8 opt]# alternatives --install /usr/bin/java jar /opt/jdk1.8.0_121/bin/jar 1
[root@febc1daa88f8 opt]# alternatives --install /usr/bin/java javac /opt/jdk1.8.0_121/bin/javac 1
[root@febc1daa88f8 opt]# alternatives --install /usr/bin/java javawd /opt/jdk1.8.0_121/bin/javaws 1

[root@febc1daa88f8 opt]# alternatives --set java /opt/jdk1.8.0_121/bin/java
[root@febc1daa88f8 opt]# alternatives --set jar /opt/jdk1.8.0_121/bin/jar
[root@febc1daa88f8 opt]# alternatives --set javac /opt/jdk1.8.0_121/bin/javac
[root@febc1daa88f8 opt]# alternatives --set javaws /opt/jdk1.8.0_121/bin/javaws

[root@febc1daa88f8 opt]# which java
/usr/bin/java
[root@febc1daa88f8 opt]# which jar
/usr/bin/jar
[root@febc1daa88f8 opt]# which javac
/usr/bin/javac
[root@febc1daa88f8 opt]# which javaws
/usr/bin/javaws

[root@febc1daa88f8 opt]# ll /usr/bin/java
lrwxrwxrwx 1 root root 22 May 14 16:55 /usr/bin/java -> /etc/alternatives/java
[root@febc1daa88f8 opt]# ll /usr/bin/jar 
lrwxrwxrwx 1 root root 21 May 14 16:55 /usr/bin/jar -> /etc/alternatives/jar
[root@febc1daa88f8 opt]# ll /usr/bin/javac
lrwxrwxrwx 1 root root 23 May 14 16:55 /usr/bin/javac -> /etc/alternatives/javac
[root@febc1daa88f8 opt]# ll /usr/bin/javaws
lrwxrwxrwx 1 root root 24 May 14 16:56 /usr/bin/javaws -> /etc/alternatives/javaws

[root@febc1daa88f8 opt]# ll /etc/alternatives/java
lrwxrwxrwx 1 root root 26 May 14 16:55 /etc/alternatives/java -> /opt/jdk1.8.0_121/bin/java
[root@febc1daa88f8 opt]# ll /etc/alternatives/jar 
lrwxrwxrwx 1 root root 25 May 14 16:55 /etc/alternatives/jar -> /opt/jdk1.8.0_121/bin/jar
[root@febc1daa88f8 opt]# ll /etc/alternatives/javac
lrwxrwxrwx 1 root root 27 May 14 16:55 /etc/alternatives/javac -> /opt/jdk1.8.0_121/bin/javac
[root@febc1daa88f8 opt]# ll /etc/alternatives/javaws
lrwxrwxrwx 1 root root 28 May 14 16:56 /etc/alternatives/javaws -> /opt/jdk1.8.0_121/bin/javaws

[root@febc1daa88f8 opt]# java -version
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)

[root@febc1daa88f8 opt]# javac -version
javac 1.8.0_121
```

# Docker commit
```{bash}
$ docker images 
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
centos                  6.9                 573de66f263e        5 weeks ago         195 MB

$ docker ps -a
CONTAINER ID        IMAGE                     COMMAND                  CREATED             STATUS                       PORTS                                                           NAMES
febc1daa88f8        centos:6.9                "/bin/bash"              2 hours ago         Exited (127) 5 seconds ago                                                                   centos6.9

$ docker commit -m "install jdk8" centos6.9 centos:6.9_1_jdk8
sha256:f2da1952bc42de557defacf9e16c4648fa9573a9fb40d5557d5e97505769de35

$ docker images 
REPOSITORY              TAG                 IMAGE ID            CREATED              SIZE
centos                  6.9_1_jdk8          f2da1952bc42        4 seconds ago        798 MB
centos                  6.9                 573de66f263e        5 weeks ago         195 MB
```
