arquivo = open("palavras.txt")
palavras = []
for i in arquivo: palavras.append(i.strip())
dic = {}
for palavra1 in palavras:
	for palavra2 in palavras:
		if len(palavra1) == len(palavra2) and palavra1 != palavra2:
			contador = 0
			for j in range(len(palavra1)):
				if palavra1[j] == palavra2[len(palavra1) - 1 - j]:
					contador += 1
			if contador == len(palavra1):
				dic[palavra1] = palavra2

print dic
