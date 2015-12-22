print "URI 1099"
i = 0
h = 0
f = 0
N = input()
X = range(N)
Y = range(N)
while i < N:
    if i != N:
        X[i], Y[i] = [int(g) for g in raw_input("").split(" ")]
    if X[i] > Y[i]:
        f=Y[i]+1
        while f < X[i]:
            if f%2 != 0:
                h = h + f
            f = f + 1
    elif Y[i] > X[i]:
        f=X[i]+1
        while f < Y[i]:
            if f%2 != 0:
                h = h + i
            f = f + 1
    print "%d" % (h)
    h = 0
    f = 0
    i = i + 1
