print "URI 1018"
N = input()
notas = 0
i = 0
ced = [100, 50, 20, 10, 5, 2, 1]
while N > 1000000 or N < 0:
    N = input()

while i < 7:
    notas = N/ced[i]
    N = N%ced[i]
    print "%d nota(s) de R$ %d,00" % (notas, ced[i])
    i = i + 1
