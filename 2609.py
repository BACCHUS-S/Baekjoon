a,b=map(int,input().split())
t=0
def gcd(x,y):
    if y==0:
        global t
        t=x
        return
    gcd(y,x%y)
gcd(a,b)
print(t)
print(a*b//t)
