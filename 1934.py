n=int(input())
def gcd(x,y):
    while y:
        tmp=y
        y=x%y
        x=tmp
    return x
for _ in range(n):
    a,b=map(int,input().split())
    print(a*b//gcd(a,b))
