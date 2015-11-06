def f(x):
	return x/x-1


def limite(x0, e):
	l = 0
	delta = e
	while( ((l - e) > f(x0 + delta)) or (f(x0+delta) > (l + e)) ):

		e -=  (delta / 10)
		l = f(x0 + delta)

		print "---"
		print "E: ", e
		print "L: ", l
		print "Delta: ", delta
		print "---"

	print delta
	print e

	return l


def limite2(x0, e):
	l = 0
	
	delta = e

	for i in range(1, 10):
		print e
		e -= (e/(2**i))

#	return l

print "limites"
#print limite(1, 0.01)
limite(1, 0.1)
