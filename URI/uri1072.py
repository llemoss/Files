print "URI 1072"
N = input()
i = 0
l = range(N)
IN = 0
OUT = 0

for i in l:
	l[i] = input()
	if l[i] >= 10 and l[i] <= 20:
		IN = IN + 1
	else:
		OUT = OUT + 1
		
print IN, "in"
print OUT, "out"