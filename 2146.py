m = int(input())
arr = [list(map(int,input().strip().split())) for _ in range(m)]
group = [[0 for i in range(m)] for _ in range(m)]

def search(arr):
    for i in range(m):
        for j in range(m):
            if arr[i][j] ==1 and group[i][j] ==0:
                return (i,j)

qu=[]
qu.append(search(arr))
t = 0
li = qu[:]
while qu:
    t += 1
    li=qu[:]
    while li:
        tli = []
        for p in li:
            i, j = p
            group[i][j]=t
            for i_, j_ in (i+1,j),(i-1,j),(i,j+1),(i,j-1):
                
                if i_ >= 0 and i_ < m and j_ >=0 and j_ < m and arr[i_][j_] == 1 and group[i_][j_] == 0:
                    group[i_][j_] = t
                    tli.append((i_,j_))          
        li = tli[:]
    if search(arr): qu=[search(arr)]
    else: break

li = [(i//m, i%m) for i in range(m*m) if arr[i//m][i%m] == 1]
sol=[]
s=1
while li:
    s+=1
    tli = []
    for p in li:
        i, j = p
        for i_, j_ in (i+1,j),(i-1,j),(i,j+1),(i,j-1):
            if i_ >= 0 and i_ < m and j_ >=0 and j_ < m and arr[i_][j_] != 0 and group[i][j] != group[i_][j_]:
                if group[i_][j_] != 0:
                    if arr[i][j] == arr[i_][j_]:
                        sol.append(2*arr[i_][j_]-2)
                    else:
                        sol.append(2*arr[i_][j_]-3)
            if i_ >= 0 and i_ < m and j_ >=0 and j_ < m and arr[i_][j_] == 0 and group[i_][j_] == 0:
                arr[i_][j_]=s
                group[i_][j_] = group[i][j]
                tli.append((i_,j_))
    if sol:
        print(min(sol)); quit()
    li = tli[:]
