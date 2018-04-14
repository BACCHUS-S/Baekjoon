def dfs(y):
    visited = [0 for i in range(10002)]
    s = [[y,0]]
    visited[y] = 1
    max_weight,node = 0,1
    while s:
        p = s.pop()
        if max_weight < p[1]:
            max_weight = p[1]
            node = p[0]
        for i in range(len(v[p[0]])):
            t = v[p[0]][i]
            if visited[t[0]] == 0:
                visited[t[0]] = 1
                s.append([t[0], t[1]+p[1]])
    return [node, max_weight] # node = 노드번호, max_weight = 노드 y 부터 노드 node까지의 거리

n = int(input())
v = [[] for i in range(n+1)]
for k in range(n-1):
    p,s,w = map(int, input().split())
    v[p].append([s,w])
    v[s].append([p,w])
print (dfs(dfs(1)[0])[1])
