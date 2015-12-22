print "URI 1142"
N = input()
i = N*4
f = range(i)
g = 1
for g in f:
    if g%4 == 0:
        print "%d %d %d PUM" % (f[g+1], f[g+2], f[g+3])
    g = g + 1


