from os import system

'''
[0]    #Rank
[1]    #Nome
[2]    #Cidade
[3]    #Estado
[4]    #Tipo
[5]    #Permanencia
[6]    #Nivel socioeconomico
[7]    #Obj
[8]    #Lin
[9]    #Mat
[10]   #Nat
[11]   #Hum
[12]   #Red


'''

#------------------- Obtencao do arquivo -----------------
def _cmp_por_rank(x, y):
    return cmp(x[0], y[0])

f = open('enem2014.csv')
escolas = []
inp = "15" #Inicializacao de variavel do menu

def conversaoNotas(escolas): #Funcao para converter as strings dos vetores em numeros
    for i in range(len(escolas)):
        for j in range(7, 13):
            escolas[i][j] = float(escolas[i][j])
        escolas[i][0] = int(escolas[i][0])

for l in f: #Organizacao do vetor escolas
    escolas.append(l.strip().split(','))

conversaoNotas(escolas) #Conversao de float/int

listaCidades = [] #Vetor para armazenar lista de cidades + estado (usada na opcao 7)
for i in range(len(escolas)):
    listaCidades.append([escolas[i][2]] + [escolas[i][3]])
    

def top(tipo=1, n=10, uf='BR', cid="", nom="", disc=7): #Funcao principal
    texto = ""
    c = 1
    if uf != "BR" and tipo not in [2, 7]: #Filtro por estado
         for i in range(len(escolas)):
            if escolas[i][3] == uf and c < n+1:
                texto += "%d -- %d -- %s -- (%s, %s)\n" % (c, escolas[i][0], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1
    if cid != "" and tipo not in [2, 7]: #Filtro por cidade
        for i in range(len(escolas)):
            if escolas[i][2] == cid and c < n+1:
                texto += "%d -- %d -- %s -- (%s, %s)\n" % (c, escolas[i][0], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1
    if nom != "" and tipo not in [2, 7]: #Filtro por nome
        for i in range(len(escolas)):
            if nom in escolas[i][1]:
                texto += "%d -- %d -- %s -- (%s, %s)\n" % (c, escolas[i][0], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1

    if tipo == 1 and uf == "BR" and cid == "": #Top N comum
        formato = "RANK NACIONAL -- NOME -- (CIDADE, UF)"
        print formato
        for i in range(len(escolas)):
            if escolas[i][0] > 0 and escolas[i][0] < n+1:
                texto += "%d -- %s -- (%s, %s)\n" % (escolas[i][0], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1

    if tipo == 2: #Top N comum
        formato = "RANK NACIONAL -- NOME -- (CIDADE, UF)"
        print formato
        for i in range(len(escolas)):
            if (escolas[i][0] > 0 and escolas[i][0] < n+1) and uf == "BR":
                texto += "%d -- %d -- %.2f -- %s -- (%s, %s)\n" % (c, escolas[i][0], escolas[i][disc], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1
            if (escolas[i][0] > 0 and escolas[i][0] < n+1) and (uf == escolas[i][3] or cid == escolas[i][2]):
                texto += "%d -- %d -- %.2f -- %s -- (%s, %s)\n" % (c, escolas[i][0], escolas[i][disc], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1

    if tipo == 7: #Top manual
        formato = "RANK LOCAL -- RANK NACIONAL -- NOTA -- NOME -- (CIDADE, UF)"
        print formato
        for i in range(len(escolas)):
            if (escolas[i][2] == cid or escolas[i][3] == uf) and c < n+1:
                texto += "%d -- %d -- %.2f -- %s -- (%s, %s)\n" % (c, escolas[i][0], escolas[i][disc], escolas[i][1], escolas[i][2], escolas[i][3])
                c += 1

    return texto

def avg(uf="BR", cid="", disc=7): #Funcao para retornar valor float da media de estado ou cidade, usada em varias opcoes
    media = 0.0
    total = 0.0
    c = 0.0
    if uf != "BR" and cid == "":
        total = 0.0
        c = 0.0
        for i in range(len(escolas)):
            if uf == escolas[i][3]:
                total += escolas[i][disc]
                c += 1.0
        media = total/c
    elif cid != "" and uf == "BR":
        total = 0.0
        c = 0.0
        for i in range(len(escolas)):
            if cid == escolas[i][2]:
                total += escolas[i][disc]
                c += 1.0
    if c == 0.0:
        media = 0
        c = 1
    media = total/c
    media = float(media)
    return media

def opcao5(uf, tipo): #Funcao para opcao5, de calcular media por tipo de escola
    total = 0.0
    count = 0.0
    media = 0.0
    for i in range(len(escolas)):
        if tipo == escolas[i][4] == "Privada" and escolas[i][3] == uf:
            total += escolas[i][7]
            count += 1.0
        if tipo == escolas[i][4] == "Federal" and escolas[i][3] == uf:
            total += escolas[i][7]
            count += 1.0
        if tipo == escolas[i][4] == "Municipal" and escolas[i][3] == uf:
            total += escolas[i][7]
            count += 1.0
        if tipo == escolas[i][4] == "Estadual" and escolas[i][3] == uf:
            total += escolas[i][7]
            count += 1.0

    if count <= 0.0:
        media = 0.0
    else:
        media = total/count

    return "%s --- %.2f" % (tipo, media)

def opcao8(disc, uf, cid, n=10,r=True): #Opcao de fazer top 10 de materias, qualquer uma, por cidade e/ou por estado
    if disc not in [7,8,9,10,11,12]:
        disc = 7
    texto = ""
    def _cmp_por_nota(x, y): return cmp(x[disc], y[disc])
    temp = escolas
    temp.sort(_cmp_por_nota,reverse=r)
    formato = "RANK NACIONAL -- NOTA -- NOME -- (CIDADE, UF)"
    c = 1
    if uf != "BR" and cid == "":
         print formato
         for i in range(len(temp)):
            if temp[i][3] == uf and c < 10+1:
                texto += "%d -- %d -- %.2f -- %s -- (%s, %s)\n" % (c, temp[i][0],temp[i][disc], temp[i][1], temp[i][2], temp[i][3])
                c += 1
    if cid != "":
        print formato
        for i in range(len(temp)):
            if temp[i][2] == cid and c < 10+1:
                texto += "%d -- %d -- %.2f -- %s -- (%s, %s)\n" % (c, temp[i][0],temp[i][disc], temp[i][1], temp[i][2], temp[i][3])
                c += 1

    print texto

def opcao9(disc, n, r=True): #Top N (ate 26) de estados, de melhor para pior, ou contrario
    rankEstados = []
    def _cmp_por_estado(x, y): return cmp(x[1], y[1])
    for estado in ["AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"]:
            rankEstados.append([estado] + [avg(estado,"",disc)])
    rankEstados.sort(_cmp_por_estado, reverse=r)
    c=1
    for i in range(n):
        print ("%d --- %s --- %.2f") % (c, rankEstados[i][0], rankEstados[i][1])
        c+=1

def remove(l, i):
    for e in l:
        if e == i:
            l.remove(e)

def deleteDuplicates(lista):
    for n in lista:
        remove(lista, n)
    return lista

#As duas funcoes acima sao usadas para remover as multiplas instancias de cidades na opcao 7

def opcao10(disc, n, r=True):
    rankCidades = []
    disc = int(disc)
    def _cmp_por_cidade(x, y): return cmp(x[1], y[1])
    for cidade in listaCidades:
        string = "%s, %s" % (cidade[0], cidade[1])
        rankCidades.append([string] + [avg("BR", cidade[0], disc)])#Criacao do vetor resultante com nomes e notas
    rankCidades.sort(_cmp_por_cidade, reverse=r) #Aqui tambem se escolhe de melhor para pior ou contrario
    rankCidades = deleteDuplicates(rankCidades) #Retirada de duplicatas
    c=1
    for i in range(n):
        print ("%d --- %s --- %.2f") % (c, rankCidades[i][0], rankCidades[i][1]) #Resultado
        c+=1

def inputDisc(): #Funcao para input de disciplinas
    disc = raw_input("Materia (todas, mat, lin, nat, hum ou red): ")
    opcoes = ["todas","mat","lin","nat","hum","red"]
    if disc == opcoes[0]: disc = 7
    elif disc == opcoes[1]: disc = 8
    elif disc == opcoes[2]: disc = 9
    elif disc == opcoes[3]: disc = 10
    elif disc == opcoes[4]: disc = 11
    elif disc == opcoes[5]: disc = 12
    else: disc = 7

    return disc

def comparar(uf1, uf2): #Comparacao usando a funcao opcao5
    print "        ----- " + uf1 + " ---------- " + uf2 + " ----- "
    print opcao5(uf1, "Privada") + " ----- " + opcao5(uf2, "Privada")
    print opcao5(uf1, "Federal") + " ----- " + opcao5(uf2, "Federal")
    print opcao5(uf1, "Municipal") + " ----- " + opcao5(uf2, "Municipal")
    print opcao5(uf1, "Estadual") + " ----- " + opcao5(uf2, "Estadual")

opcoes = []
for i in range(0, 13): opcoes.append(str(i))

def menu():
    inp = '15'
    print "-------------------------------------"
    print "ENEM 2014 - Programa de consulta"
    print "-------------------------------------"
    print "1 - Top 10                         |"
    print "2 - Lista por Cidade/UF            |"
    print "3 - Lista por Nome                 |"
    print "4 - Media de Cidade/UF             |"
    print "5 - Media por tipo em cada UF      |"
    print "6 - Comparar estados               |"
    print "7 - Top N de medias por cidade     |"
    print "8 - Top 10 por materia             |"
    print "9 - Top N de medias por estado     |"
    print "10 - Piores N de medias por cidade |"
    print "11 - Piores N de medias por estado |"
    print "12 - Piores escolas por cidade/UF  |"
    print "0 - Sair                           |"
    print "------------------------------------"

while inp not in opcoes:
    menu()
    inp = raw_input("Digite um numero: ")
    if inp == '1':
        escolas.sort(_cmp_por_rank, reverse=False)
        system('clear')
        print "\n"
        print top(1,10,"BR","","")
        inp = '15'
    if inp == '2':
        escolas.sort(_cmp_por_rank, reverse=False)
        cid = raw_input("Digite cidade (deixar em branco caso queira todas): ")
        cid = cid.upper()
        uf = raw_input("Digite UF (usar BR para mostrar todos): ")
        uf = uf.upper()
        n = input("Digite quantidade: ")
        print "\n"
        formato = "RANK LOCAL -- RANK NACIONAL -- NOME -- (CIDADE, UF)"
        system('clear')
        print formato
        print top(3, n, uf, cid,"")
        inp = '15'
    if inp == '3':
        escolas.sort(_cmp_por_rank, reverse=False)
        nom = raw_input("Digite trecho do nome: ")
        nom = nom.upper()
        uf = "BR"
        uf = uf.upper()
        print "\n"
        system('clear')
        print top(3, len(escolas), uf, "", nom)
        inp = '15'
    if inp == '4':
        cidORuf = "a"
        while cidORuf != "cid" or cidORuf != "uf":
            cidORuf = raw_input("Por cidade ou por UF? (cid/uf): ")
            if cidORuf == "cid":
                cid = raw_input("Digite cidade: ")
                if cid == "": cid = ""
                cid = cid.upper()
                disc = inputDisc()
                print "\n"
                system('clear')
                media = avg("BR", cid, disc)
                print "%s ----- %.2f\n" % (cid, media)
                break
            if cidORuf == "uf":
                uf = raw_input("Digite UF: ")
                if uf == "": uf = "BR"
                uf = uf.upper()
                disc = inputDisc()
                print "\n"
                system('clear')
                media = avg(uf, "", disc)
                print "%s ----- %.2f\n" % (uf, media)
                break
        inp = '15'
    if inp == '5':
        uf = raw_input("Digite UF: ")
        uf = uf.upper()
        print "\n"
        system('clear')
        print "----- " + uf + " -----"
        print opcao5(uf, "Privada")
        print opcao5(uf, "Federal")
        print opcao5(uf, "Municipal")
        print opcao5(uf, "Estadual")
        print "\n"
        inp = '15'
    if inp == '6':
        uf1 = raw_input("Digite primeira UF: ")
        uf1 = uf1.upper()
        uf2 = raw_input("Digite segunda UF: ")
        uf2 = uf2.upper()
        system('clear')
        comparar(uf1, uf2)
        inp = '15'
    if inp == '20':
        escolas.sort(_cmp_por_rank, reverse=False)
        n = input("Quantidade: ")
        cid = raw_input("Digite cidade (deixar em branco caso queira todas): ")
        cid = cid.upper()
        uf = raw_input("Digite UF (usar BR para mostrar todos): ")
        uf = uf.upper()
        disc = inputDisc()
        print "\n"
        system('clear')
        print top(3,n,uf,cid,"",disc)
        print "\n"
        inp = '15'
    if inp == '8':
        disc = inputDisc()
        cid = raw_input("Digite cidade (deixar em branco caso queira todas): ")
        cid = cid.upper()
        uf = raw_input("Digite UF (usar BR para mostrar todos): ")
        uf = uf.upper()
        print "\n"
        system('clear')
        opcao8(disc, uf, cid)
        print "\n"
        inp = '15'
    if inp == '9':
        disc = inputDisc()
        n = input("Quantidade (ate 26): ")
        print "\n"
        system('clear')
        print "RANK --- ESTADO --- NOTA NA MATERIA ESCOLHIDA"
        opcao9(disc, n)
        print "\n"
        inp = '15'
    if inp == '7':
        disc = inputDisc()
        n = int(input("Quantidade: "))
        print disc
        print "\n"
        system('clear')
        print "Buscando, computando e comparando cidades...\n"
        print "RANK --- CIDADE --- NOTA NA MATERIA ESCOLHIDA"
        opcao10(disc, n)
        print "\n"
        inp = '15'
    if inp == '10':
        disc = inputDisc()
        n = int(input("Quantidade: "))
        print "\n"
        system('clear')
        print "Buscando, computando e comparando cidades...\n"
        print "RANK --- CIDADE --- NOTA NA MATERIA ESCOLHIDA"
        opcao10(disc, n, False)
        print "\n"
        inp = '15'
    if inp == '11':
        disc = inputDisc()
        n = int(input("Quantidade: "))
        print "\n"
        system('clear')
        print "Buscando, computando e comparando cidades...\n"
        print "RANK --- ESTADO --- NOTA NA MATERIA ESCOLHIDA"
        opcao9(disc, n, False)
        print "\n"
        inp = '15'
    if inp == '12':
        disc = inputDisc()
        cid = raw_input("Digite cidade (deixar em branco caso queira todas): ")
        cid = cid.upper()
        uf = raw_input("Digite UF (usar BR para mostrar todos): ")
        uf = uf.upper()
        print "\n"
        system('clear')
        opcao8(disc, uf, cid, 10, False)
        print "\n"
        inp = '15'
    if inp == '0':
        system('clear')
        break
