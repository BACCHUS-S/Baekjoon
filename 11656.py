arr = list(input())
dic=[]
n = len(arr)
for i in range(n):
    dic.append(arr[i:])
dic.sort()
for m in dic:
    print(''.join(m))
