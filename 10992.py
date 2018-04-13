i = int(input())
for j in range(1,i+1):
    if j == 1:
        print(" "*(i-j) + "*"*j)
    elif j != i:
        print(" "*(i-j) + "*" + " "*(((j-1)*2)-1) + "*")
    else :
        print("*"*(2*j-1))
