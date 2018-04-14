A,P=list(map(int,input().split()))
D=[None,A]
def Next(n):
    if n==0:
        return 0
    return Next(n//10)+(n%10)**P
while D.count(D[-1])==1:
    D.append(Next(D[-1]))
print(D.index(D[-1])-1)
