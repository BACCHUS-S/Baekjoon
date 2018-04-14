m,n = map(int, input().split())
arr = [list(map(int, input().strip().split())) for _ in range(n)]
t = 0
li = [(i//m, i%m) for i in range(n*m) if arr[i//m][i%m] == 1]
while li:
    tli = []
    for p in li:
        i, j = p
        for i_, j_ in (i+1,j),(i-1,j),(i,j+1),(i,j-1):
            if i_ >= 0 and i_ < n and j_ >=0 and j_<m and arr[i_][j_] ==0:
                arr[i_][j_] = 1
                tli.append((i_,j_))
    li = tli[:]
    t += 1
sum=0
for x in arr:
    sum += x.count(0)
if sum: print(-1)
else: print(t-1)
