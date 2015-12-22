print "URI 1051"
salary = float(input())
tax = (salary - 2000.00)
tax1 = (salary - 3000.00)
tax2 = (salary - 4500.00)
if salary <= 2000.00 and salary >= 0:
    print "Isento"
elif salary >= 2000.01 and salary <= 3000.00:
    print "R$ %.2f" % (tax * 0.08)
elif salary >= 3000.01 and salary <= 4500.00:
    print "R$ %.2f" % ((tax1 * 0.18) + (1000.00 * 0.08))
elif salary >= 4500.01:
    print "R$ %.2f" % ((tax2 * 0.28) + (1000.00 * 0.08) + (1500.00 * 0.18))
