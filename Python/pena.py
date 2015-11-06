#crime = raw_input("Crime: ")
crime = "Homicidio contra parente"
print "Calculo de Pena para:", crime

if crime == "Homicidio contra parente":
    penMin = 6.0
    penMax = 24.0

peso = (penMax-penMin)/8.0
print "Peso de cada circunstancia:", peso

f = input("Circunstancias favoraveis: ")
d = input("Circunstancias desfavoraveis: ")

if f > d:
    c = d*peso
if d > f:
    c = f*peso

penaBase = penMax-c

maxmin = raw_input("Bonus max. (1/3) ou bonus min. (1/6)? ")
if maxmin == "1/3":
    bonus = 1.0/3.0
if maxmin == "1/6":
    bonus = 1.0/6.0

bonusF = bonus*penaBase
bonusD = -(bonus)*penaBase

penaFinal = 0

N = input("Quantidade de causas extras: ")
i = 0
f = range(N)
while i < N:
    if i != N:
        f[i] = float(input("Valor da causa: "))
        ad = raw_input("Causas de aumento ou diminuicao? A/D: ")
        if ad == "A":
            penaFinal += bonusF + bonusD + f[i] + penaBase
        elif ad == "D":
            penaFinal += bonusF + bonusD + f[i] - penaBase
    i = i + 1

'''
vAD = input("Valor da causa:")
ad = input("Causas de aumento ou diminuicao? A/D: ")
if ad == "A":
    penaFinal += bonusF + bonusD + vAD + penaBase
elif ad == "D":
    penaFinal += bonusF + bonusD + vAD - penaBase
'''

print "Pena final:", penaFinal
