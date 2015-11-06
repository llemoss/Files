print "URI 1150"
X = input()
Z = input()
i = 0
c = X
s = 0
while Z <= X:
    Z = input()
print "Z =", Z
while s <= Z:
    s = s + c
    c = c + 1
    i = i + 1
    print "X =", s
print i
