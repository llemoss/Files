print "Salario do funcionario com bonus de 15%"
employeeName = raw_input("Nome do funcionario: ")
employeeSalary = input("Salario do funcionario: ")
employeeSold = input("Valor vendido: ")
bonusAmount = employeeSold * 0.15
salary = employeeSalary + bonusAmount
print "TOTAL = R$ %.2f" % salary
