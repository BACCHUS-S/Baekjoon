tree={}
for i in range(int(input())):
    c=input().split()
    tree[c[0]]=(c[1],c[2])
def pre(c):
    print(c,end='')
    if tree[c][0]!='.':
        pre(tree[c][0])
    if tree[c][1]!='.':
        pre(tree[c][1])
def mid(c):
    if tree[c][0]!='.':
        mid(tree[c][0])
    print(c,end='')
    if tree[c][1]!='.':
        mid(tree[c][1])
def pro(c):
    if tree[c][0]!='.':
        pro(tree[c][0])
    if tree[c][1]!='.':
        pro(tree[c][1])
    print(c,end='')
pre('A')
print()
mid('A')
print()
pro('A')
