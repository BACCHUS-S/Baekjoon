from sys import stdin
a, b, c = map(int, stdin.readline().split())
graph = [[] for _ in range(a+1)]
dfs_c, bfs_c = [False] * (a+1), [False] * (a+1)

for _ in range(b):
    n, m = map(int, stdin.readline().split())
    graph[n].append(m)
    graph[m].append(n)

for _ in range(a+1):
    graph[_].sort()

dfs_result = []
def dfs(graph, c):
    dfs_result.append(c)
    dfs_c[c] = True
    for t in graph[c]:
        if dfs_c[t] == False:
            dfs_c[t] = True
            dfs(graph, t)

bfs_result = []
def bfs(graph, c):
    qu = [c]
    bfs_c[c] = True
    while len(qu):
        cur = qu.pop(0)
        bfs_result.append(cur)
        for t in graph[cur]:
            if bfs_c[t] == False:
                bfs_c[t] = True
                qu.append(t)

dfs(graph, c); bfs(graph, c)

for _ in dfs_result: print(_, end=' ')
print()
for _ in bfs_result: print(_, end=' ')
