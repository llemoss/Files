print "Ex. 8"
N = input()
i = 1
soma = 0
while N > 0:
	soma = soma + N
	N = input()
	i = i + 1
else:
	i = i - 1
	i = float(i)
	med = soma/i
	print "%.2f" % med
