n,m = map(int,input().split())
lst,i,result = list(range(1,n+1)),0,[]
while lst:
	i=(i+m-1)%len(lst)
	result.append(lst.pop(i))
print("<"+", ".join(map(str,result))+">")
