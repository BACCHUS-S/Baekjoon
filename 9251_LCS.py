from itertools import combinations
a = input(); b=input()
aL, bL = len(a), len(b)
DP = [[0]*(bL+1) for _ in range(aL+1)]
for r in range(1,aL+1):
    for c in range(1,bL+1):
        if a[r-1]==b[c-1]: DP[r][c] = DP[r-1][c-1]+1
        else: DP[r][c] = max(DP[r][c-1], DP[r-1][c])

print(DP[-1][-1])
#print(list(combinations(standard, len())))

