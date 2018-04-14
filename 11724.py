from sys import stdin
n,m = map(int,stdin.readline().split())
l=[]

for i in range(1,n+1):
    tmp = set()
    tmp.add(i)
    l.append(tmp)

for i in range(m):
    u,v = map(int,stdin.readline().split())
    ui = [l.index(s) for s in l if u in s].pop()#u_index
    vi = [l.index(s) for s in l if v in s].pop()#v_index
    if( ui == vi ):
        continue
    else:
        l[ui] = l[ui].union(l[vi])
        l[vi].clear()
        l.remove(set())
print(len(l))
