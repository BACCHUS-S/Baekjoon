strr = list(input())
stick = 0; rod=0
for _ in range(len(strr)):
    if strr[_] == '(':
        stick += 1
    elif strr[_] == ')':
        stick -= 1
        if strr[_-1] =='(':
            rod += stick
        elif strr[_-1] == ')':
            rod += 1
print(rod)
