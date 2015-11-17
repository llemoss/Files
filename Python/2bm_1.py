#20 25 85 40 25 90 25 40 55 40 25
notas = raw_input()
notas = notas.split(" ")
for i in notas: i = int(i)
notas.sort()
print notas

def count(l):
	c = 0
	oldC = 0
	for i in l:
		if oldC <= c: oldC = c
		c = 0
		for e in l:
			if i == e:
				c+=1
		if c >= oldC: 
			counted = i
	return counted

print "Maior nota com maior frequencia: ", count(notas)
