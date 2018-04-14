code=input()
n=len(code)
code=' '+code
d=[0]*(n+1)
d[0]=1

for i in range(1,n+1):
    if 1<=int(code[i])<=9:
        d[i]=(d[i]+d[i-1])%1000000
    if i==1: continue
    if code[i-1]=="0": continue
    if 10<=int(code[i-1:i+1])<=26:
        d[i]=(d[i]+d[i-2])%1000000

print (d[n])
