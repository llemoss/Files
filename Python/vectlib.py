from math import sqrt as sq
from math import acos as ac
from math import pi

def vectSum(U, V):
    S = []
    if len(U) != len(V):
        return "Vetores incompativeis"
    else:
        for i in range(len(V)):
            S += [(U[i]+V[i])]
    return S

def vectProd(U, V):
    P = 0
    if len(U) != len(V):
        return "Vetores incompativeis"
    else:
        for i in range(len(V)):
            e = (U[i]*V[i])
            P += e
    return P

def vectEsc(U, K):
    P = []
    for i in range(len(U)):
            P += [(U[i]*K)]
    return P

def magnitude(U):
    S = 0
    for e in U:
        S += e*e
    mU = sq(S)
    return mU

def normal(U):
    mU = magnitude(U)
    nU = vectEsc(U, 1.0/mU)
    return nU

def angle(U, V):
    prod = vectProd(U, V)
    if prod == "Vetores incompativeis":
        return "Vetores incompativeis"
    else:
        cos = prod/(magnitude(U)*magnitude(V))
        cos = (180.0*ac(cos))/pi
        return cos

def negative(U):
    U2 = []
    for e in U:
        if e > 0:
            e = -e
            U2 += [e]
        else:
            e = abs(e)
            U2 += [e]
    return U2

def vectX(U, V):
    R = []
    x = 0
    y = 0
    z = 0
    if len(U) != 3 and len(V) != 3:
        return "Operacao invalida, vetor deve ser R3"
    else:
        x = (U[1]*V[2] - U[2]*V[1])
        y = -(U[0]*V[2] - U[2]*V[0])
        z = (U[0]*V[1] - U[1]*V[0])
        R += [x]
        R += [y]
        R += [z]
    return R       
