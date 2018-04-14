def gcd(x,y):
    while y:
        tmp=y
        y=x%y
        x=tmp
    return x
sum=0
n=int(input())
for _ in range(n):
    arr=list(map(int,input().split()))
    for i in range(1, arr[0]+1):
        for j in range(i+1,arr[0]+1):
            sum += gcd(arr[i],arr[j])
    print(sum)
    sum=0
