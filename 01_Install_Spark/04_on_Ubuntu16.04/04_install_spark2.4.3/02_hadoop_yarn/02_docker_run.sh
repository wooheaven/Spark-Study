docker run -it --cpus="4" \
-p 8088:8088 \
-p 18080:18080 \
-p 8042:8042 \
--name spark ubuntu:16.04_4th_spark_yarn
# 8088 Yarn Cluster
# 19888 Yarn HistoryServer
# 18080 Spark HistoryServer
# 8042 Yarn NodeManager
