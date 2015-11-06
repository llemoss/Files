print "URI 1097"
I = 1
J = 8
JI = 8
while I < 10:
    J = J - 1
    print "I=%d J=%d" % (I, J)
    if J == (JI - 3):
        I = I + 2
        JI = JI + 2
        J = JI
