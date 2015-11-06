print "URI 1045"
A, B, C = [float(i) for i in raw_input("").split(" ")]

while A <= 0 and B <= 0 and C <= 0:
	A, B, C = [float(i) for i in raw_input("").split(" ")]

l = [A, B, C]
l.sort(reverse=True)
i = 0

if l[0] >= (l[1] + l[2]):
	print "NAO FORMA TRIANGULO"
else:
        if (l[0]*l[0]) == (l[1]*l[1] + l[2]*l[2]):
                print "TRIANGULO RETANGULO"
        elif (l[0]*l[0]) > (l[1]*l[1] + l[2]*l[2]):
                print "TRIANGULO OBTUSANGULO"
                i = 1
        elif (l[0]*l[0]) < (l[1]*l[1] + l[2]*l[2]):
                print "TRIANGULO ACUTANGULO"
                i = 1
        if (l[0] == l[1] == l[2]):
                print "TRIANGULO EQUILATERO"
        elif (l[0] == l[1] and (l[2] != l[1] and l[2] != l[0])) or (l[1] == l[2] and (l[0] != l[1] and l[0] != l[2])) or (l[0] == l[2] and (l[1] != l[0] and l[1] != l[2])):
                print "TRIANGULO ISOSCELES"
