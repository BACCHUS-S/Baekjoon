import sys
input = sys.stdin.readline
n=int(input())
list=[]
for _ in range(n):
    a,b=input().split()
    list.append((int(a),b))
list.sort(key=lambda x:x[0])
for a,b in list:
    print(a,b)
