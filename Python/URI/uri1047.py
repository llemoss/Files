print "URI 1047"
start1, end1, start2, end2 = [int(i) for i in raw_input("").split(" ")]

time1 = (start1*60) + end1
time2 = (start2*60) + end2
if start2 < start1:
	time2 = time2 + 1440
timeT = time2 - time1
horaT = abs(timeT/60)
minT = abs(timeT%60)
if horaT == 0 and minT == 0:
	horaT = 24

print "O JOGO DUROU %d HORA(S) E %d MINUTO(S)" % (horaT, minT)