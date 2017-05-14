# pull ubuntu14.04 images to docker
```{bash}
$ docker pull ubuntu:14.04
14.04: Pulling from library/ubuntu
8f229c550c2e: Pull complete 
8e1fb71e8df6: Pull complete 
f75a34586856: Pull complete 
8744e322b832: Pull complete 
d5165bfce78f: Pull complete 
Digest: sha256:edf05697d8ea17028a69726b4b450ad48da8b29884cd640fec950c904bfb50ce
Status: Downloaded newer image for ubuntu:14.04

$ docker images
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
ubuntu                  14.04               302fa07d8117        4 weeks ago         188 MB
```

# run ubuntu14.04
```{bash}
$ docker run -it --name ubuntu14.04 ubuntu:14.04

root@cdb7333e2dec:/# cat /etc/issue
Ubuntu 14.04.5 LTS \n \l

$ docker ps
CONTAINER ID  IMAGE         COMMAND      CREATED        STATUS        PORTS  NAMES
cdb7333e2dec  ubuntu:14.04  "/bin/bash"  8 seconds ago  Up 7 seconds         ubuntu14.04
```

# attach ubuntu14.04
```{bash}
$ docker attach ubuntu14.04
root@cdb7333e2dec:/# 
```
