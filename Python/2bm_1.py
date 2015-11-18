#20 25 85 40 25 90 25 40 55 40 25
notas = "20 25 85 40 25 90 25 40 55 40"
notas = notas.split(" ")

for i in range(len(notas)):
        notas[i] = int(notas[i])

notas.sort()

print notas

def count(l):
        c = 0
        oldC = 0
        for i in l:
                if c >= oldC:
                        oldC = c
                c = 0
                for e in l:
                        if i == e:
                                c+=1
                if c >= oldC: 
                        counted = i
                        print "Valor mais repetido:", counted
                        print "Vezes repetida:", c
        print "\n"
        resultado = "Maior e mais repetido valor: %d" % counted
        return resultado

print count(notas)
