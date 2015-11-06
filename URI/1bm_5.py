print "Ex. 5"
senha = 2002
t = input()
i = 0
while t != 2002:
	print "Senha Invalida"
	t = input()
	i = i + 1
	if i == 2 and t != 2002:
		print "Acesso Negado"
		break
else:
	print "Acesso Permitido"
