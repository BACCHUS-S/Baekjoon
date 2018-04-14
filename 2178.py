from sys import stdin
n, m = map(int, input().split())
arr=[[int(m) for m in stdin.readline().strip()]for _ in range(n)]
q = [[0, 0]]
cache = [[-1 for _ in range(m)] for _ in range(n)]
ans = 0
while True:
    temp = []
    for lst in q:
        x, y = lst
        if lst == (n-1, m-1):print(ans+1);quit()
        for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            if 0 <= x + dx < n and 0 <= y + dy < m:
                if cache[x+dx][y+dy] == -1 and arr[x+dx][y+dy] == 1:
                    temp.append((x+dx, y+dy))
                    cache[x+dx][y+dy] = 0
    ans += 1
    q = temp[:]
