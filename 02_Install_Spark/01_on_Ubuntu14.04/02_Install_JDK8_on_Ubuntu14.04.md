# apt update
```{bash}
root@cdb7333e2dec:/# apt install wget
Reading package lists... Done
Building dependency tree       
Reading state information... Done
E: Unable to locate package wget

root@cdb7333e2dec:/# apt-get update
Ign http://archive.ubuntu.com trusty InRelease       
Get:1 http://archive.ubuntu.com trusty-updates InRelease [65.9 kB]
Get:2 http://archive.ubuntu.com trusty-security InRelease [65.9 kB]
Get:3 http://archive.ubuntu.com trusty Release.gpg [933 B]
Get:4 http://archive.ubuntu.com trusty-updates/main Sources [492 kB]
Get:5 http://archive.ubuntu.com trusty-updates/restricted Sources [6467 B]
Get:6 http://archive.ubuntu.com trusty-updates/universe Sources [226 kB]
Get:7 http://archive.ubuntu.com trusty-updates/main amd64 Packages [1227 kB]
Get:8 http://archive.ubuntu.com trusty-updates/restricted amd64 Packages [21.2 kB]
Get:9 http://archive.ubuntu.com trusty-updates/universe amd64 Packages [524 kB]
Get:10 http://archive.ubuntu.com trusty Release [58.5 kB]                      
Get:11 http://archive.ubuntu.com trusty-security/main Sources [167 kB]         
Get:12 http://archive.ubuntu.com trusty-security/restricted Sources [5066 B]   
Get:13 http://archive.ubuntu.com trusty-security/universe Sources [62.6 kB]    
Get:14 http://archive.ubuntu.com trusty-security/main amd64 Packages [761 kB]  
Get:15 http://archive.ubuntu.com trusty-security/restricted amd64 Packages [17.8 kB]
Get:16 http://archive.ubuntu.com trusty-security/universe amd64 Packages [203 kB]
Get:17 http://archive.ubuntu.com trusty/main Sources [1335 kB]                 
Get:18 http://archive.ubuntu.com trusty/restricted Sources [5335 B]            
Get:19 http://archive.ubuntu.com trusty/universe Sources [7926 kB]             
Get:20 http://archive.ubuntu.com trusty/main amd64 Packages [1743 kB]          
Get:21 http://archive.ubuntu.com trusty/restricted amd64 Packages [16.0 kB]    
Get:22 http://archive.ubuntu.com trusty/universe amd64 Packages [7589 kB]      
Fetched 22.5 MB in 36s (622 kB/s)                                              
Reading package lists... Done
```

# apt install wget
```{bash}
root@cdb7333e2dec:/# apt-get install wget
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following extra packages will be installed:
  ca-certificates libidn11 openssl
The following NEW packages will be installed:
  ca-certificates libidn11 openssl wget
0 upgraded, 4 newly installed, 0 to remove and 3 not upgraded.
Need to get 1044 kB of archives.
After this operation, 2415 kB of additional disk space will be used.
Do you want to continue? [Y/n] Y
Get:1 http://archive.ubuntu.com/ubuntu/ trusty-updates/main libidn11 amd64 1.28-1ubuntu2.1 [94.4 kB]
Get:2 http://archive.ubuntu.com/ubuntu/ trusty-updates/main openssl amd64 1.0.1f-1ubuntu2.22 [489 kB]
Get:3 http://archive.ubuntu.com/ubuntu/ trusty-updates/main ca-certificates all 20160104ubuntu0.14.04.1 [190 kB]
Get:4 http://archive.ubuntu.com/ubuntu/ trusty-updates/main wget amd64 1.15-1ubuntu1.14.04.2 [271 kB]
Fetched 1044 kB in 5s (176 kB/s)
Preconfiguring packages ...
Selecting previously unselected package libidn11:amd64.
(Reading database ... 11569 files and directories currently installed.)
Preparing to unpack .../libidn11_1.28-1ubuntu2.1_amd64.deb ...
Unpacking libidn11:amd64 (1.28-1ubuntu2.1) ...
Selecting previously unselected package openssl.
Preparing to unpack .../openssl_1.0.1f-1ubuntu2.22_amd64.deb ...
Unpacking openssl (1.0.1f-1ubuntu2.22) ...
Selecting previously unselected package ca-certificates.
Preparing to unpack .../ca-certificates_20160104ubuntu0.14.04.1_all.deb ...
Unpacking ca-certificates (20160104ubuntu0.14.04.1) ...
Selecting previously unselected package wget.
Preparing to unpack .../wget_1.15-1ubuntu1.14.04.2_amd64.deb ...
Unpacking wget (1.15-1ubuntu1.14.04.2) ...
Setting up libidn11:amd64 (1.28-1ubuntu2.1) ...
Setting up openssl (1.0.1f-1ubuntu2.22) ...
Setting up ca-certificates (20160104ubuntu0.14.04.1) ...
Setting up wget (1.15-1ubuntu1.14.04.2) ...
Processing triggers for libc-bin (2.19-0ubuntu6.11) ...
Processing triggers for ca-certificates (20160104ubuntu0.14.04.1) ...
Updating certificates in /etc/ssl/certs... 173 added, 0 removed; done.
Running hooks in /etc/ca-certificates/update.d....done.
```

# Download JDK8
```{bash}
root@cdb7333e2dec:/opt# tar zxf jdk-8u121-linux-x64.tar.gz 

root@cdb7333e2dec:/opt# ll
total 178968
drwxr-xr-x  3 root root      4096 May 16 00:11 ./
drwxr-xr-x 40 root root      4096 May 16 00:10 ../
-rw-r--r--  1 root root 183246769 Dec 14 19:42 jdk-8u121-linux-x64.tar.gz
drwxr-xr-x  8 uucp  143      4096 Dec 13 00:50 jdk1.8.0_121/

root@cdb7333e2dec:/opt# chown -R root:root ./*

root@cdb7333e2dec:/opt# ll
total 178968
drwxr-xr-x  3 root root      4096 May 16 00:11 ./
drwxr-xr-x 40 root root      4096 May 16 00:10 ../
-rw-r--r--  1 root root 183246769 Dec 14 19:42 jdk-8u121-linux-x64.tar.gz
drwxr-xr-x  8 root root      4096 Dec 13 00:50 jdk1.8.0_121/
```

# alternatives install java, jar, javac
```{bash}
root@cdb7333e2dec:/opt# update-alternatives --install /usr/bin/java java /opt/jdk1.8.0_121/bin/java 1
update-alternatives: using /opt/jdk1.8.0_121/bin/java to provide /usr/bin/java (java) in auto mode
root@cdb7333e2dec:/opt# update-alternatives --install /usr/bin/jar jar /opt/jdk1.8.0_121/bin/jar 1
update-alternatives: using /opt/jdk1.8.0_121/bin/jar to provide /usr/bin/jar (jar) in auto mode
root@cdb7333e2dec:/opt# update-alternatives --install /usr/bin/javac javac /opt/jdk1.8.0_121/bin/javac 1
update-alternatives: using /opt/jdk1.8.0_121/bin/javac to provide /usr/bin/javac (javac) in auto mode

root@cdb7333e2dec:/# update-alternatives --config java
There is only one alternative in link group java (providing /usr/bin/java): /opt/jdk1.8.0_121/bin/java
Nothing to configure.
root@cdb7333e2dec:/# update-alternatives --config jar 
There is only one alternative in link group jar (providing /usr/bin/jar): /opt/jdk1.8.0_121/bin/jar
Nothing to configure.
root@cdb7333e2dec:/# update-alternatives --config javac
There is only one alternative in link group javac (providing /usr/bin/javac): /opt/jdk1.8.0_121/bin/javac
Nothing to configure.

root@cdb7333e2dec:/opt# update-alternatives --display java
java - auto mode
  link currently points to /opt/jdk1.8.0_121/bin/java
/opt/jdk1.8.0_121/bin/java - priority 1
Current 'best' version is '/opt/jdk1.8.0_121/bin/java'.
root@cdb7333e2dec:/opt# update-alternatives --display jar 
jar - auto mode
  link currently points to /opt/jdk1.8.0_121/bin/jar
/opt/jdk1.8.0_121/bin/jar - priority 1
Current 'best' version is '/opt/jdk1.8.0_121/bin/jar'.
root@cdb7333e2dec:/opt# update-alternatives --display javac
javac - auto mode
  link currently points to /opt/jdk1.8.0_121/bin/javac
/opt/jdk1.8.0_121/bin/javac - priority 1
Current 'best' version is '/opt/jdk1.8.0_121/bin/javac'.

root@cdb7333e2dec:/opt# which java
/usr/bin/java
root@cdb7333e2dec:/opt# which jar 
/usr/bin/jar
root@cdb7333e2dec:/opt# which javac
/usr/bin/javac

root@cdb7333e2dec:/opt# ll /usr/bin/java
lrwxrwxrwx 1 root root 22 May 16 00:16 /usr/bin/java -> /etc/alternatives/java*
root@cdb7333e2dec:/opt# ll /usr/bin/jar 
lrwxrwxrwx 1 root root 21 May 16 00:16 /usr/bin/jar -> /etc/alternatives/jar*
root@cdb7333e2dec:/opt# ll /usr/bin/javac
lrwxrwxrwx 1 root root 23 May 16 00:16 /usr/bin/javac -> /etc/alternatives/javac*

root@cdb7333e2dec:/opt# ll /etc/alternatives/ | grep opt
lrwxrwxrwx  1 root root   25 May 16 00:16 jar -> /opt/jdk1.8.0_121/bin/jar*
lrwxrwxrwx  1 root root   26 May 16 00:16 java -> /opt/jdk1.8.0_121/bin/java*
lrwxrwxrwx  1 root root   27 May 16 00:16 javac -> /opt/jdk1.8.0_121/bin/javac*
lrwxrwxrwx  1 root root   28 May 16 00:16 javaws -> /opt/jdk1.8.0_121/bin/javaws*

root@cdb7333e2dec:/opt# java -version
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)

root@cdb7333e2dec:/opt# javac -version
javac 1.8.0_121
```

# apt-get install vim
```{bash}
root@cdb7333e2dec:/opt/jdk1.8.0_121# apt-get install vim
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following extra packages will be installed:
  libgpm2 libpython2.7 libpython2.7-minimal libpython2.7-stdlib vim-runtime
Suggested packages:
  gpm ctags vim-doc vim-scripts
The following NEW packages will be installed:
  libgpm2 libpython2.7 libpython2.7-minimal libpython2.7-stdlib vim
  vim-runtime
0 upgraded, 6 newly installed, 0 to remove and 3 not upgraded.
Need to get 9074 kB of archives.
After this operation, 42.9 MB of additional disk space will be used.
Do you want to continue? [Y/n] Y
Get:1 http://archive.ubuntu.com/ubuntu/ trusty/main libgpm2 amd64 1.20.4-6.1 [16.5 kB]
Get:2 http://archive.ubuntu.com/ubuntu/ trusty-updates/main libpython2.7-minimal amd64 2.7.6-8ubuntu0.3 [307 kB]
Get:3 http://archive.ubuntu.com/ubuntu/ trusty-updates/main libpython2.7-stdlib amd64 2.7.6-8ubuntu0.3 [1873 kB]
Get:4 http://archive.ubuntu.com/ubuntu/ trusty-updates/main libpython2.7 amd64 2.7.6-8ubuntu0.3 [1039 kB]
Get:5 http://archive.ubuntu.com/ubuntu/ trusty-updates/main vim-runtime all 2:7.4.052-1ubuntu3.1 [4882 kB]
Get:6 http://archive.ubuntu.com/ubuntu/ trusty-updates/main vim amd64 2:7.4.052-1ubuntu3.1 [955 kB]
Fetched 9074 kB in 15s (569 kB/s)                                              
Selecting previously unselected package libgpm2:amd64.
(Reading database ... 11883 files and directories currently installed.)
Preparing to unpack .../libgpm2_1.20.4-6.1_amd64.deb ...
Unpacking libgpm2:amd64 (1.20.4-6.1) ...
Selecting previously unselected package libpython2.7-minimal:amd64.
Preparing to unpack .../libpython2.7-minimal_2.7.6-8ubuntu0.3_amd64.deb ...
Unpacking libpython2.7-minimal:amd64 (2.7.6-8ubuntu0.3) ...
Selecting previously unselected package libpython2.7-stdlib:amd64.
Preparing to unpack .../libpython2.7-stdlib_2.7.6-8ubuntu0.3_amd64.deb ...
Unpacking libpython2.7-stdlib:amd64 (2.7.6-8ubuntu0.3) ...
Selecting previously unselected package libpython2.7:amd64.
Preparing to unpack .../libpython2.7_2.7.6-8ubuntu0.3_amd64.deb ...
Unpacking libpython2.7:amd64 (2.7.6-8ubuntu0.3) ...
Selecting previously unselected package vim-runtime.
Preparing to unpack .../vim-runtime_2%3a7.4.052-1ubuntu3.1_all.deb ...
Adding 'diversion of /usr/share/vim/vim74/doc/help.txt to /usr/share/vim/vim74/doc/help.txt.vim-tiny by vim-runtime'
Adding 'diversion of /usr/share/vim/vim74/doc/tags to /usr/share/vim/vim74/doc/tags.vim-tiny by vim-runtime'
Unpacking vim-runtime (2:7.4.052-1ubuntu3.1) ...
Selecting previously unselected package vim.
Preparing to unpack .../vim_2%3a7.4.052-1ubuntu3.1_amd64.deb ...
Unpacking vim (2:7.4.052-1ubuntu3.1) ...
Setting up libgpm2:amd64 (1.20.4-6.1) ...
Setting up libpython2.7-minimal:amd64 (2.7.6-8ubuntu0.3) ...
Setting up libpython2.7-stdlib:amd64 (2.7.6-8ubuntu0.3) ...
Setting up libpython2.7:amd64 (2.7.6-8ubuntu0.3) ...
Setting up vim-runtime (2:7.4.052-1ubuntu3.1) ...
Processing /usr/share/vim/addons/doc
Setting up vim (2:7.4.052-1ubuntu3.1) ...
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/vim (vim) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/vimdiff (vimdiff) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/rvim (rvim) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/rview (rview) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/vi (vi) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/view (view) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/ex (ex) in auto mode
update-alternatives: using /usr/bin/vim.basic to provide /usr/bin/editor (editor) in auto mode
Processing triggers for libc-bin (2.19-0ubuntu6.11) ...
```

# JAVA_HOME 
```{bash}
root@cdb7333e2dec:/# vi ~/.profile
...
# JDK8
JAVA_HOME=/opt/jdk1.8.0_121

root@cdb7333e2dec:/# source ~/.profile 

root@cdb7333e2dec:/# echo $JAVA_HOME 
/opt/jdk1.8.0_121
```
