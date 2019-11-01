FROM ubuntu:16.04

RUN apt-get update
RUN apt-get -y install software-properties-common \
    vim \
    tree \
    openssh-server \
    net-tools \
    iputils-ping \
    && rm -rf /var/lib/apt/lists/*

RUN sed -i 's/#PasswordAuthentication yes/PasswordAuthentication no/' /etc/ssh/sshd_config
RUN cat -n /etc/ssh/sshd_config | head -52 | tail -2

RUN service ssh start && \
    ssh-keygen -q -t rsa -N '' -f /root/.ssh/id_rsa && \
    cd /root/.ssh/ && \
    cp id_rsa.pub authorized_keys && \
    chmod 600 authorized_keys && \
    touch /root/.ssh/known_hosts && \
    ssh-keyscan -t rsa localhost >> /root/.ssh/known_hosts && \
    chmod 600 known_hosts && \
    ls -als /root/.ssh && \
    service ssh stop

ADD 99_Utility/01_start_ssh.sh /root/
ADD 99_Utility/02_stop_ssh.sh /root/

RUN chmod +x /root/*.sh

WORKDIR /root
