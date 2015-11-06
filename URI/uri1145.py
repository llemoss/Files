print "URI 1145"
X, Y = [int(i) for i in raw_input("").split(" ")]
l = range(Y+1)
lx = range(X+1)
i = 1
new_i = []
while i != Y:
    lx = [l[i+i]]
    while len(lx) < X:
        new_i = [l[i+1]]
        lx = lx + new_i
        i = i + 1
    print ' '.join(map(str, lx))
    i = i + X
