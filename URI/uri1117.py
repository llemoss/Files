X = input()
while X < 0 or X > 10:
    print "nota invalida"
    X = input()
else:
    Y = input()
    while Y < 0 or Y > 10:
        print "nota invalida"
        Y = input()
    med = (X+Y)/2.0
    print "media = %.2f" % med
