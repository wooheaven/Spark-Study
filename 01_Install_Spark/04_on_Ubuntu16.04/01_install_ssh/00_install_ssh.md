```
$ cat Dockerfile 
FROM ubuntu:16.04

RUN apt-get update
RUN apt-get -y install software-properties-common \
    vim \
    tree \
    openssh-server \
    && rm -rf /var/lib/apt/lists/*

RUN sed -i 's/#PasswordAuthentication yes/PasswordAuthentication no/' /etc/ssh/sshd_config
RUN cat -n /etc/ssh/sshd_config | head -52 | tail -2

RUN service ssh start && \
    ssh-keygen -q -t rsa -N '' -f /root/.ssh/id_rsa && \
    cd /root/.ssh/ && \
    cp id_rsa.pub authorized_keys && \
    chmod 600 authorized_keys && \
    touch /root/.ssh/known_hosts && \
    ssh-keyscan -t rsa localhost >> /root/.ssh/known_hosts && \
    chmod 600 known_hosts && \
    ls -als /root/.ssh

ENTRYPOINT service ssh start && bash

$ cat 01_docker_build.sh 
docker build --rm -t ubuntu:16.04_1st_ssh .

$ cat 02_docker_run.sh 
docker run -it --name spark ubuntu:16.04_1st_ssh

$ cat 03_docker_rm_rmi.sh 
container=`docker ps -a | grep 16.04_1st_ssh | awk '{print $1}'`
if [ $container ] ; then
docker stop $container
docker rm $container
docker ps -a
fi
unset container

image=`docker images | grep 16.04_1st_ssh | awk '{print $3}'`
if [ $image ] ; then
docker rmi $image
docker images
fi
unset image

$ ./01_docker_build.sh 
$ ./02_docker_run.sh 
 * Starting OpenBSD Secure Shell server sshd                             [ OK ] 
root@71b2e7267c59:/#    
```
