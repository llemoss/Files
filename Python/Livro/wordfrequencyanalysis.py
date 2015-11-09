import string
livro = open("livro3.txt")
linhas = []
palavras = []

for linha in livro:
    linhas.append(str(linha.strip()))

print linhas[0]

for i in range(18):
    linhas[i] = "."

for linha in range(len(linhas)):

    for i in string.punctuation:
        linhas[linha] = linhas[linha].replace(i, " ")

    linhas[linha] = linhas[linha].lower().split(" ")

    for palavra in linhas[linha]:
        if palavra == "":
            linhas[linha].remove(palavra)
        if palavra == " ":
            linhas[linha].remove(palavra)

for i in linhas:
    if i == []:
        linhas.remove(i)
    for j in i:
        palavras.append(j)

def removeWord(w, l):
    for i in l:
        if i == w:
            l.remove(i)

print "Quantidade de palavras no livro (com repeticoes):", len(palavras)

c = 0
contagem = []
for i in palavras:
    for e in palavras:
        if i == e:
            c += 1
    palavra = [i, c]
    contagem += [palavra]
    c = 0

def _cpm_by_c(x, y): return cmp(x[1], y[1])

def removeCopy(l):
    for i in l:
        for e in l:
            if i == e:
                l.remove(i)

removeCopy(contagem)
removeCopy(contagem)
removeCopy(contagem)
contagem.sort(_cpm_by_c, reverse=True)

print "Quantidade de palavras no livro (sem repeticoes):", len(contagem)
print "\n"
print "--- Ranking das 20 palavras mais usadas no livro ---"
c = 1
for i in range(20):
    print "%d - %s - Vezes repetida: %d" % (c, contagem[i][0], contagem[i][1])
    c += 1
print "----------------------------------------------------"

def compareWordList(arquivo, palavrasLivro):
    wordlist = []
    resultado = []
    quantidade = 0
    for linha in arquivo: wordlist.append(str(linha.strip()))
    for item in palavrasLivro:
        for palavra in wordlist:
            if item != palavra:
                resultado.append(item)
                quantidade += 1

    for i in range(2): removeCopy(resultado)
    print "Quantidade de palavras que nao estao na lista:", quantidade/3
    while(True):
        escolha = raw_input("Deseja saber quais sao? (Y/N): ")
        escolha.lower()
        if escolha == "y":
            print "Lista de palavras que nao estao: "
            for i in range(len(resultado)): print "%s" % resultado[i]
        elif escolha == "n":
            break
        else:
            escolha = raw_input("Deseja saber quais sao? (Y/N): ")
            escolha.lower()

arquivo = open("wordlist.txt")
compareWordList(arquivo, palavras)
