from math import *

def f(x):
    return sin(x)

def der(x, x0):
    return (f(x)-f(x0))/(x-x0)

def limite(x0):
    precisao = 0.000001
    d = 0.01
    e = 10.0
    L = None
    LD = None
    while e > precisao:
        xE = x0 - d
        xD = x0 + d
        d *= 0.1
        if L != None:
            e = abs(L - f(xE))
        L = f(xE)
        LD = f(xD)
    erroLateral = abs(L-LD)
    if (erroLateral > precisao*2):
        return "Nao ha limite"
    else:
        return "Limite:", (L+LD)/2.0

def derivada(x0):
    precisao = 0.000001
    d = 0.01
    e = 10.0
    dE = None
    dD = None
    while e > precisao:
        xE = x0 - d
        xD = x0 + d
        d *= 0.5
        if dE != None:
            e = abs(dE - der(xE, x0))
        dE = der(xE, x0)
        dD = der(xD, x0)
    erroLateral = abs(dE-dD)
    if (erroLateral > precisao*2):
        return "Indeterminacao"
    else:
        return "Derivada:", (dE+dD)/2.0

print limite(pi/2)
print derivada(pi)
