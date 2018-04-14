a,b=map(int,input().split())
n=int(input())
arr=list(map(int,input().split()))
sum=0
i=0
arr.reverse()
for x in arr:
    sum += x*(a**i); i+=1
s=''
while sum:
    s=str(sum%b)+' '+s
    sum=sum//b
print(s)
