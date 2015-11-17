arquivo = open("nomes.txt")
nomes = []
for i in arquivo:
	nomes.append(i.strip())

ordenada = []

for i in nomes:
	nomeseC = []
	c = 0
	for e in nomes:
		if i == e :
			c+=1
	nomeseC.append(i)
	nomeseC.append(c)
	if nomeseC not in ordenada: 
		ordenada.append(nomeseC)

def _cmp_por_c(x, y): return cmp(x[1], y[1])

ordenada.sort(_cmp_por_c)
for i in range(len(ordenada)):
	print "%s --- Repetido: %d" % (ordenada[i][0], ordenada[i][1])
