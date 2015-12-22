print "URI 1070"
X = input()
f = 0
if X%2 == 0:
    X = X + 1
    print X
    while f < 5:
        X = X + 2
        f = f + 1
        print X

else:
    while f < 6:
        X = X + 2
        f = f + 1
        print X
