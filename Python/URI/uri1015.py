print "Reta"
import math
x1, y1 = [float(i) for i in raw_input("Digite x1 e y1: ").split(" ")]
x2, y2 = [float(i) for i in raw_input("Digite x2 e y2: ").split(" ")]
r = (x2 - x1)**2 + (y2 - y1)**2
print "%.4f" % (math.sqrt(r))