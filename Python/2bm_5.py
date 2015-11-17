arquivo = open("palavras.txt")
palavras = []
for i in arquivo: palavras.append(i.strip())
dic = {}
for i in palavras:
	for e in palavras:
		if len(i) == len(e) and i != e:
			c = 0
			p = 0
			for j in range(len(i)):
				if i[j] == e[len(i) - 1 - j]:
					p += 1
			if p == len(i):
				dic[i] = e

print dic
