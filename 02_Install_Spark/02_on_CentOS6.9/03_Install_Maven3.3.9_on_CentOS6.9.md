# Add repository
```{bash}
[root@febc1daa88f8 yum.repos.d]# pwd
/etc/yum.repos.d

[root@febc1daa88f8 yum.repos.d]# wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo

[root@febc1daa88f8 yum.repos.d]# ll
total 28
-rw-r--r-- 1 root root 1991 Mar 28 10:25 CentOS-Base.repo
-rw-r--r-- 1 root root  647 Mar 28 10:25 CentOS-Debuginfo.repo
-rw-r--r-- 1 root root  630 Mar 28 10:25 CentOS-Media.repo
-rw-r--r-- 1 root root 7989 Mar 28 10:25 CentOS-Vault.repo
-rw-r--r-- 1 root root  289 Mar 28 10:25 CentOS-fasttrack.repo
-rw-r--r-- 1 root root  445 May 16  2016 epel-apache-maven.repo
```

# Install and Configure maven by yum
```{bash}
[root@febc1daa88f8 yum.repos.d]# yum install apache-maven

[root@febc1daa88f8 apache-maven]# pwd
/usr/share/apache-maven

[root@febc1daa88f8 apache-maven]# ll
total 12
drwxr-xr-x 2 root root 4096 May 17 16:09 bin
drwxr-xr-x 2 root root 4096 May 17 16:09 boot
lrwxrwxrwx 1 root root   10 May 17 16:09 conf -> /etc/maven
drwxr-xr-x 3 root root 4096 May 17 16:09 lib

[root@febc1daa88f8 apache-maven]# vi ~/.bash_profile 
...
# JDK8
export JAVA_HOME=/opt/jdk1.8.0_121
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=$CLASSPATH:"."

# Maven
export M2_HOME=/usr/share/apache-maven
export PATH=$PATH:$M2_HOME/bin

[root@febc1daa88f8 apache-maven]# source ~/.bash_profile 

[root@febc1daa88f8 apache-maven]# mvn --version
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/share/apache-maven
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: /opt/jdk1.8.0_121/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "4.4.0-31-generic", arch: "amd64", family: "unix"
```
