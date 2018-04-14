import sys
sys.setrecursionlimit(300000)
n=int(input())
par=[None]*(n+1)
Ed=[[] for i in range(n+1)]
for i in range(n-1):
    c=list(map(int, input().split()))
    Ed[c[0]].append(c[1])
    Ed[c[1]].append(c[0])
def d(c):
    for i in Ed[c]:
        if not par[i]:
            par[i]=c
            d(i)
d(1)
for i in par[2:]:
    print(i)
