docker run -it --cpus="4" \
-p 8888:8888 \
-p 8088:8088 \
-p 18080:18080 \
-p 8042:8042 \
-v /home/ubuntu/02_Documents/10_Spark_WorkSpace/Spark-Study/02_Spark_Workspace/03_pyspark:/home/pyspark \
--name spark ubuntu:16.04_5th_jupyter_pyspark
# 8888 Jupyter Notebook
# 8088 Yarn Cluster
# 19888 Yarn HistoryServer
# 18080 Spark HistoryServer
# 8042 Yarn NodeManager
