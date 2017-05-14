# pull centos6.9 images to docker
```{bash}
$ docker pull centos:6.9
6.9: Pulling from library/centos
02901d68ac03: Pull complete 
Digest: sha256:a23bced61701af9a0a758e94229676d9f09996a3ff0f3d26955b06bac8c282e0
Status: Downloaded newer image for centos:6.9

$ docker images
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
centos                  6.9                 573de66f263e        5 weeks ago         195 MB
```

# run centos6.9
```{bash}
$ docker run -it --name centos6.9 centos:6.9
[root@febc1daa88f8 /]# cat /etc/issue
CentOS release 6.9 (Final)
Kernel \r on an \m

$ docker ps
CONTAINER ID  IMAGE       COMMAND      CREATED         STATUS        PORTS  NAMES
febc1daa88f8  centos:6.9  "/bin/bash"  10 seconds ago  Up 8 seconds         centos6.9
```

# attach centos6.9
```{bash}
$ docker attach
[root@febc1daa88f8 /]# 
```
