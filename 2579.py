a=[]
for _ in range(int(input())):
    a.append(int(input()))

dp = [0 for _ in range(len(a))]
dp[0] = a[0]; dp[1] = a[0] + a[1]; dp[2] = max(a[0], a[1])+a[2]
for i in range(3,len(a)):
    dp[i] = max(dp[i-3]+a[i]+a[i-1], a[i]+dp[i-2])
print(dp[-1])
