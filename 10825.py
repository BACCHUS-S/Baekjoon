import sys
input = sys.stdin.readline
n=int(input())
list=[]
for _ in range(n):
    a,b,c,d=input().split()
    list.append((a,int(b),int(c),int(d)))
list.sort(key=lambda x:x[0])
list.sort(key=lambda x:x[3], reverse=True)
list.sort(key=lambda x:x[2])
list.sort(key=lambda x:x[1], reverse=True)
for a,b,c,d in list:
    print(a)
