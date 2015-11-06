M = input()
N = input()
l = 0
if M < N:
    l = range(M, N)
    for i in l:
        if i%5 == 2 or i%5 == 3:
            print i
else:
    a = M
    M = N
    N = a
    l = range(M, N)
    for i in l:
        if i%5 == 2 or i%5 == 3:
            print i

