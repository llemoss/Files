# -*- coding: utf-8 -*-
print "URI 1010"
code1, quant1, price1 = [float(i) for i in raw_input("").split(" ")]
code2, quant2, price2 = [float(i) for i in raw_input("").split(" ")]
code1 = int(code1)
code2 = int(code2)
quant1 = int(quant1)
quant2 = int(quant2)
total = (quant1 * price1) + (quant2 * price2)
print "VALOR A PAGAR: R$ %.2f" % total