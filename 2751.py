from sys import stdin
a=[]
n=int(stdin.readline())
for x in range(n):
    a.append(int(stdin.readline()))
a.sort()
for x in range(0,n):
    print (a[x])
