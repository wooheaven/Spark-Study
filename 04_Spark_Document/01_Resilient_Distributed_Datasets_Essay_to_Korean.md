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

Unfortunately, in most current frameworks, the only way to reuse data between computations (e.g., between two MapReduce jobs) is to write it to an external stable storage system, e.g., a distributed file system.
불행하게도, 대부분의 최신 프레임워크에서는, (예를 들어, 2 개의 MapReduce 작업들 사이에서 처럼) 연산들 사이의 데이터를 재사용하는 유일한 방법은 외부의 안정적인 저장 시스템, 예를 들어 분산 파일 시스템에 저장하는 것이다.

This incurs substantial overheads due to data replication, disk I/O, and serialization, which can dominate application execution times.
이것은 데이터 중복, 디스크 I/O 그리고 응용프로그램 실행 시간을 점유할 수 있는 직렬화 때문에 잠재적인 오버해드를 발생시킨다.

Recognizing this problem, researchers have developed specialized frameworks for some applications that require data reuse
이 문제를 인식하면서, 연구자들은 데이터 재사용이 필요한 일부 응용프로그램을 위한 특화된 프레임워크들을 개발해왔다.

For example, Pregel [22] is a system for iterative graph computations that keeps intermediate data in memory, while HaLoop [7] offers an iterative MapReduce interface.
예를 들어, Pregel은 중간 데이터를 메모리에 보관하는 반복 그래프 연산을 위한 시스템이며, HaLoop은 반복적인 MapReduce 인터페이스를 제공한다.

However, these frameworks only support specific computation patterns (e.g., looping a series of MapReduce steps), and perform data sharing implicitly for these patterns.
그러나, 이러한 프레임워크들은 특별한 연산 패턴들(예를 들어, 일련의 MapReduce 단계 반복) 만 지원하고, 이런 패턴들을 위해서 데이터 공유를 암묵적으로 수행한다.

They do not provide abstractions for more general reuse, e.g., to let a user load several datasets into memory and run ad-hoc queries across them.
그들은 예를 들어, 사용자가 여러 데이터 세트를 메모리에 로드하고 데이터세트 사이에서 임시 퀴리를 실행하는 것처럼 더 일반적인 재사용을 위한 추상화를 제공하지 않는다.

In this paper, we propose a new abstraction called re-silient distributed datasets (RDDs) that enables efficient data  reuse  in  a  broad  range  of  applications.
이 논문에서는 우리는 다양한 응용프로그램들에서 데이터 재사용을 효율적으로 할 수 있는 RDDs라고하는 새로운 추상화를 제안한다.

RDDs are fault-tolerant, parallel data structures that let users explicitly persist intermediate results in memory, control their partitioning to optimize data placement, and manipulate them using a rich set of operators.
RDDs는 내고장성인 병렬 데이터구조로써 사용자들이 명시적으로 중간 결과를 메모리에 유지시키고, 데이터 배치를 최적화하기 위해 RDDs의 분할을 조절하고, 풍부한 연산자 집합을 사용함으로써 RDDs를 조작할 수 있게한다.

The main challenge in designing RDDs is defining a programming interface that can provide fault tolerance efficiently.
RDDs 설계에서 주된 도전은 내고장성을 효율적으로 제공하는 인터페이스 프로그래밍을 정의하는 것입니다.

Existing abstractions for in-memory storage on clusters, such as distributed shared memory [24], keyvalue stores [25], databases, and Piccolo [27], offer an interface based on fine-grained updates to mutable state (e.g., cells in a table).
클러스터의 메모리 저장을 위해 존재하는 추상화들은 예를 들면 분산공유된 메모리, 키값 저장 데이터베이스들, Piccolo 처럼 변경가능한 상태(예를 들면, 테이블의 셀)에 세분화된 업데이트를 기반으로하는 인터페이스를 제공한다.
```
