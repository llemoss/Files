# -*- coding: cp1252 -*-

def calcularTempo(lista, quantum, trocaContexto):
    #status = P (pronto), W (espera), E (execução), T (terminou)
    tempo = 0
    loopCount = 0
    vetorTemposFinais = []
    primeiraVolta = True
    emTrocaDeContexto = False
    countTC = 0
    i = 0
    while(True):

        if(i == len(lista)):
            i = 0
        
        count = 0;
        for j in range(len(lista)):
            if (lista[j] == 0):
                    count += 1
        #print "Count:", count
        if (count == len(lista)):
            break

        #while(i < len(lista)):
        if(emTrocaDeContexto == True):
            pass
        else:
            if(lista[i] - quantum >= 0 and tempo > 0):
                if(tempo%quantum == 0 and primeiraVolta == True):
                    lista[i] = lista[i] - quantum
                    emTrocaDeContexto = True
                    primeiraVolta = False
                elif(tempo%quantum == 0):
                    lista[i] -= quantum
                    emTrocaDeContexto = True
                if(lista[i] == 0):
                    vetorTemposFinais += [tempo]
            elif(lista[i] - quantum < 0 and tempo > 0):
                lista[i] -= lista[i]
                emTrocaDeContexto = True
                if(lista[i] == 0):
                    vetorTemposFinais += [tempo]
        #i += 1

        if(emTrocaDeContexto == True):
            if(countTC == trocaContexto):
                emTrocaDeContexto = False
                countTC = 0
                i += 1
            else:
                countTC += 1
            print "countTC:", countTC, "emTrocaDeContexto:", emTrocaDeContexto
            
        print "Tempo:", tempo, "Lista de programas:", lista
        tempo += 1
     
    
#listaProgramas = [int(i) for i in raw_input("Digite os tempos de processador dos programas separando por espaço: ").split(" ")]
#quantum, trocaContexto = [int(i) for i in raw_input("Digite quantum e fator de troca de contexto separados por espaço: ").split(" ")]
listaProgramas = [12, 16, 7, 9]
quantum = 6
trocaContexto = 3
calcularTempo(listaProgramas, quantum, trocaContexto)

