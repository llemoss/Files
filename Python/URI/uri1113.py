print "URI 1113"
X, Y = [int(i) for i in raw_input("").split(" ")]
while X != Y:
    if X < Y:
        print "Crescente"
    else:
        print "Decrescente"
    X, Y = [int(i) for i in raw_input("").split(" ")]
