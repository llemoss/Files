print "URI 1155"
S = 0
for i in range(1, 101):
    S += 1.0 / i
    if i == 100:
        print "%.2f" % S