import sys
input = sys.stdin.readline
list=[0 for _ in range(10001)]
for _ in range(int(input())):
    list[int(int(input()))] += 1
for _ in range(10001):
    if list[_]:
         print('%s\n'%_*list[_],end='')
