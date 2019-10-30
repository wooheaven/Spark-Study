import os
import glob
import re
import argparse


class Rename():
    def __init__(self, field_num, start_num, end_num, diff_num):
        self.field_num = field_num
        self.start_num = start_num
        self.end_num = end_num
        self.diff_num = diff_num

    def do(self):
        # find READMD.md
        cwd = os.getcwd()
        if cwd.endswith('99_Utility'):
            readme_path = glob.glob(cwd + '/../README.md')
        elif cwd.endswith('-Study'):
            readme_path = glob.glob(cwd + '/README.md')
            print(readme_path)
        else:
            raise NameError("Can't find README.md")

        # read lines
        with open(file=readme_path[0], mode='r') as f_in:
            lines = f_in.read().splitlines()

        # create head_numbers by read lines from start_num to end_num
        head_numbers = {}
        for i, line in enumerate(lines):
            if self.start_num <= i+1 <= self.end_num:
                head_numbers[i+1] = {'line': line}

        # find field_num, head_num of head_numbers
        print('Read head_numbers')
        for key, value in sorted(head_numbers.items()):
            tmp_field_num = 0
            tmp = str(value.get('line'))
            while not re.match('^[0-9]+$', tmp[0]):
                if re.match('╠═', tmp):
                    tmp = re.sub(r'╠═', '', tmp, count=1)
                    tmp_field_num += 1
                if re.match('╚═', tmp):
                    tmp = re.sub(r'╚═', '', tmp, count=1)
                    tmp_field_num += 1
                if re.match('║░', tmp):
                    tmp = re.sub(r'║░', '', tmp, count=1)
                    tmp_field_num += 1
                if re.match('░░', tmp):
                    tmp = re.sub(r'░░', '', tmp, count=1)
                    tmp_field_num += 1
            if tmp_field_num == self.field_num:
                value['field_num'] = tmp_field_num
                value['head_num'] = tmp.split(' ')[0]
            print('key = ' + self.digits_modify(key, 2), 'field_num = ' + str(tmp_field_num),
                  'head_num = ' + str(tmp[0]), 'line = ' + str(value.get('line')), sep='\t')

        # reduce head_numbers which has not field_num
        reduce_keys = []
        for key, value in head_numbers.items():
            if 'field_num' not in value.keys():
                reduce_keys.append(key)
        for key in reduce_keys:
            head_numbers.pop(key)

        # edit lines
        print('\nEdit lines')
        for key, value in sorted(head_numbers.items()):
            new_line = value['line']
            new_line = re.sub(str(value['head_num']), str(int(value['head_num'])+self.diff_num), new_line, count=1)
            print('line number = ' + self.digits_modify(key, 2), 'old_line = ' + lines[key-1], sep='\t')
            lines[key-1] = new_line
            print('line number = ' + self.digits_modify(key, 2), 'new_line = ' + lines[key-1], sep='\t')

        # save lines
        print('\nSave lines')
        with open(file=readme_path[0], mode='w') as fw:
            for line in lines:
                fw.write("%s\n" % line)

    def digits_modify(self, key, digit):
        key = str(key)
        while len(key) < digit:
            key = '0' + key
        return key


if __name__ == "__main__":
    p = argparse.ArgumentParser("modify number of head on READMD.md")
    p.add_argument('FIELD_NUM', type=int, metavar='Field_Number')
    p.add_argument('START_NUM', type=int, metavar='Start_Number')
    p.add_argument('END_NUM', type=int, metavar='End_Number')
    p.add_argument('DIFF_NUM', type=int, metavar='Diff_Number')

    args = p.parse_args()
    field_num = args.FIELD_NUM
    start_num = args.START_NUM
    end_num = args.END_NUM
    diff_num = args.DIFF_NUM

    r = Rename(field_num, start_num, end_num, diff_num)
    r.do()

