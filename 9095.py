from sys import stdin
n = int(stdin.readline())


for j in range(n):
    m = int(stdin.readline())
    dp=[1,1,2]
    for i in range(3, m+1):
        dp.append(dp[i-1] + dp[i-2] + dp[i-3])
    print(dp[m])
