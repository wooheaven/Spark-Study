#!/bin/bash

docker pull ubuntu:16.04

echo ""

tmp=`docker images | grep "ubuntu" | grep "none" | awk '{print $3}'`
if [ -n $tmp ]
then
docker rmi $tmp
fi
unset tmp

echo ""

docker build --rm -t ubuntu:16.04_1st_ssh .
