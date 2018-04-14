n = int(input())
dp=[0]*10000000
dp[1] = dp[2] = dp[3] = 1; dp[4] = dp[5] = 2
for _ in range(n):
    k = int(input())
    if k <= 5:
        print(dp[k])
    else:
        for _ in range(6, k+1):
            dp[_] = dp[_-1] + dp[_-5]
        print(dp[k]) 
