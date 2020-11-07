```
$ ./01_docker_build.sh 
$ ./02_docker_run.sh 

root@be6c6e423c41:~# pwd
/root

root@be6c6e423c41:~# ll
total 92
drwx------ 1 root root 4096 Nov  7 20:39 ./
drwxr-xr-x 1 root root 4096 Nov  7 20:40 ../
-rw-r--r-- 1 root root 3829 Nov  7 20:37 .bashrc
drwx------ 2 root root 4096 Nov  7 20:35 .cache/
-rw-r--r-- 1 root root  148 Aug 17  2015 .profile
drwx------ 2 root root 4096 Nov  7 20:30 .ssh/
-rwxr-xr-x 1 root root   58 Dec 20  2019 01_start_all.sh*
-rwxr-xr-x 1 root root   55 Dec 20  2019 02_stop_all.sh*
-rwxr-xr-x 1 root root   36 May 20 10:20 03_status.sh*
-rwxr-xr-x 1 root root  256 May 21 02:51 04_check_hdfs_safemode.sh*
-rwxr-xr-x 1 root root   31 Dec 20  2019 10_start_ssh.sh*
-rwxr-xr-x 1 root root   26 Dec 20  2019 11_start_dfs.sh*
-rwxr-xr-x 1 root root   27 Dec 20  2019 12_start_yarn.sh*
-rwxr-xr-x 1 root root   57 Dec 20  2019 13_start_mr_history.sh*
-rwxr-xr-x 1 root root   37 Dec 20  2019 14_start_spark_history.sh*
-rwxr-xr-x 1 root root   30 Dec 20  2019 20_stop_ssh.sh*
-rwxr-xr-x 1 root root   25 Dec 20  2019 21_stop_dfs.sh*
-rwxr-xr-x 1 root root   26 Dec 20  2019 22_stop_yarn.sh*
-rwxr-xr-x 1 root root   56 Dec 20  2019 23_stop_mr_history.sh*
-rwxr-xr-x 1 root root   36 Dec 20  2019 24_stop_spark_history.sh*
-rw-r--r-- 1 root root  509 Dec 20  2019 hadoop_bashrc.txt
-rw-r--r-- 1 root root   95 Nov  7 19:43 java_bashrc.txt
-rw-r--r-- 1 root root  119 Dec 20  2019 spark_bashrc.txt

root@ea68df50e36a:~# ./01_start_all.sh
root@ea68df50e36a:~# ./02_stop_all.sh
```
