n = int(input())
tri = [list(map(int, input().split())) for i in range(n)]

for ri, r in enumerate(tri):
    for ci, c in enumerate(r):
        if r==0:continue
        else:
            left = tri[ri-1][ci-1] if ci-1 >=0 else 0
            right = tri[ri-1][ci] if ci<len(r)-1 else 0
            tri[ri][ci] += max(left, right)
print(max(tri[-1]))