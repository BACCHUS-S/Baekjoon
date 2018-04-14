m,n = map(int, input().split())
ans=[0,0] + [1] *(n-1)
for i in range(2, int(n**0.5) + 1):
    if ans[i]:
        for j in range(i, n//i + 1):
            ans[i*j] = 0
print(*[str(i) for i in range(m,n+1) if ans[i] == 1])
