n = int(input())
for _ in range(n):
    m = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    x, y, z = a[0], b[0], 0
    for i in range(1, m):
        x, y, z = max(y, z) + a[i], max(x, z) + b[i], max(x, y)
    print(max(x, y, z))
