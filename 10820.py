while True:
    arr = input()
    if arr=="":
        break
    output=[0]*4
    for i in range(len(arr)):
        x = ord(arr[i])
        if x==32:
            output[3] +=1
        elif x>=97 and x <= 122:
            output[0] +=1
        elif x>= 65 and x<= 90:
            output[1] +=1
        elif x>= 48 and x <=57:
            output[2] +=1
    print(' '.join(map(str,output))) 
