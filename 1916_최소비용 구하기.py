import sys
from heapq import *

def Dij(start, end):
    pq = []
    heappush(pq,(0,start))
    while pq:
        print(pq)
        v,s = heappop(pq)
        if s==end: return
        if visited[s]: continue
        visited[s] = True
        for vertex, cost in graph[s]:
            newCost = cost+v
            if(not visited[vertex] and dp[vertex] > newCost):
                dp[vertex] = newCost
                heappush(pq,(newCost,vertex))

N = int(input())
M = int(input())
input = sys.stdin.readline
graph=[[] for i in range(N+1)]
visited=[False]*(N+1)
inf = float('inf')
dp = [inf]*(N+1)
for m in range(M):
    s, e, v = map(int,input().split())
    graph[s].append([e,v])
start,end = map(int,input().split())
Dij(start, end)
print(dp[end])

