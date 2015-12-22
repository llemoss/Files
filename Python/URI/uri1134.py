c = input()
A = 0
G = 0
D = 0
while c >= 1 or c <= 4:
    if c == 1:
        A = A + 1
    elif c == 2:
        G = G + 1
    elif c == 3:
        D = D + 1
    elif c == 4:
        print "MUITO OBRIGADO"
        print "Alcool: %d" % A
        print "Gasolina: %d" % G
        print "Diesel: %d" % D
        break
    c = input()
else:
    c = input()
