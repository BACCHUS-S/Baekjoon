output=[-1]* 26
arr = input()
for i in range(len(arr)):
    x = ord(arr[i])
    if output[x-97] == -1:
        output[x-97] += (i+1)
print(' '.join(map(str,output)))
