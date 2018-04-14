import sys
input = sys.stdin.readline
N = int(input())
l=[]
for i in range(N):
    l.append((int(input()),i))
r=0
l2=sorted(l,key=lambda e: e[0])
for j in range(N):
    t=l2[j][1]-j
    if r<t: r=t
print(r+1)
