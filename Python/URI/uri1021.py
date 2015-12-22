print "URI 1021"
N = float(input())
notas = 0
moedas = 0
i = 0
f = 0
print "NOTAS:"
for i in [100.00, 50.00, 20.00, 10.00, 5.00, 2.00]:
	notas = N/i
	N = N % i
	notas = int(notas)
	print "%d nota(s) de R$ %.2f" % (notas, i)
N = N % i
print "MOEDAS:"
for f in [1.00, 0.50, 0.25, 0.10, 0.05, 0.01]:
	moedas = N/f
	N = N % f
	moedas = int(moedas)
	print "%d moeda(s) de R$ %.2f" % (moedas, f)