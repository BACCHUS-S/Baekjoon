def fac(num,cnt):
    square = 1
    for i in range(cnt): square *= (num-i)
    return square
n,m = map(int,input().split())
temp = min(m,n-m)
print(fac(n,temp)//fac(temp,temp))