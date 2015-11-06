# -*- coding: cp1252 -*-

'''

Gildasio de Lima Chagas Filho

'''

#Limite = for E > 0 and d > 0: L in range(d) if |f(x) - L| < E and 0 < |x-x0| < d
#Derivada = (f(x)-f(x0))/(x-x0) || (f(x+deltax)-f(x0))/deltax

'''
Utilizar apenas se Numpy e Matplotlib instalados e retirar os comentarios
marcados com *
'''

from math import sqrt
#*import numpy as np  
#*import matplotlib.pyplot as plt

t = "n"

print "Calculo de Derivada e Limite"

def der(x):
    dx = 0.01 #Precisao
    erro = 0.1
    try:
        derB = (f(x+dx)-f(x))/dx
        while erro > dx:
            if erro > 1e-05:
                dx *= 0.01
            else:
                dx *= 0.1
            derA = (f(x+dx)-f(x))/dx
            erro = abs(derA - derB)
            derB = derA
        return "Derivada:", derB
    except:
        return "Indeterminacao"
    

def lim(x0):
    e = 0.01 #Precisao
    try:
        L = abs((f(x0+e)+f(x0-e))/2)
        return "Limite:", L
    except:
        return "Nao ha limite"


def graf(intervalo):  
    x = np.array(intervalo)  
    y = f(x)
    plt.plot(x, y)
    plt.plot(x, f(x), marker="o")
    plt.show()

i = 0
while t == "n" or t == "N":
    if i <= 0:
        function = raw_input("Digitar funcao no formato, em uma linha:\ndef f(x): return x*x\n")
    elif (g == "n" or g == "N") and i == 1:
        function = raw_input("Digitar a funcao:\n")
    exec function
    x0 = float(input("x0: "))
    print der(x0)
    print lim(x0)
    #*graf(range(-10, 10))
    t = raw_input("Terminar? y/n\n")
    if t == "y" or t == "Y":
        break
    else:
        g = raw_input("Guardar funcao para outro calculo? y/n\n")
        if g == "n" or g == "N":
            pass
        i = 1
