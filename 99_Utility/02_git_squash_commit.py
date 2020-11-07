import argparse
import glob
import os
import subprocess
from io import StringIO

import pandas as pd


class Rename():
    def __init__(self, field_num):
        self.commit_num = field_num

    def do(self):
        # 1st find *-Study/ folder
        cwd = os.getcwd()
        if cwd.endswith('99_Utility'):
            study_path = glob.glob(cwd + '/../')
        elif cwd.endswith('-study'):
            study_path = glob.glob(cwd + '/')
        elif cwd.endswith('-work'):
            study_path = glob.glob(cwd + '/')
        else:
            raise NameError("Can't find *-Study folder path")
        print('\n# 1t find *-Study/ folder')
        print(study_path[0])

        # 2nd git log -n 2
        cmd = "cd " + study_path[0]
        cmd += " && /home/linuxbrew/.linuxbrew/bin/"
        cmd += "git log -n " + str(self.commit_num) + " "
        cmd += "--format=\"%p,%h,%s\" | awk 'BEGIN{FS=\" ```\"; OFS=\",\"} {print $1}'"
        update_str = subprocess.check_output(args=cmd, universal_newlines=True, shell=True)
        print('\n# 2nd git log -n ' + str(self.commit_num))
        print(update_str)

        # 3rd convert string to dataframe
        update_str = "parentHash,myHash,branch\n" + update_str
        df = pd.read_csv(StringIO(update_str), sep=",")
        print('\n# 3rd convert string to dataframe')
        print(df)

        # 4th check git commit count
        if self.commit_num == len(df):
            print('\n# 4th check git commit count')
        else:
            raise NameError("git commit count != df.count")

        # 5th check parent-child commit
        print('\n# 5th check parent-child commit')
        for i in range(self.commit_num - 1):
            if df.iloc[i]['parentHash'] != df.iloc[i + 1]['myHash']:
                raise NameError('parent-child commit is broken')
            else:
                print('commit ' + str(i) + "'s parent is commit " + str(i + 1))

        # 6th check branch name
        print('\n# 6th check branch name')
        target_branch = df.iloc[0]['branch']
        if target_branch == 'master':
            raise NameError('target_branch can not be master')
        for i in range(1, self.commit_num):
            my_branch = df.iloc[i]['branch']
            if target_branch != my_branch:
                raise NameError('target_branch and my_branch should be same')
            if my_branch == 'master':
                raise NameError('my_branch cat not be master')
            print('branch ' + str(i) + "'s name is same with " + target_branch)

        # 7th git reset --soft HEAD^ & git status
        print('\n# 7th git reset --soft HEAD^ && git status')
        cmd = "cd " + study_path[0]
        cmd += " && /home/linuxbrew/.linuxbrew/bin/git reset --soft HEAD^ && /home/linuxbrew/.linuxbrew/bin/git status"
        for i in range(self.commit_num):
            update_str = subprocess.check_output(args=cmd, universal_newlines=True, shell=True)
            print('# 7th ' + str(i + 1) + ' : git reset --soft HEAD^ && git status')
            print(update_str)


if __name__ == "__main__":
    p = argparse.ArgumentParser("git squash commits")
    p.add_argument('COMMIT_NUM', type=int, metavar='Commit_Number')

    args = p.parse_args()
    commit_num = args.COMMIT_NUM

    r = Rename(commit_num)
    r.do()
