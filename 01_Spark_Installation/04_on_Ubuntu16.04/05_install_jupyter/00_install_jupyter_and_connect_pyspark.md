```
$ ./01_docker_build.sh

$ ./02_docker_run.sh 

root@306d4be2ae7c:~# ll
total 76
drwx------ 1 root root 4096 Nov  1 07:14 ./
drwxr-xr-x 1 root root 4096 Nov  1 07:17 ../
-rw-r--r-- 1 root root 3896 Nov  1 07:14 .bashrc
drwx------ 1 root root 4096 Nov  1 07:13 .cache/
-rw-r--r-- 1 root root  148 Aug 17  2015 .profile
drwx------ 2 root root 4096 Nov  1 04:32 .ssh/
-rwxrwxr-x 1 root root   31 Nov  1 04:09 01_start_ssh.sh*
-rwxrwxr-x 1 root root   30 Nov  1 04:26 02_stop_ssh.sh*
-rwxrwxr-x 1 root root   26 Nov  1 04:45 10_start_dfs.sh*
-rwxrwxr-x 1 root root   25 Nov  1 04:46 11_stop_dfs.sh*
-rwxrwxr-x 1 root root   27 Nov  1 04:47 12_start_yarn.sh*
-rwxrwxr-x 1 root root   26 Nov  1 04:48 13_stop_yarn.sh*
-rwxrwxr-x 1 root root   57 Nov  1 04:49 14_start_mr_history.sh*
-rwxrwxr-x 1 root root   56 Nov  1 04:49 15_stop_mr_history.sh*
-rwxrwxr-x 1 root root   37 Nov  1 06:54 22_start_spark_history.sh*
-rwxrwxr-x 1 root root   36 Nov  1 06:54 23_stop_spark_history.sh*
-rwxrwxr-x 1 root root  132 Nov  1 03:41 30_jupyter_notebook.sh*
-rw-rw-r-- 1 root root  509 Nov  1 05:36 hadoop_bashrc.txt
-rw-rw-r-- 1 root root  119 Nov  1 06:59 spark_bashrc.txt

root@306d4be2ae7c:~# ./01_start_ssh.sh
root@306d4be2ae7c:~# ./10_start_dfs.sh
root@306d4be2ae7c:~# ./12_start_yarn.sh
root@306d4be2ae7c:~# ./22_start_spark_history.sh
root@306d4be2ae7c:~# ./30_jupyter_notebook.sh 
```
