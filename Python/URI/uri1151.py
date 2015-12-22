print "URI 1151"
N = input()
i = 0
f = [0, 1]
while len(f) < N:
    it = [f[i]+f[i+1]]
    f = f + it
    i += 1
print ' '.join(map(str, f))
