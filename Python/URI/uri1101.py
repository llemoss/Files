print "URI 1101"
M, N = [int(i) for i in raw_input("").split(" ")]
sl = 0
l = 0
while M > 0 or N > 0:
    if M == 0 or N == 0:
        break
    else:
        if M < N:
            l = range(M, N+1)
            for i in l:
                sl = sl + i
            print ' '.join(map(str, l)), "Sum=%d" % sl
        else:
            l = range(N, M+1)
            for i in l:
                sl = sl + i
            print ' '.join(map(str, l)), "Sum=%d" % sl
        sl = 0
        i = 0
    M, N = [int(i) for i in raw_input("").split(" ")]

