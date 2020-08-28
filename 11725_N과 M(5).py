from itertools import permutations
N,M = map(int,input().split())
L = list(map(int,input().split()))
ARR = []
for item in permutations(L,M): ARR.append(list(item))
for m in range(M-1,-1,-1):ARR = sorted(ARR, key=lambda x:x[m])
for item in ARR: print(' '.join(str(x) for x in item))