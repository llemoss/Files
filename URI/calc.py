# -*- coding: utf-8 -*-

#BETA 2
print "proj. Calculadora"
print "Digite os numeros no seguinte formato: '1 + 1' com qualquer uma das quatro operacoes.\nDigite 0 em todas as opcoes para parar\ne caso queira manter o valor, digite no formato '+ 2' para complementar"
n1, op, n2 = [str(i) for i in raw_input("> ").split(" ")]
while n1 != "0" or op != "0" or n2 != "0":
    n1 = float(n1)
    n2 = float(n2)
    if op == '+':
        total = n1 + n2
        print "Resultado =", total
    if op == '-':
        total = n1 - n2
        print "Resultado =", total
    if op == '*':
        total = n1 * n2
        print "Resultado =", total
    if op == '/':
        while n2 == 0.0:
            n2 = float(input("Digite um denominador diferente de zero: "))
        total = n1/n2
        print "Resultado =", total
    store = raw_input("Deseja guardar o valor para outra operacao? Y/N\n> ")
    while store != 'n' and store != 'N' and store != 'y' and store != 'Y':
        store = raw_input("Deseja guardar o valor para outra operacao? Y/N\n> ")
    if store == "N" or store == "n":
        total = 0
        n1, op, n2 = [str(i) for i in raw_input("> ").split(" ")]
    if store == "Y" or store == "y":
        n1 = total
        op, n2 = [str(i) for i in raw_input("> ").split(" ")]
else:
    fim = raw_input("Enter para terminar o programa.\n")
