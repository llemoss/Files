print "URI 1116"
N = input()
i = 0
for i in range(N):
    x, y = [int(i) for i in raw_input("").split(" ")]
    if y == 0:
        print "divisao impossivel"
        pass
    else:
        x = float(x)
        y = float(y)
        d = x/y
        print "%.1f" % d
