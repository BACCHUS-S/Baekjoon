import sys; sys.setrecursionlimit(10000)
from sys import stdin

def dfs(x):
    if check[x]: return
    check[x] = True
    dfs(int(inputlist[x])-1)

for _ in range(int(input())):
    
    n = int(input())
    check = [False]*n
    inputlist = list(stdin.readline().split())
    ans = 0

    for _ in range(n):
        if check[_] == False:
            dfs(_)
            ans += 1
    print(ans)
