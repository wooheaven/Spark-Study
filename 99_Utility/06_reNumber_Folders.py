import argparse
import glob
import os


class Rename():
    def __init__(self, path):
        if path[:-1].endswith('/'):
            self.path = path[0:-1]
        else:
            self.path = path

    def do(self):
        # find glob_list for path
        glob_list = glob.glob(self.path + '/*/')

        # find folder_list for glob_list
        folder_list = list()
        for idx, folder in enumerate(glob_list):
            if os.path.exists(folder) and os.path.isdir(folder):
                folder_list.append(folder)

        # divide parent, now_name, new_name
        for idx, folder in enumerate(folder_list):
            now_name = self.get_now_name(folder)
            new_name = now_name[now_name.index('_') + 1:]
            parent = folder[0:len(folder)-len(now_name)-1]
            folder_list[idx] = [parent, now_name, new_name]

        # sort file_list
        folder_list.sort(key=lambda x: (self.convert_str(x[2]), self.convert_str(x[1])))

        # 1 <= file_list's size <= 9
        size = len(str(len(folder_list)))
        if size == 1:
            size = size + 1

        # add sorted number to new_name
        for idx, folder in enumerate(folder_list):
            new_name = self.modify_number(size, idx) + '_' + folder[2]
            folder_list[idx] = [folder[0], folder[1], new_name]

        # git-move.sh
        with open('git-move.sh', 'w') as f:
            f.writelines('#!/usr/bin/env bash\n')
            f.writelines('\n')
            for folder in folder_list:
                pre_str = 'git mv '
                if folder[1] == folder[2]:
                    pre_str = "# " + pre_str
                f.writelines(pre_str + folder[0] + folder[1] + ' ' + folder[0] + folder[2] + '\n')
        os.chmod('git-move.sh', 0o755)

    def convert_str(self, path):
        path = path.lower()
        return path

    def modify_number(self, size, number):
        str_num = str(number + 1)
        while size > len(str_num):
            str_num = '0' + str_num
        return str_num

    def get_now_name(self, folder):
        now_name = folder[::-1]
        now_name = now_name.replace('/', '', 1)
        now_name = now_name[0:now_name.index('/')]
        return now_name[::-1]


if __name__ == "__main__":
    p = argparse.ArgumentParser("Path")
    p.add_argument('PATH', type=str, metavar='Target_Path')

    args = p.parse_args()
    path = args.PATH

    r = Rename(path)
    r.do()