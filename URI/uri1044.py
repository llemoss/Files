print "URI 1044"
A, B = [int(i) for i in raw_input("").split(" ")]
if B > A:
    if B%A == 0:
        print "Sao Multiplos"
    else:
        print "Nao sao Multiplos"
