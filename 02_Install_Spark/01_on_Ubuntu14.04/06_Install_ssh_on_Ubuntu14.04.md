# Install ssh on Ubuntu14.04
```{bash}
root@6d0df15b1122:/# sudo apt-get install openssh-server

root@6d0df15b1122:/# sudo dpkg -l openssh-server

root@6d0df15b1122:/# sudo vi /etc/ssh/sshd_config
...
51 # Change to no to disable tunnelled clear text passwords
52 #PasswordAuthentication yes
53 PasswordAuthentication no
...

root@6d0df15b1122:/# sudo service ssh restart

root@6d0df15b1122:/# ssh-keygen -t rsa

root@6d0df15b1122:/# cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys

root@6d0df15b1122:/# chmod 600 .ssh/authorized_keys

root@6d0df15b1122:/# ll ~/.ssh

root@6d0df15b1122:/# ssh localhost
Welcome to Ubuntu 14.04 LTS (GNU/Linux 4.4.0-71-generic x86_64)

 * Documentation:  https://help.ubuntu.com/

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

root@6d0df15b1122:~# ps
  PID TTY          TIME CMD
   65 pts/0    00:00:00 bash
   76 pts/0    00:00:00 ps

root@6d0df15b1122:~# logout
Connection to localhost closed.
```

# docker commit this container
```{bash}
rwoo@rwoo-A610:~$ docker commit ubuntu14.04 ubuntu:14.04_6_ssh
sha256:74e28f6a222b6c414e1f5ba456ffb1f2850b9ebac579d7dc535a4622a5f580aa

rwoo@rwoo-A610:~$ docker rm ubuntu14.04 
ubuntu14.04

rwoo@rwoo-A610:~$ docker rmi ubuntu:14.04_4_SBT0.13.15 
Untagged: ubuntu:14.04_4_SBT0.13.15

rwoo@rwoo-A610:~$ docker run -it -e JAVA_HOME=/usr/lib/jvm/java-8-oracle --name ubuntu14.04 ubuntu:14.04_6_ssh

root@7290ac84546b:/# service ssh start
 * Starting OpenBSD Secure Shell server sshd

root@7290ac84546b:~# ssh localhost
Welcome to Ubuntu 14.04.5 LTS (GNU/Linux 4.4.0-31-generic x86_64)

 * Documentation:  https://help.ubuntu.com/
Last login: Wed May 24 15:02:29 2017 from localhost

root@7290ac84546b:~# logout
Connection to localhost closed.
```
