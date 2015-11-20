import string

livro = open("livro4.txt")
arquivo = open("wordlist.txt")

linhas = []
palavras = []

for linha in livro: #Separacao das linhas em vetores
    linhas.append(str(linha.strip()))

print linhas[0] #Print do titulo do livro

for i in range(18): #Todos seguem 18 linhas de introducao, aqui as retiro
    linhas[i] = "."

for linha in range(len(linhas)): #Retirada dos espacos, acentos, pontos, etc.

    for i in string.punctuation:
        linhas[linha] = linhas[linha].replace(i, " ")

    linhas[linha] = linhas[linha].lower().split(" ")

    for palavra in linhas[linha]:
        if palavra == "":
            linhas[linha].remove(palavra)
        if palavra == " ":
            linhas[linha].remove(palavra)

for i in linhas:
    if i == []: #Retirada de qualquer conjunto vazio apos as retiradas acima
        linhas.remove(i)
    for j in i: #Criacao do vetor de palavras em si
        palavras.append(j)

for i in palavras:
    if i == "":
        palavras.remove(i)
for i in palavras:
    if i == " ":
        palavras.remove(i)

print "Quantidade de palavras no livro (com repeticoes):", len(palavras)
print "Computando e comparando palavras..."

c = 0
contagem = []
for i in palavras:
    #Aqui eu crio um vetor para armazenar a palavra e quantas vezes ela foi repetida
    for e in palavras:
        if i == e:
            c += 1
    palavra = [i, c]
    if palavra not in contagem:
        contagem += [palavra]
    c = 0

def _cpm_by_c(x, y): return cmp(x[1], y[1])

def removeCopy(l): #Funcao para retirada de copias no vetor
    for i in l:
        for e in l:
            if i == e:
                l.remove(i)

#for i in range(3): removeCopy(contagem)

contagem.sort(_cpm_by_c, reverse=True) #Sort customizado via vezes repetidas

print "Quantidade de palavras no livro (sem repeticoes):", len(contagem)
print "\n"
print "--- Ranking das 20 palavras mais usadas no livro ---"
c = 1
for i in range(20):
    print "%d - %s - Vezes repetida: %d" % (c, contagem[i][0], contagem[i][1])
    c += 1
print "----------------------------------------------------\n"

def compareWordList(arquivo, palavrasLivro):
    print "Comparando com a lista de palavras fornecida..."
    wordlist = []
    resultado = []
    quantidade = 0
    for linha in arquivo: wordlist.append(str(linha.strip())) #Separando cada palavra em um vetor
    for item in palavrasLivro:
        for palavra in wordlist: #Comparacao geral e contagem de palavras
            if item != palavra:
                if item not in resultado:
                    resultado.append(item)
                quantidade += 1

    for i in range(2): removeCopy(resultado) #Remocao de copias
    
    print "Quantidade de palavras que nao estao na lista (com duplicatas):", quantidade/len(wordlist)
    #A divisao por len(wordlist) acontece porque ha uma repeticao das palavras no tamanho da lista

    while(True):
        escolha = raw_input("Deseja saber quais sao? (Y/N): ")
        #So jogar milhares de palavras de uma vez nao faz sentido, acho que a quantidade e suficiente
        escolha.lower()
        if escolha == "y":
            print "Lista de palavras que nao estao: "
            for i in range(len(resultado)): print "%s" % resultado[i]
            break
        elif escolha == "n":
            break

compareWordList(arquivo, palavras)
