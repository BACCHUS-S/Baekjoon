import sys
N = int(input())
input = sys.stdin.readline
ORIGIN = list(map(int,input().split()))
PNT = sorted(set(ORIGIN))
DICT={}
for idx in range(len(PNT)): DICT[PNT[idx]] = idx
for item in ORIGIN: print(DICT[item], end=" ")