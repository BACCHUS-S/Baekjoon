from collections import Counter
import sys
input = sys.stdin.readline
lst=[]
for _ in range(int(input())):
    lst.append(int(input()))

cnt = list(Counter(lst).items())
cnt.sort(key=lambda x:(x[1],-x[0]))
print(cnt[-1][0])
