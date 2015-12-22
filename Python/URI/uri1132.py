M = input()
N = input()
sl = 0
l = 0
if M < N:
    l = range(M, N+1)
    for i in l:
        if i%13 != 0:
            sl = sl + i
    print sl
else:
    l = range(N, M+1)
    for i in l:
        if i%13 != 0:
            sl = sl + i
    print sl

