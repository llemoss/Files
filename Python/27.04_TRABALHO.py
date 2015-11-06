# -*- coding: cp1252 -*-
#fomos idiotas
def floatify(number, times):
    i = number
    V = []
    
    while i > 0.0:
       V.append(i) 
       i = i - times
       
    return V

t = "n"

def f(x):
    return x*x #funcao que for

def lim(x0, v):
    x = 1.0
    y1 = floatify(f(x+v), v) #Calculo de um ponto de referencia positivo f(x) + E
    y2 = floatify(f(x-v), v) #Calculo de um ponto de referencia negativo f(x) - E
    for i in y1:
        for g in y2:
            if i == g:
                y1.remove(i)
    rY = y1
    d1 = floatify((x0+v), v)
    d2 = floatify((x0-v), v)
    for j in d1:
        for h in d2:
            if j == h:
                d1.remove(j)
    rX = d1
    mX = 0.0
    mY = 0.0
    for p1 in rX: 
        mX += p1
    mX = mX/float(len(rX))
    for p2 in rY:
        mY += p2
    mY = mY/float(len(rY))
    m = (mX + mY)/2.0
    return "%.f" % m

while t == "n":
    x0 = float(input("x0: "))
    v = float(input("Variaacao (E, delta): "))
    res = lim(x0, v)
    print res
    t = raw_input("Terminar? y/n\n")
    if t == "y":
        break
