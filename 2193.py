n = int(input())
dp = []

dp.append(0)
dp.append(1)

for x in range(2, n+1):
    dp.append(dp[x-1]+dp[x-2])

print(dp[n])
