import argparse
import glob
import os


class Rename():
    def __init__(self, path):
        self.path = path[0:-1] if path.endswith('/') else path

    def do(self):
        # find glob_list for path
        glob_list = glob.glob(self.path + '/*.*')

        # find file_list for glob_list
        file_list = list()
        for idx, file in enumerate(glob_list):
            if os.path.exists(file) and os.path.isfile(file):
                file_list.append(file)

        # divide parent, now_name, new_name
        for idx, file in enumerate(file_list):
            now_name = file[::-1][0:file[::-1].index('/')][::-1]
            new_name = now_name[now_name.index('_') + 1:]
            parent = file[0:len(file)-len(now_name)]
            file_list[idx] = [parent, now_name, new_name]

        # sort file_list
        file_list.sort(key=lambda x: (self.convert_str(x[2]), self.convert_str(x[1])))

        # 1 <= file_list's size <= 9
        size = len(str(len(file_list)))
        if size == 1:
            size = size + 1

        # add sorted number to new_name
        for idx, file in enumerate(file_list):
            new_name = self.modify_number(size, idx) + '_' + file[2]
            file_list[idx] = [file[0], file[1], new_name]

        # git-move.sh
        with open('git-move.sh', 'w') as f:
            f.writelines('#!/usr/bin/env bash\n')
            f.writelines('\n')
            for file in file_list:
                pre_str = 'git mv '
                if file[1] == file[2]:
                    pre_str = "# " + pre_str
                f.writelines(pre_str + file[0] + file[1] + ' ' + file[0] + file[2] + '\n')
        os.chmod('git-move.sh', 0o755)

    def modify_number(self, size, number):
        str_num = str(number + 1)
        while size > len(str_num):
            str_num = '0' + str_num
        return str_num

    def convert_str(self, path):
        path = str(path).replace('--', '-')
        path = path.replace('_', '-')
        path = path.replace('.md', '-')
        return path


if __name__ == "__main__":
    p = argparse.ArgumentParser("Path")
    p.add_argument('PATH', type=str, metavar='Target_Path')

    args = p.parse_args()
    path = args.PATH

    r = Rename(path)
    r.do()
