n = input()
s = ""
for i in n:
	if i==" ":
		s += i
	elif i.isdigit():
		s += i
	elif i.islower():
		j = ord(i)+13
		s += chr(j) if j<123 else chr(j-26)  
	elif i.isupper():
		j = ord(i)+13
		s += chr(j) if j<91 else chr(j-26)  
print(s)
