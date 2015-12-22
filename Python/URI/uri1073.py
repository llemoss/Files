print "URI 1073"
X = input()
f = 0
while X < 5 and X > 2000:
    X = input()
X = X + 1
for i in range(X):
    if i%2 == 0 and i != 0:
        f = i**2
        print "%d^2 = %d" % (i, f)