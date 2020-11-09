# 0. Bigdata/Spark Tutorial강의 아젠다 to someone
```
1. 언제 : 지금부터 1시간안으로
2. 어디서 : 인터넷과 도커가 되는 컴에서
3. 누가 : 우륭이 someone에게
4. 어떻게 : 실습(소개)
5. 왜 : (someone) 빅데이터를 배우기 위해, (우륭) 빅데이터팀과 협업할 수 있는 과제를 발굴하기 위해
6. 무엇을 : Docker, Hadoop, Spark, Python을 이용하여 1999년 Google의 창업당시 검색엔진을 위한 알고리즘 PageRank를 구현한다.
7. 강의 후 : 개인 노트북에서 빅데이터 분석을 할 수 있다.
```

# 1. 동기부여
```
1999년 Google의 창업당시 검색엔진을 위한 알고리즘 PageRank를 구현한다.
2020년 가장 쉬운 기술로 21년전 빅데이터 사례를 구현한다.
```
[CS 6464: Spring 2009 Advanced Distributed Storage Systems](http://www.cs.cornell.edu/courses/cs6464/2009sp/sched.htm)  
[GFS](http://www.cs.cornell.edu/courses/cs6464/2009sp/lectures/15-gfs.pdf)  
[Show demo Gephi HTTP Graph]  

# 2. download by usb
```
docker 간략한 소개
pyspark/01_PageRank.ipynb
pyspark/01_PageRank_data.csv
spark.tar 파일
```

# 3. install and run spark
```
$ docker load -i spark.tar 
$ docker run -it -p 8888:8888 -v `pwd`/pyspark:/home/pyspark --name="spark" ubuntu:18.04_5th_jupyter_pyspark
# ./01_start_all.sh
# ./25_jupyter_notebook.sh
# ./02_stop_all.sh
```

# 4. PageRank
```
간략한 소개
```
