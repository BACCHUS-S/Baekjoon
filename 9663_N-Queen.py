N = int(input())
S = [0]*(N+1)
ans = 0
def dfs(cnt):
    global ans
    if cnt > N: ans += 1
    else:
        for i in range(1,N+1):
            S[cnt] = i
            if check(cnt): dfs(cnt+1)
def check(x):
    for i in range(1,x):
        if S[x] == S[i] or abs(S[x]-S[i]) == x-i: return False
    return True
dfs(1)
print(ans)
"""
n = int(input())
s = [0 for i in range(n+1)]
result = 0
def isTrue(x):
    for i in range(1, x):
        if s[x] == s[i] or abs(s[x] - s[i]) == x - i:
            return False
    return True
def dfs(cnt):
    global result
    if cnt > n:
        result += 1
    else:
        for i in range(1, n + 1):
            s[cnt] = i
            if isTrue(cnt):
                dfs(cnt + 1)
dfs(1)
print(result)
"""