# -*- coding: cp1252 -*-
print "Digite as notas separadas por espaço: "
N1, N2, N3, N4 = [float(i) for i in raw_input("").split(" ")]
materia = raw_input("Matéria: ")
media = (N1*2 + N2*3 + N3*4 + N4*1)/10
print "Media: %.1f" % media
if media >= 7.0:
	print "Aluno aprovado."
elif media < 5.0:
	print "Aluno reprovado."
else:
	print "Aluno em exame. Digite abaixo a nota do exame:"
	exame = float(input())
	final = (media+exame)/2
	if final >= 5.0:
		print "Aluno aprovado em", materia
		print "Media final: %.1f" % final
	elif (media+exame)/2 <= 4.9:
		print "Aluno reprovado em", materia
		print "Media final: %.1f" % final
