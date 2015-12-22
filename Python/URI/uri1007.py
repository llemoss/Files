print "Valor 1 * Valor 2 - Valor 3 * Valor 4"
valor1, valor2, valor3, valor4 = [int(i) for i in raw_input("Digite os quatro valores separados por espaco: ").split(" ")]
dif = (valor1 * valor2 - valor3 * valor4)
print "DIFERENCA =", dif
