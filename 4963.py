from sys import setrecursionlimit as src
src(10000)
def maze(m,k):
    global size
    if table[m][k]==0: return
    table[m][k]=0
    for z in range(8):
        if 0<=m+matrix_i[z]<a and 0<=k+matrix_j[z]<b:
            maze(m+matrix_i[z],k+matrix_j[z])
matrix_i=(0,0,1,-1,1,-1,1,-1)
matrix_j=(1,-1,0,0,1,1,-1,-1)
sol=[]
while True:
    b, a = map(int,input().split())
    if not a and not b: break
    table=[[int(x) for x in input().split()]for y in range(a)]
    size = 0
    for i in range(a):
        for j in range(b):
            if table[i][j]==1:
                size += 1
                maze(i,j)
    print(size)
