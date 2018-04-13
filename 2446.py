i = int(input())
for j in range(0,i):
    print(" "*j + "*"*((2*i-1)-(2*j)))
for k in range(1,i):
    print(" "*(i-k-1) + "*"*(2*(k+1)-1))
