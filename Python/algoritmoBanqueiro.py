#-*- coding: cp1252 -*-

E = [4, 2, 3, 1]
A = [2, 1, 0, 0]

C = [[0, 0, 1, 0], #P1
     [2, 0, 0, 1], #P2
     [0, 1, 2, 0]] #P3

R = [[2, 0, 0, 1], #P1
     [1, 0, 1, 0], #P2
     [2, 1, 0, 1]] #P3 // Se o R[3][4] for igual a 1, ocorre deadlock

def verify(R, A):

    count = 0

    if (len(R) == len(A)):
        for i in range(len(A)):
            if (R[i] <= A[i]):
                count+=1
        if (count == len(A)):
            return True
        else:
            return False
    else:
        return None


def sumVect(A, B):
    C = []
    if (len(A) == len(B)):
        for i in range(len(A)):
            C += [A[i] + B[i]]
        return C
    else:
        return None


def compare(R, C, E, A):

    DeadlockVerifier = 0

    if (len(C[0]) == len(E)):

        while(True):

            DeadlockVerifier += 1
            
            if (DeadlockVerifier > len(C)):
                return "Deadlock em algum dos programas fornecidos!"

            count = 0
            p = 0
            
            while(p < len(C)):
                if (verify(R[p], A) == True):
                    A = sumVect(A, C[p])
                    #print "A:", A, "p:", p, "count:", count
                    break
                else:
                    count+=1
                p+=1

            if (count != 0):
                pass
            else:
                if A == E:
                    return "Programas funcionando corretamente!"

    else:
        return "Tamanhos incompatíveis"



print compare(R, C, E, A)      
