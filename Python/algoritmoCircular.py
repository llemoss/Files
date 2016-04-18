# -*- coding: cp1252 -*-

def _cmp_by_program(x, y):
    return cmp(x[0], y[0])

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
                        vetorProgramas += [[i+1, tempo]]  
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
                        vetorProgramas += [[i+1, tempo]]

                print "Tempo:", tempo, "Processo:", i, "Valor:", lista[i]

            #print "Final -- Processo:", i+1, "// Tempo:", tempo, "// Valor:", lista[i]
            i += 1

        loopCount += 1

    vetorProgramas.sort(_cmp_by_program)
    print "Tempo final:", vetorProgramas[len(vetorProgramas)-1][1]
    print "Vetor de tempos:", vetorTempos
    print "Vetor tempos finais de programas:", vetorProgramas

    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j][1] - vetorTempos[j])
    tempo = tempo / len(vetorProgramas)
    print "Tempo medio de espera:", tempo

    
    tempo = 0
    for j in range(len(vetorProgramas)):
        tempo += float(vetorProgramas[j][1])
    tempo = tempo / len(vetorProgramas)
    print "Tempo medio de turnaround:", tempo

   
     
    
#listaProgramas = [int(i) for i in raw_input("Digite os tempos de processador dos programas separando por espaço: ").split(" ")]
#quantum, trocaContexto = [int(i) for i in raw_input("Digite quantum e fator de troca de contexto separados por espaço: ").split(" ")]
listaProgramas = [12, 16, 7, 9]
quantum = 6
trocaContexto = 3
calcularTempo(listaProgramas, quantum, trocaContexto)

