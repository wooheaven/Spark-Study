FROM ubuntu:18.04_4th_spark_yarn

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

ADD 99_Utility/jupyter_bashrc.txt /root/
RUN cat /root/jupyter_bashrc.txt >> /root/.bashrc && \
    cat -n /root/.bashrc | tail -3

ADD 99_Utility/*.sh /root/
RUN chmod +x /root/*.sh
