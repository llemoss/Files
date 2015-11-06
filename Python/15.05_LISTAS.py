def no_n():
    palavras = list(open('words.txt'))
    for i in range(len(palavras)):
        palavras[i] = palavras[i].strip()
    print palavras[1007]

def contar(l, i):
    c = 0
    for e in l:
        if e == i:
            c += 1
    return c

def is_anagram(s1, s2):
    c = 0
    for i1 in s1:
        for i2 in s2:
            if i2 == i1:
                c += 1
    if c == len(s2):
        return True
    else:
        return False

'''
Entrada: matricula, nome, ymd (data), sexo (m/f), curso
Exemplo: 0450114, Rogerio, 1984/07/01, m, ads
'''

listaAlunos = list(open('alunos.txt'))
for a in range(len(listaAlunos)):
	listaAlunos[a] = listaAlunos[a].strip()

matricula = []
nome = []
data = []
sexo = []
curso = []

for a in listaAlunos:
	dadosAluno = a.split(";")
	matricula.append(dadosAluno[0])
	nome.append(dadosAluno[1])
	data.append(dadosAluno[2])
	sexo.append(dadosAluno[3])
	curso.append(dadosAluno[4])

listaAlunos = [matricula] + [nome] + [data] + [sexo] + [curso]

'''
for i in range(len(matriz)):
	for j in range(len(i)):

'''

def has_duplicates(lista):
	c = 0
	for n in range(len(lista)):
		for i in range(len(lista[n])):
			c = lista[n].count(lista[n][i])
		c += c
	return "Itens repetidos:", c

def percentual_sexo(lista):
	m = 0.0
	f = 0.0
	t = 0.0
	for i in lista:
		if i == 'm':
			m += 1.0
		if i == 'f':
			f += 1.0
	print m
	print f
	t = float(len(lista))
	m = m/t
	f = f/t
	return "Percentual masculino: %.1f %% / Percentual feminino: %.1f %%" % (m*100, f*100)

print has_duplicates(listaAlunos)
print percentual_sexo(listaAlunos[3])




