def maxDeep(root,curDeep,visit):
    ret = (root,curDeep)
    visit[root] = 1
    for n,dis in node[root]:
        if visit[n]: continue
        tmp = maxDeep(n,curDeep+dis,visit)
        if tmp[1] > ret[1] : ret = tmp
    return ret

m = int(input())

node = [[] for _ in range(m)]
for _ in range(m):
    tmp = list(map(int,input().split()))[:-1]
    curNode = tmp.pop(0)-1
    while(tmp): node[curNode].append((tmp.pop(0)-1,tmp.pop(0)))

print(maxDeep(maxDeep(0,0,[0]*m)[0],0,[0]*m)[1])
