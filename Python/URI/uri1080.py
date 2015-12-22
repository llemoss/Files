print "URI 1080"
i = 0
N = 5
f = range(N)
l = range(N)
while i < N:
	if i != N:
		f[i] = input()
		l[i] = f[i]
	i = i + 1

i = 0
f.sort(reverse=True)
print f[0]
while f[0] != l[i]:
        i = i + 1
        if f[0] == l[i]:
                print i+1
