for _ in range(int(input())):
    strr = list(input())
    counta = countb =0; end=False
    for _ in range(len(strr)):
        if strr[_] == '(':
            counta += 1
        elif strr[_] == ')':
            countb += 1
        if counta < countb:
            end = True
            print('NO')
            break
    if counta == countb and end==False:
        print('YES')
    elif end==False:
        print('NO')
