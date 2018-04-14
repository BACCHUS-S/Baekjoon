import sys
ans=[0,0]+[1]*(999999)
for i in range(2, int(1000000**0.5)+1):
    if ans[i]:
        for j in range(i, 1000000//i+1):
            ans[i*j] = 0
while True:
    n = int(sys.stdin.readline())
    if not n: break                
    for i in range(2,n//2+1):
        if (ans[i] and ans[n-i]):
            break
    print('%d = %d + %d' % (n, i, n-i))
