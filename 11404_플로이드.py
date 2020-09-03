import sys
N = int(input())
M = int(input())
MAX = 100000 * N
DIST = [[MAX]*N for n in range(N)]
for m in range(M):
    start, end, cost = map(int, sys.stdin.readline().split())
    DIST[start-1][end-1] = min(DIST[start-1][end-1], cost)

for k in range(N):
    for start in range(N):
        for end in range(N):
            if start != end: DIST[start][end] = min(DIST[start][end], DIST[start][k]+DIST[k][end])
for item in DIST: print(' '.join('0' if x==MAX else str(x) for x in item))
'''
for start in range(N):
    for end in range(N):
        for temp in range(N):
            if(DIST[start][temp] !=0 and DIST[temp][end]!=0 and temp != start and temp != end and start!=end):
                DIST[start][end] = min(DIST[start][end], DIST[start][temp]+DIST[temp][end])
'''

