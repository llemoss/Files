print "URI 1037"
between = float(input())
if between >= 0.0 and between <= 25.0:
    print "Intervalo [0,25]"
elif between >= 25.0 and between <= 50.0:
    print "Intervalo (25,50]"
elif between >= 50.0 and between <= 75.0:
    print "Intervalo (50,75]"
elif between >= 75.0 and between <= 100.0:
    print "Intervalo (75,100]"
else:
    print "Fora de intervalo"
