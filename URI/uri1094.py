print "URI 1094"
i = 0
N = input()
f1 = range(N)
f2 = range(N)
AT = 0
C = 0
R = 0
S = 0
while i < N:
        if i != N:
                f1[i], f2[i] = [str(g) for g in raw_input("").split(" ")]
                while f1[i] < 1 and f1[i] > 15:
                        f1[i], f2[i] = [str(g) for g in raw_input("").split(" ")]
                f1[i] = int(f1[i])
                AT = AT + f1[i]
                if f2[i] == "C":
                        C = C + f1[i]
                if f2[i] == "R":
                        R = R + f1[i]
                if f2[i] == "S":
                        S = S + f1[i]
                i = i + 1


print "Total: %d cobaias" % AT
print "Total de coelhos: %d" % C
print "Total de ratos: %d" % R
print "Total de sapos: %d" % S
C = float(C)
R = float(R)
S = float(S)
AT = float(AT)
C = (C/AT)*100
R = (R/AT)*100
S = (S/AT)*100
print "Percentual de coelhos:", "{0:.2f}".format(C), "%"
print "Percentual de ratos:", "{0:.2f}".format(R), "%"
print "Percentual de sapos:", "{0:.2f}".format(S), "%"
