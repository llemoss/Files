print "URI 1144"
N = input()
f = range(N+1)
i = 0
while i < N:
    print "%d %d %d" % (f[i+1]**1, f[i+1]**2, f[i+1]**3)
    print "%d %d %d" % (f[i+1]**1, (f[i+1]**2)+1, (f[i+1]**3)+1)
    i = i + 1


