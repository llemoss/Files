print "Ex. 9"
N = input()
print "NOTAS:"
for i in [100.00, 50.00, 20.00, 10.00, 5.00, 2.00]:
	ced = N/i
	N = N%i
	print "%d nota(s) de R$ %.2f" % (ced, i)
i = 0
print "MOEDAS:"
for i in [1.00, 0.50, 0.25, 0.10, 0.05, 0.01]:
	ced = N/i
	N = N%i
	print "%d moeda(s) de R$ %.2f" % (ced, i)
a = input()
