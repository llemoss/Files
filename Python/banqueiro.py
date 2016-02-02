#-*- coding: cp1252 -*-

E = [4, 2, 3, 1, 2]
A = [2, 1, 0, 1, 0]

C = [[0, 0, 2, 0, 1], #P1
     [1, 0, 1, 0, 1], #P2
     [1, 0, 0, 0, 0], #P3
     [0, 1, 0, 0, 0]] #P4

R = [[2, 0, 0, 1, 1], #P1
     [1, 0, 1, 0, 1], #P2
     [2, 1, 1, 0, 0], #P3
     [1, 1, 0, 0, 1]] #P4


def compare(R, C, E, A):

    if (len(C[0]) == len(E)):
        
        for p in range(len(R)):
            for i in range(len(R[p])):
                if (R[p][i] < A[i]):
                    A[i] += C[p][i]
        
        if A == E:
            return "Programas funcionando corretamente!"
        else:
            return "Deadlock em algum dos programas fornecidos!"

    else:
        return "Tamanhos incompatíveis"

print compare(R, C, E, A)      
