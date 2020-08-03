"""
# 시간초과 CODE
def dfs(IDX, SUM, CONTI):
    global MAX
    if CONTI == 3: return
    if IDX >= N: return    
    elif IDX == N-1 and CONTI<3:
        if SUM > MAX: MAX = SUM
        return
    if CONTI < 3: dfs(IDX+1, SUM+arr[IDX+1], CONTI+1)
    dfs(IDX+2, SUM+arr[IDX+2], 1)
    
N = int(input())
arr = [-1]*(N+2)
for n in range(N): arr[n] = int(input())
MAX = float('-inf')
dfs(-1,0,0)
print(MAX)
"""
N = int(input())
arr, ans = [-1]*N, [0]*N
for n in range(N): arr[n] = int(input())
ans[0] = arr[0]
ans[1] = ans[0]+arr[1]
ans[2] = max(arr[1]+arr[2], arr[0]+arr[2])
for n in range(3,N):
    ans[n] = max(ans[n-2]+arr[n], ans[n-3]+arr[n-1]+arr[n])
print(ans)
    