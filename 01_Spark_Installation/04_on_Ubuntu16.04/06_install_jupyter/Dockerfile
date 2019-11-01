FROM ubuntu:16.04_4th_spark_yarn

RUN apt-get update 

RUN apt-get install -y python3-pip \
    && rm -rf /var/lib/apt/lists/*

RUN python3 -m pip install --upgrade pip \
    && which pip \
    && which pip3 \
    && pip -V \
    && pip3 -V

RUN pip install six --upgrade

RUN pip install findspark jupyter

RUN echo "" >> /root/.bashrc \
    && echo "#PySpark" >> /root/.bashrc \
    && echo "export PYSPARK_DRIVER_PYTHON=jupyter" >> /root/.bashrc \
    && echo "export PYSPARK_DRIVER_PYTHON_OPTS='notebook'" >> /root/.bashrc \
    && cat -n /root/.bashrc

ADD 99_Utility/30_jupyter_notebook.sh /root/
RUN chmod +x /root/*.sh
