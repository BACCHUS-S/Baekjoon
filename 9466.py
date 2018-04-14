T=int(input())
for t in range(T):
    n=int(input())
    L=[None]+list(map(int,input().split()))
    visited=[False]*(n+1)
    alone=[]
    for start in range(1,n+1):
        if visited[start]:
            continue
        v=start
        while not visited[v]:
            visited[v]=True
            v=L[v]
        w=start
        while w!=v:
            alone.append(w)
            w=L[w]
    print(len(alone))
