n = int(input())
a = list(map(int, input().split()))

dp = [1 for _ in range(n+1)]
dp2 = [1 for _ in range(n+1)]

for i in range(n):
    for j in range(i+1, n):
        if a[i] < a[j]:
            dp[j] = max(dp[j], dp[i]+1)

for i in range(n-1, -1, -1):
    for j in range(i-1, -1, -1):
        if a[i] < a[j]:
            dp2[j] = max(dp2[j], dp2[i]+1)

print(max(dp[i] + dp2[i]-1 for i in range(n)))
