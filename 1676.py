n=int(input())
def cal(x,r):
    if x==0:
        return 0
    return cal(x//r,r)+x//r
print(cal(n,5))
