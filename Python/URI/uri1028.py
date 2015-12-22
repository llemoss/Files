print "URI 1028"
N = input()
f = 0
for f in range(N):
    F1, F2 = [int(i) for i in raw_input("").split(" ")]
    i = -1
    if F1 > F2:
        while F2 != 0:
            i = F1%F2
            F1 = F2
            F2 = i
            F = F1
    else:
        while F1 != 0:
            i = F2%F1
            F2 = F1
            F1 = i
            F = F2
    
    print F
