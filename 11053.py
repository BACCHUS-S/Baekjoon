def solve():
	length = int(input())
	array = list(map(int, input().strip().split()))
	cache = [1 for i in array]
	for i in range(length):
		for j in range(i, length):
			if(array[j] > array[i]):
				cache[j] = max(cache[j], cache[i] + 1)
	#print(cache)
	return max(cache)

if __name__ == "__main__":
	print(solve())
