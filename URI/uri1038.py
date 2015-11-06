print "URI 1038"
code, quant = [int(i) for i in raw_input("").split(" ")]
if code == 1:
    valor = 4.00*quant
    print "Total: R$ %.2f" % valor
elif code == 2:
    valor = 4.50*quant
    print "Total: R$ %.2f" % valor
elif code == 3:
    valor = 5.00*quant
    print "Total: R$ %.2f" % valor
elif code == 4:
    valor = 2.00*quant
    print "Total: R$ %.2f" % valor
elif code == 5:
    valor = 1.50*quant
    print "Total: R$ %.2f" % valor