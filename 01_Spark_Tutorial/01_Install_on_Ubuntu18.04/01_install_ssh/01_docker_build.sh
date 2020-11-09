#!/bin/bash

docker pull ubuntu:18.04

echo ""

tmp=`docker images | grep "ubuntu" | grep "none" | awk '{print $3}'`
if [ -n $tmp ]
then
docker rmi $tmp
fi
unset tmp

echo ""

docker build --rm -t ubuntu:18.04_1st_ssh .
