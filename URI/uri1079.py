print "URI 1079"
N = input()
i = 0
for i in range(N):
        a, b, c = [float(f) for f in raw_input("").split(" ")]
        ave = (a*2.0 + b*3.0 + c*5.0)/10.0
        print "%.1f" % ave
        i =  i + 1

