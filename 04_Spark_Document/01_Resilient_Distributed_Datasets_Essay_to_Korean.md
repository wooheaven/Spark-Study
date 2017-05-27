# Title
```{text}
Resilient Distributed Datasets: A Fault-Tolerant Abstraction for In-Memory Cluster Computing
탄력적인 분산 데이터셋 : 클러스터 메모리 안에서 연산을 하기 위한 내고장성의 추상체

resilient adj able to return quickly to usual health or good spirits after going through difficulty, disease, change etc.
abstraction noun the act of consifering something as as general quality or characteristic, apart from concrete realities, specific objects, or actual instances.

Matei Zaharia, Mosharaf Chowdhury, Tathagata Das, Ankur Dave, Justin Ma, Murphy McCauley, Michael J. Franklin, Scott Shenker, Ion Stoica
University of California, Berkeley
```

# Abstract
```
We present Resilient Distributed Datasets (RDDs), a distributed memory abstraction that lets programmers perform in-memory computations on large clusters in a fault-tolerant manner.
우리는 RDDs를 발표하는데, RDDs란 분산 메모리 추상체로 프로그래머가 큰 클러스터에서 내고장성으로 메모리상에서 연산을 수행할 수 있도록 합니다.

RDDs are motivated by two types of applications that current computing frameworks handle inefficiently: iterative algorithms and interactive data mining tools.
RDDS는 현재 연산 프레임워크가 비효율적으로 처리하는 2가지 유형의 응용프로그램, 즉 반복 알고리즘과 데이터 마이닝 도구에 의하여 동기가 부여됩니다.

In both cases, keeping data in memory can improve performance by an order of magnitude.
2가지 유형 모두, 메모리에 데이터를 유지하는 것이 10배 차이로 성능을 향상 시킬 수 있습니다.

To achieve fault tolerance efficiently, RDDs provide a restricted form of shared memory, based on coarse-grained transformations rather than fine-grained updates to shared state. 
내고장성을 효율적으로 달성하기 위해서, RDDS는 공유된 메모리의 제한적인 형태를 제공하는데, 제한적인 형태란 공유된 상태에 세분화된 업데이트를 하기보다는 뭉쳐진 변형을 적용하는 것이다.
```