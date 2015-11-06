c, p = [str(f) for f in raw_input("").split(" ")]
def find(c, p):
    i = 0
    while i < len(p):
        if p[i] == c:
            f = str(p[i])
            p.replace(f, "")
            i = i + 1
        else:
            i = i + 1
    print p

print find(c, p)
        
