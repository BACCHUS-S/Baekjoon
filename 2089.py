n=int(input())
if n==0:
    print(0)
else:
    x=''
    while n:
        x=str(n%2)+x
        n=(-n+(n%2))//2
    print(x)
