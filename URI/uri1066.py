print "URI 1066"
num1 = input()
num2 = input()
num3 = input()
num4 = input()
num5 = input()

iP = 0
iN = 0
iE = 0
iO = 0
#even
if num1%2 == 0:
    iE = iE + 1
if num2%2 == 0:
    iE = iE + 1
if num3%2 == 0:
    iE = iE + 1
if num4%2 == 0:
    iE = iE + 1
if num5%2 == 0:
    iE = iE + 1
#positive
if num1 > 0:
    iP = iP + 1
if num2 > 0:
    iP = iP + 1
if num3 > 0:
    iP = iP + 1
if num4 > 0:
    iP = iP + 1
if num5 > 0:
    iP = iP + 1
#negative
if num1 < 0:
    iN = iN + 1
if num2 < 0:
    iN = iN + 1
if num3 < 0:
    iN = iN + 1
if num4 < 0:
    iN = iN + 1
if num5 < 0:
    iN = iN + 1
#odd
if num1%2 == 1:
    iO = iO + 1
if num2%2 == 1:
    iO = iO + 1
if num3%2 == 1:
    iO = iO + 1
if num4%2 == 1:
    iO = iO + 1
if num5%2 == 1:
    iO = iO + 1

print iE, "valor(es) par(es)"
print iO, "valor(es) impar(es)"
print iP, "valor(es) positivo(s)"
print iN, "valor(es) negativo(s)"
