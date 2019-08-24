container=`docker ps -a | grep 16.04_2nd_jdk8 | awk '{print $1}'`
if [ $container ] ; then
docker stop $container
docker rm $container
docker ps -a
fi
unset container

image=`docker images | grep 16.04_2nd_jdk8 | awk '{print $3}'`
if [ $image ] ; then
docker rmi $image
docker images
fi
unset image
