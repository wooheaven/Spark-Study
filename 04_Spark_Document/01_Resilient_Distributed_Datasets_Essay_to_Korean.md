# Title
```{text}
Resilient Distributed Datasets: A Fault-Tolerant Abstraction for In-Memory Cluster Computing
탄력적인 분산 데이터셋 : 클러스터 메모리 안에서 연산을 하기 위한 내고장성의 추상체

(resilient adj able to return quickly to usual health or good spirits after going through difficulty, disease, change etc.)
(abstraction noun the act of consifering something as as general quality or characteristic, apart from concrete realities, specific objects, or actual instances.)

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

However, we show that RDDs are expressive enough to capture a wide class of computations, 
including recent specialized programming models for iterative jobs, such as Pregel, and new applications that these models do not capture.
그러나, 우리는 RDD가 Pregel처럼 반복적인 작업을 위한 최신 전문화된 프로그램밍 모델과 이런 모델들이 포착하지 못하는 새로운 응용프로그램을 포함하는 다양한 종류의 연산을 포착할 만큼 충분히 표현적이라는 것을 보여줍니다. 

We have implemented RDDs in a system called Spark, which we evaluate through a variety of user applications and benchmarks.
우리는 다양한 사용자 응용프로그램과 상대평가를 수행한 스파크라고 불리는 시스템에서 RDD를 구현해왔다.
```

# 1 Introduction
```
Cluster computing frameworks like MapReduce [10] and Dryad [19] have been widely adopted for large-scale data analytics.
맵리듀스와 드레이드 같은 클러스터 컴퓨팅 프레임워크들은 대규모 데이터 분석에서 널리 채택되어 왔다.

These systems let users write parallel computations using a set of high-level operators, without having to worry about work distribution and fault tolerance.
이런 시스템들은 사용자가 분산처리와 내고장성에 대해서 걱정할 필요없이 상위-레벨 연산자들을 이용하여 병렬연산을 작성할 수 있게 한다.

Although current frameworks provide numerous abstractions for accessing a cluster’s computational resources, they lack abstractions for leveraging distributed memory.
현재 프레임워크는 클러스터의 계산 리소스에 접근하기위한 수많은 추상화를 제공하지만, 분산 메모리를 활용하는 추상화는 부족합니다.

This makes them inefficient for an important class of emerging applications: those that reuse intermediate results across multiple computations.
이것(현재 프레임워크)는 개발하고 있는 응용프로그램들의 중요한 클래스에 있어서 그들(추상화들)을 비효율적으로 만든다. : 그것들(개발하고 있는 응용프로그램들)은 여러 계산에 걸쳐 중간 결과를 사용한다.

(emerge verb to come into existence; develop)

Data reuse is common in many iterative machine learning and graph algorithms, including PageRank, K-means clustering, and logistic regression.
페이지 랭크와 K평균 클러스터링과 로지스틱 회귀를 포함하는 반복 머신 러닝과 그래프 알고리즘에서 데이터 재사용은 일반적입니다.

Another compelling use case is interactive data mining, where a user runs multiple adhoc queries on the same subset of the data.
(데이터를 재사용하는) 또 다른 강력한 사용 사례는 사용자가 데이터의 같은 부분집합상에서 다양한 일회성 쿼리들을 실행하는 대화형 데이터 마이닝입니다.
```
