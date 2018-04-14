n=int(input())
table=[[int(x) for x in input()]for y in range(n)]

def maze(m,k):
    global size
    if table[m][k]==0: return
    size+=1
    table[m][k]=0
    for x in range(4):
        if 0<=m+matrix_i[x]<n and 0<=k+matrix_j[x]<n:
            maze(m+matrix_i[x],k+matrix_j[x])
           
matrix_i=(0,0,1,-1)
matrix_j=(1,-1,0,0)
sol=[]

for i in range(n):
    for j in range(n):
        size=0
        if table[i][j]==1:
            maze(i,j)
            sol.append(size)
sol.sort()
print(len(sol))
for i in sol: print(i)
