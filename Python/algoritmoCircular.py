# -*- coding: cp1252 -*-

def tempoMedioTurnaround(vetorProgramas):
    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j])
    
    tempo = tempo / len(vetorProgramas)
    return tempo

def tempoMedioEspera(vetorTempos, vetorProgramas):
    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j] - vetorTempos[j])
    tempo = tempo / len(vetorProgramas)
    return tempo

def calcularTempo(lista, quantum, trocaContexto):
    origQuantum = quantum
    tempo = 0
    loopCount = 0
    vetorTempos = [0]
    vetorProgramas = []
    while(True):
        
        count = 0;
        for j in range(len(lista)):
            if (lista[j] == 0):
                    count += 1
        print "Count:", count
        print "Loop count:", loopCount
        if (count == len(lista)):
            break

        i = 0
        while(i < len(lista)):
            
            #print "Começo -- Processo:", i+1, "// Tempo:", tempo, "// Valor:", lista[i]

            if (lista[i] > 0):
                if ((lista[i] - quantum) < 0):
                    oldTempo = tempo
                    tempo += lista[i] + trocaContexto
                    vetorTempos += [tempo]
                    lista[i] -= lista[i]
                    if (lista[i] == 0):
                        vetorProgramas += [oldTempo]  
                else:
                    oldTempo = tempo
                    if (loopCount == 0 and i == 0):
                        tempo += quantum
                        vetorTempos += [tempo]
                        lista[i] -= quantum
                    else:
                        tempo += quantum + trocaContexto
                        vetorTempos += [tempo]
                        lista[i] -= quantum
                    if (lista[i] == 0):
                        vetorProgramas += [oldTempo]
                print "Tempo:", tempo, "Processo:", i, "Valor:", lista[i]

            #print "Final -- Processo:", i+1, "// Tempo:", tempo, "// Valor:", lista[i]
            i += 1

        loopCount += 1

    vetorTempos.remove(vetorTempos[len(vetorTempos)-1])
    print "Tempo final:", vetorProgramas[len(vetorProgramas)-1]
    print "Vetor de tempos:", vetorTempos
    print "Vetor tempos finais de programas:", vetorProgramas

    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j])
    tempo = tempo / len(vetorProgramas)
    print "Tempo medio de turnaround:", tempo

    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j] - vetorTempos[j])
    tempo = tempo / len(vetorProgramas)
    print "Tempo medio de espera:", tempo

   
     
    
listaProgramas = [int(i) for i in raw_input("Digite os tempos de processador dos programas separando por espaço: ").split(" ")]
quantum, trocaContexto = [int(i) for i in raw_input("Digite quantum e fator de troca de contexto separados por espaço: ").split(" ")]
#listaProgramas = [40, 20, 50, 30]
#quantum = 20
#trocaContexto = 5
calcularTempo(listaProgramas, quantum, trocaContexto)

