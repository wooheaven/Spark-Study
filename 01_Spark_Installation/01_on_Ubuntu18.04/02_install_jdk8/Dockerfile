FROM ubuntu:18.04_1st_ssh

RUN mkdir /usr/lib/jvm
ADD java-8.0.272-zulu.zip /usr/lib/jvm
RUN cd /usr/lib/jvm && unzip java-8.0.272-zulu.zip
RUN ls -als /usr/lib/jvm

ADD 99_Utility/java_bashrc.txt /root/
RUN cat /root/java_bashrc.txt >> /root/.bashrc && \
    cat -n /root/.bashrc | tail -3

ADD 99_Utility/*.sh /root/
RUN chmod +x /root/*.sh
