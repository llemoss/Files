# -*- coding: cp1252 -*-
import numpy as np  
import matplotlib.pyplot as plt

t = "n"

def f(x):
    return x*x

def grafico_funcao(intervalo):  
    x = np.array(intervalo)  
    y = f(x)
    plt.plot(x, y)
    plt.plot(1, f(1), marker='o')  
    plt.show()

def der(x):
    x0 = x
    dx = 0.1
    d = (f(x0+dx)-f(x0))/dx
    return d

while t == "n":
    x = float(input("x: "))
    res = der(x)
    print res
    grafico_funcao(range(-10, 10))
    t = raw_input("Terminar? y/n\n")
    if t == "y":
        break
