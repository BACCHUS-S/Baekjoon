import sys
M,N = map(int,input().split())
input = sys.stdin.readline
d = dict()
for _ in range(M):
    l = list(map(int,input().split()))
    temp = tuple(sorted(range(N), key=l.__getitem__))
    print(temp)
    d[temp] = d.get(temp, 0)+1
ans = 0
for v in d.values():
    if v>1: ans += v*(v-1)//2
print(str(ans))
"""
import sys

M,N = map(int,input().split())
input = sys.stdin.readline
PLANET = [list(map(int,input().split())) for i in range(M)]
COMPRESSION = []
ANS = 0
for item in PLANET:
    dict = {}
    for idx,item2 in enumerate(sorted(set(item))): dict[item2] = idx
    COMPRESSION.append([dict[x] for x in item])
COMPRESSION = sorted(COMPRESSION)
pre = COMPRESSION[0]
CNT = 0
for item in COMPRESSION:
    if pre == item: CNT+=1
    else:
        if CNT!=1: ANS+=(CNT*(CNT-1)//2)
        CNT = 1
    pre = item
if CNT!=1: ANS+=(CNT*(CNT-1)//2)
print(ANS)
"""