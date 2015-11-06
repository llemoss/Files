print "Ex. 6"
N = input()
QT = 0
C = 0
R = 0
S = 0
i = 0
while i < N:
	Q, T = [str(g) for g in raw_input("").split(" ")]
	Q = int(Q)
	QT = QT + Q
	if T == "C":
		C = C + Q
	if T == "R":
		R = R + Q
	if T == "S":
		S = S + Q
	i = i + 1

print "Total: %d cobaias" % QT
print "Total de coelhos: %d" % C
print "Total de ratos: %d" % R
print "Total de sapos: %d" % S
C = float(C)
R = float(R)
S = float(S)
QT = float(QT)
C = C*100/QT
R = R*100/QT
S = S*100/QT
print "Percentual de coelhos: %.2f %%" % C
print "Percentual de ratos: %.2f %%" % R
print "Percentual de sapos: %.2f %%" % S
