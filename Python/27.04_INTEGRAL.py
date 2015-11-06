'''
f(a*k-1*Ax)*Ax = A
'''

t = "n"
def f(x):
    return x*x #funcao que for

def area(a, b, k):
    Ax = (b-a)/k #tamanho do intervalo sobre quantidade de intervalos
    A = 0.0
    for i in range(k): #de zero ate k-1
        A += f((a+i*Ax)*Ax)
    return A

def area_p(a, b):
    precisao = 0.01
    k = 10
    erro = 10
    areaAnterior = area(a, b, k)
    while erro > precisao:
        k += 10
        areaAtual = area(a, b, k)
        erro = abs(areaAtual - areaAnterior)
        areaAnterior = areaAtual
        print "k:", k, "erro:", erro
    return areaAnterior

while t == "n":
    a = float(input("a: "))
    b = float(input("b: "))
    res = area_p(a, b)
    print res
    t = raw_input("Terminar? y/n\n")
    if t == "y":
        break
