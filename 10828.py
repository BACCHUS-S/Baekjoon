def push(s, n):
    s.append(n)
def top(s):
    if len(s) == 0:
        print(-1)
    else:
        print(s[-1])
def size(s):
    print(len(s))
def empty(s):
    if len(s) == 0:
        print(1)
    else:
        print(0)
def pop(s):
    if len(s) == 0:
        print(-1)
    else:
        print(s.pop())
    
    
n = int(input())
arr=[]
for _ in range(n):
    strr = input().split()
    if strr[0] == 'top':
        top(arr)
    elif strr[0] == 'size':
        size(arr)
    elif strr[0] == 'pop':
        pop(arr)
    elif strr[0] =='empty':
        empty(arr)
    else:
        push(arr,strr[1])
