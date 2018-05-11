import sys
import csv
import pandas as pd

fileName = sys.argv[1]
targetLineNum = int(sys.argv[2])-1
targetColumnNum = int(sys.argv[3])-1

def get2DListFromFile(fileName):
    # read markdown table as 2D-List
    matrix = []
    with open(fileName, "r", newline="") as fp:
        reader = csv.reader(fp, delimiter="|")
        matrix = [x for x in reader]
    return matrix

def getColumnAsStringFromMatrix(matrix, targetLineNum, targetLineColumnNum):
    # print 2D-List with targetLineNum, targetColumnNum
    outputStr = ""
    for i,row in enumerate(matrix):
        if (i == targetLineNum):
            for j,column in enumerate(row):
                if (j == targetColumnNum+1):
                    print(i+1, j, '|' + column + '|', sep="\t")
                    outputStr = column
    return outputStr

def addSpaceStrAtLast(comparedStr, targetStr):
    while ( len(comparedStr) > len(targetStr) ):
        #printColumnStr(comparedStr)
        #printColumnStr(targetStr)
        targetStr += " "
    return targetStr

def printColumnStr(str):
    print('|' + str + '|')

def replaceTargetColumnStr(matrix, targetLineNum, targetColumnNum, targetColumnStr):
    #printColumnStr(matrix[targetLineNum+1][targetColumnNum+1])
    #printColumnStr(targetColumnStr)
    
    matrix[targetLineNum][targetColumnNum+1] = targetColumnStr
    
    #printColumnStr(matrix[targetLineNum+1][targetColumnNum+1])
    #printColumnStr(targetColumnStr)
    return matrix

matrix = get2DListFromFile(fileName)

comparedColumnStr = getColumnAsStringFromMatrix(matrix, targetLineNum-1, targetColumnNum)
targetColumnStr = getColumnAsStringFromMatrix(matrix, targetLineNum, targetColumnNum)

targetColumnStr = addSpaceStrAtLast(comparedColumnStr, targetColumnStr)

#printColumnStr(comparedColumnStr)
#printColumnStr(targetColumnStr)

matrix = replaceTargetColumnStr(matrix, targetLineNum, targetColumnNum, targetColumnStr)

#for row in matrix:
#    print(row)

with open(fileName, "w", newline="") as f:
    writer = csv.writer(f, delimiter="|")
    writer.writerows(matrix)
