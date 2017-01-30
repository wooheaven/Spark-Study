# Install ssh on Ubuntu14.04
```{bash}
$ sudo apt-get install openssh-server
$ sudo dpkg -l openssh-server
$ sudo vi /etc/ssh/sshd_config
...
51 # Change to no to disable tunnelled clear text passwords
52 #PasswordAuthentication yes
53 PasswordAuthentication no
...

$ sudo service ssh restart

$ ssh-keygen -t rsa
$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
$ ll ~/.ssh

$ ssh localhost
```
