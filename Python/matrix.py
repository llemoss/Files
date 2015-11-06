'''A = raw_input("A:\n")
exec A
B = raw_input("B:\n")
exec B'''

A = [[1, 2], [3, 4]]
B = [[5, 6], [7, 8]]
AM = len(A)
AN = len(A[0])
BM = len(B)
BN = len(B[0])
print "A:", A
print "B:", B

def matrixSum(A, B):
    erro = "Matrizes incompativeis"
    if len(A) != len(B):
        return erro
    C = [[]]
    i = 0
    iA = 0
    jA = 0
    iB = 0
    jB = 0
    for d in range(AM):
        for e in range(AN):
            C[i] += [A[iA][jA] + B[iB][jB]]
            jA += 1
            jB += 1
        C += [[]]
        i += 1
        iA += 1
        iB += 1
        jA = 0
        jB = 0
    if len(C) > len(A):
        C.__delitem__(len(C)-1)     
    return C

def matrixProd(A, K):
    C = [[]]
    i = 0
    iA = 0
    jA = 0
    for d in range(AM):
        for e in range(AN):
            C[i] += [A[iA][jA]*K]
            jA += 1
        C += [[]]
        i += 1
        iA += 1
        jA = 0
    if len(C) > len(A):
        C.__delitem__(len(C)-1)     
    return C

def det2x2(A):
    if len(A) and len(A[0]) != 2: return "Matriz deve ser 2x2 para este metodo"
    d = (A[0][0]*A[1][1]) - (A[0][1]*A[1][0])
    return d

def det3x3(A):
    iA = 0
    jA = 0
    A[1].remove(A[1][0])
    A[2].remove(A[2][0])
    A.remove(A[0])
    d = ((-1)*(A[iA][jA])*det2x2(A))
    return d

def vectProd(U, V):
    P = 0
    if len(U) != len(V):
        return "Vetores incompativeis"
    else:
        for i in range(len(V)):
            e = (U[i]*V[i])
            P += e
    return P

def vectify(A, Ai=0, Aj=0):
    U = []
    for i in range(len(A)):
        U += [A[Aj][Ai]]
        Ai += 1
        if Ai == len(A[Aj]):
            Aj += 1
        Ai = 0
    return U

def matrixMult(A, B):
    Ci = 0
    Cj = 0
    Aj = 0
    Ai = 0
    Bi = 0
    Bj = 0
    U = []
    V = []
    if len(A) == len(B[0]):
        C = list()
        for i in range(len(B)):
            C += [[]]
        for i in range(4):
            U = vectify(A, Ai, Aj)
            print U
            for i in range(len(B[0])):
                V += [B[Bj][Bi]]
                Bj += 1
                if Bj == len(B[0]):
                    Bi += 1
                    Bj = 0
            Bi = 0
            C[Ci] += [vectProd(U, V)]
            U = []
            V = []
            Ai += 1
            Bj += 1
            if len(C[Ci]) == len(B[0]):
                Ci += 1
        return C
    else:
        return "Matrizes incompativeis"

print matrixMult(A, B)
