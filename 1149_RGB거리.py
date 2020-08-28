N = int(input())
MAP = []
DP = [[0,0,0] for i in range(N)]
for n in range(N): MAP.append(list(map(int, input().split())))
for n in range(N):
    for rgb in range(3):
        if n==0: DP[n][rgb] = MAP[n][rgb]
        else: DP[n][rgb] = min(DP[n-1][(rgb+1)%3], DP[n-1][(rgb+2)%3])+MAP[n][rgb]
print(min(DP[-1]))