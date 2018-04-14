from sys import stdin

s1 = list(stdin.readline().rstrip())
s2 = []
n = int(stdin.readline())

for i in range(n):
    command = stdin.readline()
    if command[0] == 'P':
        s1.append(command[2])
    elif command[0] == 'L':
        if len(s1) != 0:
            s2.append(s1.pop())
    elif command[0] == 'D':
        if len(s2) != 0:
            s1.append(s2.pop())
    elif command[0] == 'B':
        if len(s1) != 0:
            s1.pop()
    else:
        pass

s2.reverse()
print(''.join(s1+s2))
