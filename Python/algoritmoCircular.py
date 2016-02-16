# -*- coding: cp1252 -*-

def tempoMedioTurnaround(lista, quantum, trocaContexto):
    origQuantum = quantum
    tempo = 0
    loopCount = 0
    vetorTempos = []
    vetorProgramas = []
    while(True):
        
        count = 0;
        for j in range(len(lista)):
            if (lista[j] == 0):
                    count += 1
        #print "Count:", count
        #print "Loop count:", loopCount
        if (count == len(lista)):
            break

        i = 0
        while(i < len(lista)):
            
            #print "Começo -- Processo:", i+1, "// Tempo:", tempo, "// Valor:", lista[i]

            if (lista[i] > 0):
                
                if ((lista[i] - quantum) < 0):
                    if (loopCount == 0 and i == 0):
                        tempo += lista[i]
                        vetorTempos += [tempo]
                        lista[i] = lista[i] - quantum
                    else:
                        tempo += lista[i] + trocaContexto
                        vetorTempos += [tempo]
                        lista[i] = lista[i] - lista[i]

                    if (lista[i] == 0):
                        vetorProgramas += [tempo]
                        
                else:
                    if (loopCount == 0 and i == 0):
                       vetorTempos += [0]
                       tempo += quantum
                       vetorTempos += [tempo]
                       lista[i] = lista[i] - quantum
                    else:
                        tempo += quantum + trocaContexto
                        vetorTempos += [tempo]
                        lista[i] = lista[i] - quantum
                        
                    if (lista[i] == 0):
                        vetorProgramas += [tempo]

            #print "Final -- Processo:", i+1, "// Tempo:", tempo, "// Valor:", lista[i]
            i += 1

        loopCount += 1

    tempo = 0
    for j in range(len(vetorProgramas)):
        print "tempo +=", vetorProgramas[j], "-", vetorTempos[j]
        tempo += float(vetorProgramas[j] - vetorTempos[j])

    print tempo
    tempo = tempo / len(vetorProgramas)
    print "Tempo medio de turnaround (metodo subtracao):", tempo

    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j])
    
    tempo = tempo / len(vetorProgramas)
    print "Tempo medio de turnaround (metodo usando tempos finais):", tempo

    print "Tempo final:", vetorProgramas[len(vetorProgramas)-1]
    print "Vetor de tempos:", vetorTempos
    print "Vetor tempos finais de programas:", vetorProgramas
     
    #tempo = ((tempo - trocaContexto) / len(lista))
        
    #return tempo
    
#listaProgramas = [int(i) for i in raw_input("Digite os tempos de processador dos programas separando por espaço: ").split(" ")]
#quantum, trocaContexto = [int(i) for i in raw_input("Digite quantum e fator de troca de contexto separados por espaço: ").split(" ")]
listaProgramas = [40, 20, 50, 30]
quantum = 20
trocaContexto = 5
turnaround = tempoMedioTurnaround(listaProgramas, quantum, trocaContexto)
#print "Tempo medio de turnaround:", turnaround

