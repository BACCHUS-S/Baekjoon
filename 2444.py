i = int(input())
for j in range(1,i+1):
    print(" "*(i-j)+"*"*(j*2-1))
for k in range(1,i):
    print(" "*k+"*"*(i*2-1-(2*k)))
