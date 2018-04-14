n,m=list(map(int,input().split()))
def cal(x,r):
    if x==0:
        return 0
    return cal(x//r,r)+x//r
v=cal(n,5)-cal(m,5)-cal(n-m,5)
r=cal(n,2)-cal(m,2)-cal(n-m,2)
print(min(v,r))
