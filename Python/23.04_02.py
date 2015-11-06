c, p = [str(f) for f in raw_input("").split(" ")]
def find(c, p):
    s = 0
    i = 0
    while i < len(p):
        if p[i] == c:
            s = s + 1
            i = i + 1
        else:
            i = i + 1
    return s

print find(c, p)
        
