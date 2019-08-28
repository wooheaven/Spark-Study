# spark-submit WordCount
```{bash}
hadoop@BISTel:~$ spark-submit \
--class rwoo.study.spark.example.WordCount \
--deploy-mode client \
--num-executors 1 \
--driver-memory 512m \
--executor-memory 512m \
--executor-cores 1 \
spark2WithJDK8-1.0-SNAPSHOT.jar \
yarn hdfs:///user/hadoop/input hdfs:///user/hadoop/output/

2018-06-02 18:22:03 INFO  SparkContext:54 - Running Spark version 2.3.0
2018-06-02 18:22:03 INFO  SparkContext:54 - Submitted application: WordCount by JDK8
2018-06-02 18:22:03 INFO  SecurityManager:54 - Changing view acls to: hadoop
2018-06-02 18:22:03 INFO  SecurityManager:54 - Changing modify acls to: hadoop
2018-06-02 18:22:03 INFO  SecurityManager:54 - Changing view acls groups to:
2018-06-02 18:22:03 INFO  SecurityManager:54 - Changing modify acls groups to:
2018-06-02 18:22:03 INFO  SecurityManager:54 - SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(hadoop); groups with view permissions: Set(); users  with modify permissions: Set(hadoop); groups with modify permissions: Set()
2018-06-02 18:22:04 INFO  Utils:54 - Successfully started service 'sparkDriver' on port 37284.
2018-06-02 18:22:05 INFO  SparkEnv:54 - Registering MapOutputTracker
2018-06-02 18:22:05 INFO  SparkEnv:54 - Registering BlockManagerMaster
2018-06-02 18:22:05 INFO  BlockManagerMasterEndpoint:54 - Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
2018-06-02 18:22:05 INFO  BlockManagerMasterEndpoint:54 - BlockManagerMasterEndpoint up
2018-06-02 18:22:05 INFO  DiskBlockManager:54 - Created local directory at /tmp/blockmgr-5d9f3aee-3e26-46a8-b0f6-dfeb3ba232f6
2018-06-02 18:22:05 INFO  MemoryStore:54 - MemoryStore started with capacity 93.3 MB
2018-06-02 18:22:05 INFO  SparkEnv:54 - Registering OutputCommitCoordinator
2018-06-02 18:22:05 INFO  log:192 - Logging initialized @7944ms
2018-06-02 18:22:06 INFO  Server:346 - jetty-9.3.z-SNAPSHOT
2018-06-02 18:22:06 INFO  Server:414 - Started @8352ms
2018-06-02 18:22:06 INFO  AbstractConnector:278 - Started ServerConnector@5167268{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}
2018-06-02 18:22:06 INFO  Utils:54 - Successfully started service 'SparkUI' on port 4040.
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@610db97e{/jobs,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@1cefc4b3{/jobs/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2b27cc70{/jobs/job,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@1bdaa23d{/jobs/job/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@79f227a9{/stages,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6ca320ab{/stages/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@50d68830{/stages/stage,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3a7704c{/stages/stage/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6754ef00{/stages/pool,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@619bd14c{/stages/pool/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@323e8306{/storage,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@a23a01d{/storage/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4acf72b6{/storage/rdd,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@7561db12{/storage/rdd/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3301500b{/environment,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@24b52d3e{/environment/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@15deb1dc{/executors,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6e9c413e{/executors/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@57a4d5ee{/executors/threadDump,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@5af5def9{/executors/threadDump/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3a45c42a{/static,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3c1e3314{/,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4b770e40{/api,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6a1ebcff{/jobs/job/kill,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@19868320{/stages/stage/kill,null,AVAILABLE,@Spark}
2018-06-02 18:22:06 INFO  SparkUI:54 - Bound SparkUI to 0.0.0.0, and started at http://BISTel.Research.Dev.ClientNode:4040
2018-06-02 18:22:06 INFO  SparkContext:54 - Added JAR file:/home/hadoop/spark2WithJDK8-1.0-SNAPSHOT.jar at spark://BISTel.Research.Dev.ClientNode:37284/jars/spark2WithJDK8-1.0-SNAPSHOT.jar with timestamp 1527931326769
2018-06-02 18:22:10 INFO  RMProxy:98 - Connecting to ResourceManager at BISTel.Research.Dev.YarnNode/192.168.3.44:8032
2018-06-02 18:22:10 INFO  Client:54 - Requesting a new application from cluster with 3 NodeManagers
2018-06-02 18:22:11 INFO  Client:54 - Verifying our application has not requested more than the maximum memory capability of the cluster (8192 MB per container)
2018-06-02 18:22:11 INFO  Client:54 - Will allocate AM container, with 896 MB memory including 384 MB overhead
2018-06-02 18:22:11 INFO  Client:54 - Setting up container launch context for our AM
2018-06-02 18:22:11 INFO  Client:54 - Setting up the launch environment for our AM container
2018-06-02 18:22:11 INFO  Client:54 - Preparing resources for our AM container
2018-06-02 18:22:15 INFO  Client:54 - Source and destination file systems are the same. Not copying hdfs:/spark/yarn/archive/spark-libs.jar
2018-06-02 18:22:16 INFO  Client:54 - Uploading resource file:/tmp/spark-a58e65cb-7b0d-4236-90b3-4bf647caf25e/__spark_conf__1922170465927074532.zip -> hdfs://BISTel.Research.Dev.NameNode:9000/user/hadoop/.sparkStaging/application_1527930544788_0001/__spark_conf__.zip
2018-06-02 18:22:18 INFO  SecurityManager:54 - Changing view acls to: hadoop
2018-06-02 18:22:18 INFO  SecurityManager:54 - Changing modify acls to: hadoop
2018-06-02 18:22:18 INFO  SecurityManager:54 - Changing view acls groups to:
2018-06-02 18:22:18 INFO  SecurityManager:54 - Changing modify acls groups to:
2018-06-02 18:22:18 INFO  SecurityManager:54 - SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(hadoop); groups with view permissions: Set(); users  with modify permissions: Set(hadoop); groups with modify permissions: Set()
2018-06-02 18:22:18 INFO  Client:54 - Submitting application application_1527930544788_0001 to ResourceManager
2018-06-02 18:22:18 INFO  YarnClientImpl:273 - Submitted application application_1527930544788_0001
2018-06-02 18:22:18 INFO  SchedulerExtensionServices:54 - Starting Yarn extension services with app application_1527930544788_0001 and attemptId None
2018-06-02 18:22:19 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:19 INFO  Client:54 -
	 client token: N/A
	 diagnostics: [Sat Jun 02 18:22:19 +0900 2018] Scheduler has assigned a container for AM, waiting for AM container to be launched
	 ApplicationMaster host: N/A
	 ApplicationMaster RPC port: -1
	 queue: default
	 start time: 1527931338530
	 final status: UNDEFINED
	 tracking URL: http://BISTel.Research.Dev.YarnNode:8088/proxy/application_1527930544788_0001/
	 user: hadoop
2018-06-02 18:22:21 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:22 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:23 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:24 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:25 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:26 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:27 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:28 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:29 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:30 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:31 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:32 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:33 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:34 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:35 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:36 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:37 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:38 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:39 INFO  YarnClientSchedulerBackend:54 - Add WebUI Filter. org.apache.hadoop.yarn.server.webproxy.amfilter.AmIpFilter, Map(PROXY_HOSTS -> BISTel.Research.Dev.YarnNode, PROXY_URI_BASES -> http://BISTel.Research.Dev.YarnNode:8088/proxy/application_1527930544788_0001), /proxy/application_1527930544788_0001
2018-06-02 18:22:39 INFO  JettyUtils:54 - Adding filter: org.apache.hadoop.yarn.server.webproxy.amfilter.AmIpFilter
2018-06-02 18:22:39 INFO  Client:54 - Application report for application_1527930544788_0001 (state: ACCEPTED)
2018-06-02 18:22:40 INFO  Client:54 - Application report for application_1527930544788_0001 (state: RUNNING)
2018-06-02 18:22:40 INFO  Client:54 -
	 client token: N/A
	 diagnostics: N/A
	 ApplicationMaster host: 192.168.3.42
	 ApplicationMaster RPC port: 0
	 queue: default
	 start time: 1527931338530
	 final status: UNDEFINED
	 tracking URL: http://BISTel.Research.Dev.YarnNode:8088/proxy/application_1527930544788_0001/
	 user: hadoop
2018-06-02 18:22:40 INFO  YarnClientSchedulerBackend:54 - Application application_1527930544788_0001 has started running.
2018-06-02 18:22:40 INFO  YarnSchedulerBackend$YarnSchedulerEndpoint:54 - ApplicationMaster registered as NettyRpcEndpointRef(spark-client://YarnAM)
2018-06-02 18:22:40 INFO  Utils:54 - Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 46174.
2018-06-02 18:22:40 INFO  NettyBlockTransferService:54 - Server created on BISTel.Research.Dev.ClientNode:46174
2018-06-02 18:22:40 INFO  BlockManager:54 - Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
2018-06-02 18:22:40 INFO  BlockManagerMaster:54 - Registering BlockManager BlockManagerId(driver, BISTel.Research.Dev.ClientNode, 46174, None)
2018-06-02 18:22:40 INFO  BlockManagerMasterEndpoint:54 - Registering block manager BISTel.Research.Dev.ClientNode:46174 with 93.3 MB RAM, BlockManagerId(driver, BISTel.Research.Dev.ClientNode, 46174, None)
2018-06-02 18:22:40 INFO  BlockManagerMaster:54 - Registered BlockManager BlockManagerId(driver, BISTel.Research.Dev.ClientNode, 46174, None)
2018-06-02 18:22:40 INFO  BlockManager:54 - Initialized BlockManager: BlockManagerId(driver, BISTel.Research.Dev.ClientNode, 46174, None)
2018-06-02 18:22:40 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@8c0a23f{/metrics/json,null,AVAILABLE,@Spark}
2018-06-02 18:22:41 INFO  EventLoggingListener:54 - Logging events to hdfs://BISTel.Research.Dev.NameNode:9000/var/log/spark/application_1527930544788_0001
2018-06-02 18:22:41 INFO  YarnClientSchedulerBackend:54 - SchedulerBackend is ready for scheduling beginning after waiting maxRegisteredResourcesWaitingTime: 30000(ms)
2018-06-02 18:22:42 INFO  MemoryStore:54 - Block broadcast_0 stored as values in memory (estimated size 241.5 KB, free 93.1 MB)
2018-06-02 18:22:43 INFO  MemoryStore:54 - Block broadcast_0_piece0 stored as bytes in memory (estimated size 23.1 KB, free 93.0 MB)
2018-06-02 18:22:43 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on BISTel.Research.Dev.ClientNode:46174 (size: 23.1 KB, free: 93.3 MB)
2018-06-02 18:22:43 INFO  SparkContext:54 - Created broadcast 0 from textFile at WordCount.java:25
2018-06-02 18:22:43 INFO  FileInputFormat:249 - Total input paths to process : 1
2018-06-02 18:22:44 INFO  SparkContext:54 - Starting job: sortByKey at WordCount.java:28
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Registering RDD 3 (mapToPair at WordCount.java:27)
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Got job 0 (sortByKey at WordCount.java:28) with 2 output partitions
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Final stage: ResultStage 1 (sortByKey at WordCount.java:28)
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Parents of final stage: List(ShuffleMapStage 0)
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Missing parents: List(ShuffleMapStage 0)
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Submitting ShuffleMapStage 0 (MapPartitionsRDD[3] at mapToPair at WordCount.java:27), which has no missing parents
2018-06-02 18:22:44 INFO  MemoryStore:54 - Block broadcast_1 stored as values in memory (estimated size 6.0 KB, free 93.0 MB)
2018-06-02 18:22:44 INFO  MemoryStore:54 - Block broadcast_1_piece0 stored as bytes in memory (estimated size 3.3 KB, free 93.0 MB)
2018-06-02 18:22:44 INFO  BlockManagerInfo:54 - Added broadcast_1_piece0 in memory on BISTel.Research.Dev.ClientNode:46174 (size: 3.3 KB, free: 93.3 MB)
2018-06-02 18:22:44 INFO  SparkContext:54 - Created broadcast 1 from broadcast at DAGScheduler.scala:1039
2018-06-02 18:22:44 INFO  DAGScheduler:54 - Submitting 2 missing tasks from ShuffleMapStage 0 (MapPartitionsRDD[3] at mapToPair at WordCount.java:27) (first 15 tasks are for partitions Vector(0, 1))
2018-06-02 18:22:44 INFO  YarnScheduler:54 - Adding task set 0.0 with 2 tasks
2018-06-02 18:22:50 INFO  YarnSchedulerBackend$YarnDriverEndpoint:54 - Registered executor NettyRpcEndpointRef(spark-client://Executor) (192.168.3.42:37546) with ID 1
2018-06-02 18:22:50 INFO  TaskSetManager:54 - Starting task 0.0 in stage 0.0 (TID 0, BISTel.Research.Dev.DataNode02, executor 1, partition 0, NODE_LOCAL, 7915 bytes)
2018-06-02 18:22:50 INFO  BlockManagerMasterEndpoint:54 - Registering block manager BISTel.Research.Dev.DataNode02:38751 with 93.3 MB RAM, BlockManagerId(1, BISTel.Research.Dev.DataNode02, 38751, None)
2018-06-02 18:22:52 INFO  BlockManagerInfo:54 - Added broadcast_1_piece0 in memory on BISTel.Research.Dev.DataNode02:38751 (size: 3.3 KB, free: 93.3 MB)
2018-06-02 18:22:53 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on BISTel.Research.Dev.DataNode02:38751 (size: 23.1 KB, free: 93.3 MB)
2018-06-02 18:22:57 INFO  TaskSetManager:54 - Starting task 1.0 in stage 0.0 (TID 1, BISTel.Research.Dev.DataNode02, executor 1, partition 1, NODE_LOCAL, 7915 bytes)
2018-06-02 18:22:57 INFO  TaskSetManager:54 - Finished task 0.0 in stage 0.0 (TID 0) in 7220 ms on BISTel.Research.Dev.DataNode02 (executor 1) (1/2)
2018-06-02 18:22:58 INFO  TaskSetManager:54 - Finished task 1.0 in stage 0.0 (TID 1) in 501 ms on BISTel.Research.Dev.DataNode02 (executor 1) (2/2)
2018-06-02 18:22:58 INFO  YarnScheduler:54 - Removed TaskSet 0.0, whose tasks have all completed, from pool
2018-06-02 18:22:58 INFO  DAGScheduler:54 - ShuffleMapStage 0 (mapToPair at WordCount.java:27) finished in 13.824 s
2018-06-02 18:22:58 INFO  DAGScheduler:54 - looking for newly runnable stages
2018-06-02 18:22:58 INFO  DAGScheduler:54 - running: Set()
2018-06-02 18:22:58 INFO  DAGScheduler:54 - waiting: Set(ResultStage 1)
2018-06-02 18:22:58 INFO  DAGScheduler:54 - failed: Set()
2018-06-02 18:22:58 INFO  DAGScheduler:54 - Submitting ResultStage 1 (MapPartitionsRDD[6] at sortByKey at WordCount.java:28), which has no missing parents
2018-06-02 18:22:58 INFO  MemoryStore:54 - Block broadcast_2 stored as values in memory (estimated size 4.5 KB, free 93.0 MB)
2018-06-02 18:22:58 INFO  MemoryStore:54 - Block broadcast_2_piece0 stored as bytes in memory (estimated size 2.6 KB, free 93.0 MB)
2018-06-02 18:22:58 INFO  BlockManagerInfo:54 - Added broadcast_2_piece0 in memory on BISTel.Research.Dev.ClientNode:46174 (size: 2.6 KB, free: 93.3 MB)
2018-06-02 18:22:58 INFO  SparkContext:54 - Created broadcast 2 from broadcast at DAGScheduler.scala:1039
2018-06-02 18:22:58 INFO  DAGScheduler:54 - Submitting 2 missing tasks from ResultStage 1 (MapPartitionsRDD[6] at sortByKey at WordCount.java:28) (first 15 tasks are for partitions Vector(0, 1))
2018-06-02 18:22:58 INFO  YarnScheduler:54 - Adding task set 1.0 with 2 tasks
2018-06-02 18:22:58 INFO  TaskSetManager:54 - Starting task 0.0 in stage 1.0 (TID 2, BISTel.Research.Dev.DataNode02, executor 1, partition 0, NODE_LOCAL, 7660 bytes)
2018-06-02 18:22:58 INFO  BlockManagerInfo:54 - Added broadcast_2_piece0 in memory on BISTel.Research.Dev.DataNode02:38751 (size: 2.6 KB, free: 93.3 MB)
2018-06-02 18:22:58 INFO  MapOutputTrackerMasterEndpoint:54 - Asked to send map output locations for shuffle 0 to 192.168.3.42:37546
2018-06-02 18:22:59 INFO  TaskSetManager:54 - Starting task 1.0 in stage 1.0 (TID 3, BISTel.Research.Dev.DataNode02, executor 1, partition 1, NODE_LOCAL, 7660 bytes)
2018-06-02 18:22:59 INFO  TaskSetManager:54 - Finished task 0.0 in stage 1.0 (TID 2) in 859 ms on BISTel.Research.Dev.DataNode02 (executor 1) (1/2)
2018-06-02 18:22:59 INFO  TaskSetManager:54 - Finished task 1.0 in stage 1.0 (TID 3) in 180 ms on BISTel.Research.Dev.DataNode02 (executor 1) (2/2)
2018-06-02 18:22:59 INFO  DAGScheduler:54 - ResultStage 1 (sortByKey at WordCount.java:28) finished in 1.069 s
2018-06-02 18:22:59 INFO  YarnScheduler:54 - Removed TaskSet 1.0, whose tasks have all completed, from pool
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Job 0 finished: sortByKey at WordCount.java:28, took 15.224005 s
2018-06-02 18:22:59 INFO  deprecation:1173 - mapred.output.dir is deprecated. Instead, use mapreduce.output.fileoutputformat.outputdir
2018-06-02 18:22:59 INFO  FileOutputCommitter:108 - File Output Committer Algorithm version is 1
2018-06-02 18:22:59 INFO  SparkContext:54 - Starting job: runJob at SparkHadoopWriter.scala:78
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Registering RDD 4 (reduceByKey at WordCount.java:28)
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Got job 1 (runJob at SparkHadoopWriter.scala:78) with 2 output partitions
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Final stage: ResultStage 4 (runJob at SparkHadoopWriter.scala:78)
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Parents of final stage: List(ShuffleMapStage 3)
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Missing parents: List(ShuffleMapStage 3)
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Submitting ShuffleMapStage 3 (ShuffledRDD[4] at reduceByKey at WordCount.java:28), which has no missing parents
2018-06-02 18:22:59 INFO  MemoryStore:54 - Block broadcast_3 stored as values in memory (estimated size 4.2 KB, free 93.0 MB)
2018-06-02 18:22:59 INFO  MemoryStore:54 - Block broadcast_3_piece0 stored as bytes in memory (estimated size 2.5 KB, free 93.0 MB)
2018-06-02 18:22:59 INFO  BlockManagerInfo:54 - Added broadcast_3_piece0 in memory on BISTel.Research.Dev.ClientNode:46174 (size: 2.5 KB, free: 93.3 MB)
2018-06-02 18:22:59 INFO  SparkContext:54 - Created broadcast 3 from broadcast at DAGScheduler.scala:1039
2018-06-02 18:22:59 INFO  DAGScheduler:54 - Submitting 2 missing tasks from ShuffleMapStage 3 (ShuffledRDD[4] at reduceByKey at WordCount.java:28) (first 15 tasks are for partitions Vector(0, 1))
2018-06-02 18:22:59 INFO  YarnScheduler:54 - Adding task set 3.0 with 2 tasks
2018-06-02 18:22:59 INFO  TaskSetManager:54 - Starting task 0.0 in stage 3.0 (TID 4, BISTel.Research.Dev.DataNode02, executor 1, partition 0, NODE_LOCAL, 7649 bytes)
2018-06-02 18:22:59 INFO  BlockManagerInfo:54 - Added broadcast_3_piece0 in memory on BISTel.Research.Dev.DataNode02:38751 (size: 2.5 KB, free: 93.3 MB)
2018-06-02 18:23:00 INFO  TaskSetManager:54 - Starting task 1.0 in stage 3.0 (TID 5, BISTel.Research.Dev.DataNode02, executor 1, partition 1, NODE_LOCAL, 7649 bytes)
2018-06-02 18:23:00 INFO  TaskSetManager:54 - Finished task 0.0 in stage 3.0 (TID 4) in 234 ms on BISTel.Research.Dev.DataNode02 (executor 1) (1/2)
2018-06-02 18:23:00 INFO  TaskSetManager:54 - Finished task 1.0 in stage 3.0 (TID 5) in 119 ms on BISTel.Research.Dev.DataNode02 (executor 1) (2/2)
2018-06-02 18:23:00 INFO  YarnScheduler:54 - Removed TaskSet 3.0, whose tasks have all completed, from pool
2018-06-02 18:23:00 INFO  DAGScheduler:54 - ShuffleMapStage 3 (reduceByKey at WordCount.java:28) finished in 0.395 s
2018-06-02 18:23:00 INFO  DAGScheduler:54 - looking for newly runnable stages
2018-06-02 18:23:00 INFO  DAGScheduler:54 - running: Set()
2018-06-02 18:23:00 INFO  DAGScheduler:54 - waiting: Set(ResultStage 4)
2018-06-02 18:23:00 INFO  DAGScheduler:54 - failed: Set()
2018-06-02 18:23:00 INFO  DAGScheduler:54 - Submitting ResultStage 4 (MapPartitionsRDD[8] at saveAsTextFile at WordCount.java:30), which has no missing parents
2018-06-02 18:23:00 INFO  MemoryStore:54 - Block broadcast_4 stored as values in memory (estimated size 72.8 KB, free 92.9 MB)
2018-06-02 18:23:00 INFO  MemoryStore:54 - Block broadcast_4_piece0 stored as bytes in memory (estimated size 26.5 KB, free 92.9 MB)
2018-06-02 18:23:00 INFO  BlockManagerInfo:54 - Added broadcast_4_piece0 in memory on BISTel.Research.Dev.ClientNode:46174 (size: 26.5 KB, free: 93.2 MB)
2018-06-02 18:23:00 INFO  SparkContext:54 - Created broadcast 4 from broadcast at DAGScheduler.scala:1039
2018-06-02 18:23:00 INFO  DAGScheduler:54 - Submitting 2 missing tasks from ResultStage 4 (MapPartitionsRDD[8] at saveAsTextFile at WordCount.java:30) (first 15 tasks are for partitions Vector(0, 1))
2018-06-02 18:23:00 INFO  YarnScheduler:54 - Adding task set 4.0 with 2 tasks
2018-06-02 18:23:00 INFO  TaskSetManager:54 - Starting task 0.0 in stage 4.0 (TID 6, BISTel.Research.Dev.DataNode02, executor 1, partition 0, NODE_LOCAL, 7660 bytes)
2018-06-02 18:23:00 INFO  BlockManagerInfo:54 - Added broadcast_4_piece0 in memory on BISTel.Research.Dev.DataNode02:38751 (size: 26.5 KB, free: 93.2 MB)
2018-06-02 18:23:00 INFO  MapOutputTrackerMasterEndpoint:54 - Asked to send map output locations for shuffle 1 to 192.168.3.42:37546
2018-06-02 18:23:01 INFO  TaskSetManager:54 - Starting task 1.0 in stage 4.0 (TID 7, BISTel.Research.Dev.DataNode02, executor 1, partition 1, NODE_LOCAL, 7660 bytes)
2018-06-02 18:23:01 INFO  TaskSetManager:54 - Finished task 0.0 in stage 4.0 (TID 6) in 1414 ms on BISTel.Research.Dev.DataNode02 (executor 1) (1/2)
2018-06-02 18:23:02 INFO  TaskSetManager:54 - Finished task 1.0 in stage 4.0 (TID 7) in 462 ms on BISTel.Research.Dev.DataNode02 (executor 1) (2/2)
2018-06-02 18:23:02 INFO  YarnScheduler:54 - Removed TaskSet 4.0, whose tasks have all completed, from pool
2018-06-02 18:23:02 INFO  DAGScheduler:54 - ResultStage 4 (runJob at SparkHadoopWriter.scala:78) finished in 1.951 s
2018-06-02 18:23:02 INFO  DAGScheduler:54 - Job 1 finished: runJob at SparkHadoopWriter.scala:78, took 2.374319 s
2018-06-02 18:23:02 INFO  SparkHadoopWriter:54 - Job job_20180602182259_0008 committed.
2018-06-02 18:23:02 INFO  AbstractConnector:318 - Stopped Spark@5167268{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}
2018-06-02 18:23:02 INFO  SparkUI:54 - Stopped Spark web UI at http://BISTel.Research.Dev.ClientNode:4040
2018-06-02 18:23:02 INFO  YarnClientSchedulerBackend:54 - Interrupting monitor thread
2018-06-02 18:23:02 INFO  YarnClientSchedulerBackend:54 - Shutting down all executors
2018-06-02 18:23:02 INFO  YarnSchedulerBackend$YarnDriverEndpoint:54 - Asking each executor to shut down
2018-06-02 18:23:02 INFO  SchedulerExtensionServices:54 - Stopping SchedulerExtensionServices
(serviceOption=None,
 services=List(),
 started=false)
2018-06-02 18:23:02 INFO  YarnClientSchedulerBackend:54 - Stopped
2018-06-02 18:23:03 INFO  MapOutputTrackerMasterEndpoint:54 - MapOutputTrackerMasterEndpoint stopped!
2018-06-02 18:23:03 INFO  MemoryStore:54 - MemoryStore cleared
2018-06-02 18:23:03 INFO  BlockManager:54 - BlockManager stopped
2018-06-02 18:23:03 INFO  BlockManagerMaster:54 - BlockManagerMaster stopped
2018-06-02 18:23:03 INFO  OutputCommitCoordinator$OutputCommitCoordinatorEndpoint:54 - OutputCommitCoordinator stopped!
2018-06-02 18:23:03 INFO  SparkContext:54 - Successfully stopped SparkContext
2018-06-02 18:23:03 INFO  ShutdownHookManager:54 - Shutdown hook called
2018-06-02 18:23:03 INFO  ShutdownHookManager:54 - Deleting directory /tmp/spark-d4f65f4e-4965-4bb4-902d-9bb9132ccd7f
2018-06-02 18:23:03 INFO  ShutdownHookManager:54 - Deleting directory /tmp/spark-a58e65cb-7b0d-4236-90b3-4bf647caf25e
```

# hdfs dfs -ls
```{bash}
hadoop@BISTel:~$ hdfs dfs -ls /user/hadoop/output
Found 3 items
-rw-r--r--   2 hadoop supergroup          0 2018-06-02 18:23 /user/hadoop/output/_SUCCESS
-rw-r--r--   2 hadoop supergroup      39062 2018-06-02 18:23 /user/hadoop/output/part-00000
-rw-r--r--   2 hadoop supergroup      34398 2018-06-02 18:23 /user/hadoop/output/part-00001
```
