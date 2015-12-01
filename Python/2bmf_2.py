#id#proprietario#cpf#membro1,membro2,membro3#tipoderenda#valor
arquivo = open("bolsafamilia.txt")
import os
listaFamilias = []
for i in arquivo: listaFamilias.append(i.strip().split(";"))
for i in range(len(listaFamilias)): 
	listaFamilias[i][0] = int(listaFamilias[i][0])
	listaFamilias[i][2] = int(listaFamilias[i][2])
	listaFamilias[i][3] = listaFamilias[i][3].split(",")
	listaFamilias[i][5] = int(listaFamilias[i][5])

def menu():
	print "--------- BOLSA FAMILIA ----------"
	print "1 - Mostrar todas as familias cadastradas"
	print "2 - Consultar por nome de proprietario"
	print "3 - Consultar por CPF"
	print "4 - Consultar por tipo de renda"
	print "5 - Alteracao de dados via ID"
	print "6 - Delecao de dados via ID"
	print "7 - Cadastrar nova familia"
	print "0 - Sair do programa e salvar arquivo com alteracoes"
	print "-----------------------------------"

cabecalho = "ID -- Proprietario -- CPF -- Qtd. membros -- Tipo de Renda -- Valor recebido"
cabecalhoAlt = "ID (0) -- Proprietario (1) -- CPF (2) -- Membros (3) -- Tipo de Renda (4) -- Valor recebido (5)"

def consulta(coluna, var):
	resultado = ""
	for i in listaFamilias:
		if i[coluna] == var:
			resultado += "%d -- %s -- %d -- %d -- %s -- %d\n" % (i[0], i[1], i[2], len(i[3]), i[4], i[5])
	return resultado

while(True):
	menu()
	inp = input("Digite o item: ")
	if inp == 1:
		print "\n"
		print cabecalho 
		for i in listaFamilias:
			print "%d -- %s -- %d -- %d -- %s -- %d" % (i[0], i[1], i[2], len(i[3]), i[4], i[5])
		print "\n"
	if inp == 2:
		nome = raw_input("Digite o nome: ")
		print "\n"
		print cabecalho
		if consulta(1, nome) != "": 
			print consulta(1, nome)
		else:
			print "Nome nao encontrado"
		print "\n"
	if inp == 3:
		cpf = input("Digite o cpf: ")
		print "\n"
		print cabecalho
		if consulta(2, cpf) != "": 
			print consulta(2, cpf)
		else:
			print "CPF nao encontrado"
		print "\n"
	if inp == 4:
		tipo = raw_input("Digite o tipo de renda: ")
		print "\n"
		print cabecalho
		if consulta(4, tipo) != "": 
			print consulta(4, tipo)
		else:
			print "Nao ha familias desse tipo de renda (ou tipo de renda nao existe)"
		print "\n"
	if inp == 5:
		idInp = input("Digite ID a alterar: ")
		print "\n"
		print cabecalhoAlt
		if consulta(0, idInp) != "": 
			print consulta(0, idInp)
			for i in listaFamilias: 
				if i[0] == idInp: 
					indice = listaFamilias.index(i)
			alteracao = input("Digite coluna a ser alterada: ")
			if alteracao in [0, 2, 5]: 
				listaFamilias[indice][alteracao] = input("Digite alteracao a ser feita: ")
			elif alteracao in [1, 4]: 
				listaFamilias[indice][alteracao] = raw_input("Digite alteracao a ser feita: ")
			elif alteracao == 3:
				print listaFamilias[indice][alteracao]
				listaFamilias[indice][alteracao] = raw_input("Digite alteracao nos membros com nomes separados por ',': ")
				listaFamilias[indice][alteracao] = listaFamilias[indice][alteracao].split(",")
				print "Novos membros:", listaFamilias[indice][alteracao]
		else:
			print "ID nao encontrado"
		print "\n"
	if inp == 6:
		idInp = input("Digite ID a deletar: ")
		print "\n"
		if consulta(0, idInp) != "": 
			print consulta(0, idInp)
			for i in listaFamilias: 
				if i[0] == idInp: 
					indice = listaFamilias.index(i)
			listaFamilias.remove(listaFamilias[indice])
			print "Familia de ID (%d) foi removida" % idInp
		else:
			print "ID nao encontrado"
		print "\n"
	if inp == 7:
		print "Formato: ID;Proprietario;CPF;Membros (separados apenas por virgula);Tipo de Renda;Valor da renda"
		novaFamilia = raw_input("Digite a familia a ser adicionada: ")
		listaFamilias.append(novaFamilia.split(";"))
		if novaFamilia != "":
			i = len(listaFamilias)-1
			listaFamilias[i][0] = int(listaFamilias[i][0])
			listaFamilias[i][2] = int(listaFamilias[i][2])
			listaFamilias[i][3] = listaFamilias[i][3].split(",")
			listaFamilias[i][5] = int(listaFamilias[i][5])
			print "\n"
			print cabecalho
			print "%d -- %s -- %d -- %d -- %s -- %d\n" % (listaFamilias[i][0], listaFamilias[i][1], listaFamilias[i][2], len(listaFamilias[i][3]), listaFamilias[i][4], listaFamilias[i][5])
	if inp == 0:
		os.system("rm bolsafamilia.txt")
		arquivo = open("bolsafamilia.txt", "w")
		conteudo = ""
		for i in listaFamilias:
			a = ""
			membros = ""
			for e in i[3]: 
				a += e
				a += ","
			for j in range(len(a)-1): membros += a[j]
			conteudo += "%s;%s;%s;%s;%s;%s\n" %  (str(i[0]), i[1], str(i[2]), membros, i[4], str(i[5]))
		arquivo.write(conteudo)
		print "Arquivo salvo com sucesso"
		break
