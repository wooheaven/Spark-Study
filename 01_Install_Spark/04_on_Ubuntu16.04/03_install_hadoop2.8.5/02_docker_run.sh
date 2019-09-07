docker run -it --cpus="4" \
-p 8088:8088 \
-p 19888:19888 \
-p 8042:8042 \
--name spark ubuntu:16.04_3rd_hadoop2
# 8088 Yarn Cluster
# 19888 HistoryServer
# 8042 Yarn NodeManager
