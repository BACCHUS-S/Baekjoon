from sys import stdin

out =[]

for _ in range(int(input())):
    com = list(stdin.readline().split())
    if com[0] == 'push_back':
        out.append(com[1])
    elif com[0] == 'push_front':
        out.insert(0,com[1])
    elif com[0] == 'pop_front':
        if out: print(out.pop(0))
        else: print(-1)
    elif com[0] == 'pop_back':
        if out: print(out.pop())
        else: print(-1)
    elif com[0] == 'size':
        print(len(out))
    elif com[0] == 'empty':
        print(1-int(bool(out)))
    elif com[0] == 'front':
        if out: print(out[0])
        else: print(-1)
    elif com[0] == 'back':
        if out: print(out[-1])
        else: print(-1)
