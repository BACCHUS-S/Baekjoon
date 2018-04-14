def ch_chr(c):
    if c>='A': return ord(c)-55
    else: return int(c)
a,b = input().split()
b=int(b)
n=len(a)-1
sum=0
for x in a:
    sum += ch_chr(x)*(b**n)
    n-=1
print(sum)
