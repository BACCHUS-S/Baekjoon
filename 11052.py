from sys import stdin
write = stdin.readline
n = int(input())
l = list(map(int, write().split()))
#l.insert(0, 0)

result = [0 for _ in range(n+1)] # or dp=[0]*(n+1) 
for i in range(1, n+1):
    for j in range(i):
        result[i] = max(result[i], result[i-j-1]+l[j])

print(result[n])
