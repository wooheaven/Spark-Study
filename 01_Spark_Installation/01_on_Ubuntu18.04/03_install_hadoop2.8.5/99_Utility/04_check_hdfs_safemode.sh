#!/bin/bash

number=1
while [ $number -le 5 ]
do
  check=$(hdfs dfsadmin -safemode get | awk '{print $4}')
  echo "Number: ${number}, Check: ${check}"
  if [ $check == "OFF" ]
  then
    number=$(($number+5))
  else
    ((number++))
    sleep 5
  fi
done

