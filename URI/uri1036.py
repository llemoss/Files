print "URI 1036"
from math import * 
A, B, C = [float(i) for i in raw_input("").split(" ")]
delta = B**2-(4*A*C)
base = 2*A
if delta < 0 or base == 0:
    print "Impossivel calcular"
else:
	R1 = (-B + sqrt(delta))/base
	R2 = (-B - sqrt(delta))/base
	print "R1 = %.5f" % R1
	print "R2 = %.5f" % R2
