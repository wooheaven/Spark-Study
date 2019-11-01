FROM ubuntu:16.04_1st_ssh

RUN mkdir /usr/lib/jvm
ADD jdk-8u221-linux-x64.tar.gz /usr/lib/jvm
RUN ls -als /usr/lib/jvm

RUN echo "" >> ~/.bashrc && \
    echo "# JAVA" >> ~/.bashrc && \
    echo "JAVA_HOME=/usr/lib/jvm/jdk1.8.0_221" >> ~/.bashrc && \
    echo "PATH=\$PATH:\$JAVA_HOME/bin" >> ~/.bashrc && \
    cat -n ~/.bashrc | tail -3
