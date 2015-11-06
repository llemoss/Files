print "Ex. 4"
N = input()
i = N*4
f = range(i)
g = 0
while g < i:
	print "%d %d %d IFPI" % (f[g+1], f[g+2], f[g+3])
	g = g + 4
