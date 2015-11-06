print "URI 1061 - Enfim deu certo"
dia1 = input("Dia ")
hora1, min1, seg1 = [int(i) for i in raw_input("").split(" : ")]
dia2 = input("Dia ")
hora2, min2, seg2 = [int(i) for i in raw_input("").split(" : ")]

if dia1 == dia2:
	tempo1 = (hora1*3600) + (min1*60) + seg1
	tempo2 = (hora2*3600) + (min2*60) + seg2
	if tempo2 > tempo1:
		T = tempo2 - tempo1
elif dia2 > dia1: 
	tempo1 = 86400 - ((hora1*3600) + (min1*60) + seg1)
	tempo2 = (((dia2 - (dia1 + 1))*86400) + (hora2*3600) + (min2*60) + seg2)
	T = tempo2 + tempo1

TR = T%86400	
W = T/86400
X = TR/3600
Y = (TR%3600)/60
Z = (TR%3600)%60

print W, "dia(s)"
print X, "hora(s)"
print Y, "minuto(s)"
print Z, "segundo(s)"
a = input()