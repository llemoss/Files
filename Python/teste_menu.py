menu = "1 - Load /n 2 - Show /n 3 - Sair"

def menu():
	print menu
	op = input()
	while (op != 3):
                if (op == 1):
                        print "Loading..."
                elif (op == 2):
                        print "Showing..."
                else:
                        print "Opcao invalida."
	print "z"
	op = input()
print "Sessao encerrada."
