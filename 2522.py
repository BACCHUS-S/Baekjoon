i = int(input())
for j in range(1,i+1):
    print(" "*(i-j) + "*"*j)
for k in range(1,i):
    print(" "*k + "*"*(i-k))
