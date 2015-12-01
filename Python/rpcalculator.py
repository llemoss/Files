
while(True):
    N = input("Quantia de RP: ")
    print "Metodos: D = Dinheiro // C = Creditos"

    while(True):
        metodo = raw_input("Escolha: ")
        if metodo == "D" or metodo == "d":
            valor = float(N/65.0)
            print "%d RPs resultam em R$ %.2f" % (N, valor)
            break
        elif metodo == "C" or metodo == "c":
            valor = float(N/36.0)
            print "%d RPs resultam em R$ %.2f" % (N, valor)
            break
        else:
            print "Escolha um metodo de pagamento valido!"

    while(True):
        escolha = raw_input("Deseja fazer mais uma consulta? Y/N - ")
        if escolha == "y" or escolha == "Y":
            print "\n"
            break
        elif escolha == "n" or escolha == "N":
            break
        else:
            print "Faca uma escolha valida!"

    if escolha == "n" or escolha == "N":
        break
