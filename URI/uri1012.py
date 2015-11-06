print "Area do Triangulo, Circulo, Trapezio, Quadrado e Retangulo"
A, B, C = [float(i) for i in raw_input("").split(" ")]
triangle = (A*C)/2
circle = C*C*3.14159
trapezium = ((A+B)*C)/2
square = B*B
retangle = A*B
print "TRIANGULO: %.3f" % triangle
print "CIRCULO: %.3f" % circle
print "TRAPEZIO: %.3f" % trapezium
print "QUADRADO: %.3f" % square
print "RETANGULO: %.3f" % retangle
