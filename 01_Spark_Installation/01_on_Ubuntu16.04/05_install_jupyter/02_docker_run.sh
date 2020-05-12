docker run -it --cpus="4" \
-p 8888:8888 \
-p 8088:8088 \
-p 18080:18080 \
-p 8042:8042 \
-v `realpath ../../../02_Spark_Workspace/03_pyspark`:/home/pyspark \
--name spark_yarn_jupyter_pyspark ubuntu:16.04_5th_jupyter_pyspark
# 8888 Jupyter Notebook
# 8088 Yarn Cluster
# 19888 Yarn HistoryServer
# 18080 Spark HistoryServer
# 8042 Yarn NodeManager
