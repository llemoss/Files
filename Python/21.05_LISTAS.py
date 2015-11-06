v = [1, 3, 7, 8, 4, 0]

def maior(v):
    i = 0
    for o in range(len(v)):
        m = v[i]
        e = v[i+1]
        if e > m:
            m = e
            i += 1
        else:
            pass
    return m

print maior(v)

def order(v, reverse=False):
    if reverse == False:
        for i in range(len(v)-1):
            t = 0
            for j in range(len(v)-1):
                if v[j] > v[j+1]:
                    a = v[j]
                    v[j] = v[j+1]
                    v[j+1] = a
                    t += 1
            if t == 0:
                break
    if reverse == True:
        t = 0
        for i in range(len(v)-1):
                t = 0
                for j in range(len(v)-1):
                    if v[j] < v[j+1]:
                        a = v[j]
                        v[j] = v[j+1]
                        v[j+1] = a
                        t += 1
                if t == 0:
                    break
    return v
'''
v2 = []
for i in range(len(v)):
    v2 += [0]
print v2
'''
print order(v, reverse = True)
