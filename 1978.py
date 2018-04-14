from math import sqrt
def cal(n):
    if n==1: return False
    for i in range(2,int(sqrt(n))+1):
        if n%i==0:
            return False
    return True      
n=int(input())
arr=list(map(int,input().split()))
sum=0
for _ in arr:
    if cal(_): sum+=1
print(sum)
