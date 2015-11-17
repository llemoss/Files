gabarito = open("gabarito.txt")
gabarito = gabarito.readline().strip()
listaRespostas = []
for i in range(len(gabarito)): listaRespostas.append(gabarito[i])
cartoes = open("cartoes.txt")
listaCartoes = []
for i in cartoes:
	listaCartoes.append(i.strip())
for i in range(len(listaCartoes)):
	listaCartoes[i] = listaCartoes[i].split("#")
for i in listaCartoes:
	cartao = []
	for j in range(len(i[1])): cartao.append(i[1][j])
	i[1] = cartao
for aluno in listaCartoes:
	pontos = 0
	for i in range(len(aluno[1])):
		if aluno[1][i] == listaRespostas[i]:
			pontos += 1
	
	print "%s -- Fez %d pontos" % (aluno[0], pontos)
