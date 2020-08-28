from itertools import combinations
N,M = map(int,input().split())
L = range(1,N+1)
for item in combinations(L,M):
    print(' '.join(str(x) for x in item))