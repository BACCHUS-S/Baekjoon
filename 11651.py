import sys
input = sys.stdin.readline
n=int(input())
list=[]
for _ in range(n):
    a,b=map(int, input().split())
    list.append((a,b))
list.sort(key=lambda x:x[0])
list.sort(key=lambda x:x[1])
for a,b in list:
    print(a,b)
