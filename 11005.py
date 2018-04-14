def ch_num(x):
    if x>=10: return chr(x+55)
    else: return x
a,b = map(int,input().split())
l=[]
while a:
    l.append(a%b)
    a//=b
l.reverse()
for _ in range(len(l)):
    print(ch_num(l[_]),end='')
