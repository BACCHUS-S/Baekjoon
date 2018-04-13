i = int(input())
for j in range(1,i+1):
    print("*"*j+" "*((i-1)*2-((j-1)*2))+"*"*j)
for k in range(1,i):
    print("*"*(i-k)+" "*(2*k)+"*"*(i-k))
