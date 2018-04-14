n = int(input())
glass=[int(input()) for _ in range(n)]

dp=[0] * n
dp[0] = glass[0]
if n == 1:
    print(dp[0])
else:
    dp[1] = glass[1]+glass[0]

    for _ in range(2, n):
        dp[_]=max(dp[_-1], dp[_-2]+glass[_], dp[_-3]+glass[_]+glass[_-1])
    print(dp[n-1])
