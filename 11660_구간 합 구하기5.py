import sys
input = sys.stdin.readline
N,M = map(int,input().split())
MAP = [list(map(int,input().split())) for i in range(N)]
DP = [[0]*(N+1) for i in range(N+1)]
PNT = [list(map(int,input().split())) for i in range(M)]
for r in range(1,N+1):
    for c in range(1,N+1):
        DP[r][c] = DP[r-1][c]+DP[r][c-1]-DP[r-1][c-1]+MAP[r-1][c-1]
for x1,y1,x2,y2 in PNT:
    print(DP[x2][y2]-DP[x1-1][y2]-DP[x2][y1-1]+DP[x1-1][y1-1])