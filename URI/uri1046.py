print "URI 1046"
start, end = [int(i) for i in raw_input("").split(" ")]

if end < start:
	dur = 24 - start
	dur = dur + end
elif start == end:
	dur = 24
else:
	dur = abs(start - end)

print "O JOGO DUROU", dur, "HORA(S)"