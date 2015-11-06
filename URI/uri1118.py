print "URI 1118"
cal = 1
while cal == 1:
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
        cal = input("novo calculo 1-sim 2-nao\n")
        while (cal > 1 and cal != 2) or cal < 1:
            cal = input("novo calculo 1-sim 2-nao\n")
