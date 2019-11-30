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

image=`docker images | grep "<none>" | awk '{print $3}' | head -1`
if [ $image ] ; then
echo ""
echo "docker image ["$image"] will be removed"
echo ""
docker rmi $image
docker images
fi
unset image
