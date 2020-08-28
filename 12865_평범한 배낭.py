N,K = map(int,input().split())
SACK = [list(map(int,input().split())) for i in range(N)]
DP = [0]*(K+1)
print(SACK)
for n in range(N):
    for k in range(K,1,-1):
        if k >= SACK[n][0]:  DP[k] = max(DP[k], DP[k-SACK[n][0]]+SACK[n][1])