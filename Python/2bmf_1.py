#nome;q1;q2;q3;q4;q5;q6;q1;q2;q3;q4;q5;q6
#0;1;2;3;4;5;6;7;8;9;10;11;12
arquivo = open("correcao_prova.csv")
import os
listaNotas = []
for i in arquivo: listaNotas.append(i.strip().split(";"))

def convertToGrade(string):
        tamanho = len(string)
        resultado = ""
        i = 0
        while(True):
                if string[i] == "%":
                        break
                else:
                        resultado += string[i]
                        i += 1
        resultado = float(resultado) * 0.01
        return resultado

def calcGrade(lista):
        peso1 = 1.00
        peso2 = 2.00
        peso3 = 3.00
        pesoT = 0.30
        pesoP = 0.70
        for i in lista:
                teorica = 0.00
                pratica = 0.00
                nota = 0.00
                teorica = convertToGrade(lista[1])*peso1 + convertToGrade(lista[2])*peso1 + convertToGrade(lista[3])*peso1 + convertToGrade(lista[4])*peso2 + convertToGrade(lista[5])*peso2 + convertToGrade(lista[6])*peso3
                teorica = teorica*pesoT
                pratica = convertToGrade(lista[7])*peso1 + convertToGrade(lista[8])*peso1 + convertToGrade(lista[9])*peso1 + convertToGrade(lista[10])*peso2 + convertToGrade(lista[11])*peso2 + convertToGrade(lista[12])*peso3
                pratica = pratica*pesoP
                nota = teorica + pratica
        return nota


listaResultados = []

for i in range(len(listaNotas)):
        aluno = []
        aluno.append(listaNotas[i][0])
        nota = calcGrade(listaNotas[i])
        aluno.append(nota)
        situacao = ""
        if nota >= 7.00:
                situacao = "APROVADO"
        elif nota <= 4.00:
                situacao = "REPROVADO"
        else:
                situacao = "PROVA FINAL"
        aluno.append(situacao)
        listaResultados.append(aluno)

def cmp_by_grade(x, y): return cmp(x[1], y[1])

listaResultados.sort(cmp_by_grade)
        
for i in listaResultados:
        print "Nome: %s -- Nota: %.2f -- Situacao: %s" % (i[0], i[1], i[2])
