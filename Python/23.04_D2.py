S = "x"
N = input("Numero de digitos a pular: ")
S = S.upper()
L = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
S1 = []
S2 = []
for c in S:
    for i in L:
        if i == c:
            S1 = S1 + [L.index(i)]
for f in range(len(S1)):
    S1[f] += N
for c in S1:
    for l in L:
        if c == L.index(l):
            S2 = S2 + [l]
print "Palavra criptografada: " + ''.join(map(str, S2))#.lower()
