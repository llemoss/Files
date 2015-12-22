print "URI 1043"
a, b, c = [float(i) for i in raw_input("").split(" ")]
if a < b + c and b < a + c and c < b + a:
    per = a + b + c
    print "Perimetro = %.1f" % per
else:
    area = ((a+b)*c)/2
    print "Area = %.1f" % area