print "URI 1071"
X = input()
Y = input()
i = 0
f = 0

if X > Y:
    i=Y+1
    while i < X:
        if i%2 != 0:
            f = f + i
        i = i + 1
elif Y > X:
    i=X+1
    while i < Y:
        if i%2 != 0:
            f = f + i
        i = i + 1
        
print "%d" % (f)
