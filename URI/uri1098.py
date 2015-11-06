print "URI 1098"
I = 0
J = 0
while I == 0:
    J = J + 1
    print "I=%d J=%d" % (I, J)
    if J == 3:
        JI = 0.0
        J = 0.0
        I = 0.2
        break

while (I) < 2.0:
    JI = JI + 1
    J = JI + I
    print "I=%.1f J=%.1f" % (I, J)
    if JI == 3:
        JI = 0
        I = I + 0.2
