p = [str(g) for g in raw_input("").split(" ")]
def find(p):
    s = 0
    i = 0
    f = 0
    for a in p:
        if p[i] == p[f]:
            s = s + 1
            f = f + 1
        else:
            f = f + 1
    print s

find(p)
