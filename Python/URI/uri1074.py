print "URI 1074"
N = input()
i = 0
f = range(N)
while i < N:
	if i != N:
		f[i] = input()
	i = i + 1
i = 0
while i < N:
	if f[i] == 0:
		print "NULL"
	else:
		if f[i]%2 == 0:
			if f[i] > 0:
				print "EVEN POSITIVE"
			else:
				print "EVEN NEGATIVE"
		elif f[i]%2 == 1:
			if f[i] > 0:
				print "ODD POSITIVE"
			else:
				print "ODD NEGATIVE"
	i =  i + 1