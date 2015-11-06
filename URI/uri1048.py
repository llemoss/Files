print "URI 1048"
salary = float(input())

if salary >= 0 and salary <= 400.00:
    percent = 0.15
    gain = salary * percent
    print "Novo salario: %.2f" % (salary + gain)
    print "Reajuste ganho: %.2f" % gain
    print "Em percentual: 15 %"
elif salary >= 400.01 and salary <= 800.00:
    percent = 0.12
    gain = salary * percent
    print "Novo salario: %.2f" % (salary + gain)
    print "Reajuste ganho: %.2f" % gain
    print "Em percentual: 12 %"
elif salary >= 800.01 and salary <= 1200.00:
    percent = 0.1
    gain = salary * percent
    print "Novo salario: %.2f" % (salary + gain)
    print "Reajuste ganho: %.2f" % gain
    print "Em percentual: 10 %"
elif salary >= 1200.01 and salary <= 2000.00:
    percent = 0.07
    gain = salary * percent
    print "Novo salario: %.2f" % (salary + gain)
    print "Reajuste ganho: %.2f" % gain
    print "Em percentual: 7 %"
elif salary > 2000.00:
    percent = 0.04
    gain = salary * percent
    print "Novo salario: %.2f" % (salary + gain)
    print "Reajuste ganho: %.2f" % gain
    print "Em percentual: 4 %"