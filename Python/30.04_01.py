def not_e():
    i = 0
    fin = open('words.txt')
    l = fin.readline()
    for l in fin:
        if "e" in l:
            i += 1
    return i

def avoid():
    p = raw_input("Letra ou conjunto de letras: ")
    i = 0
    fin = open('words.txt')
    l = fin.readline()
    for l in fin:
        if p not in l:
            i = i + 1
    return i

def uses_only(l, c):
    for i in l:
        if not i in c:
            return False
    return True

l = raw_input("Palavra: ")
c = raw_input("Apenas: ")
print uses_only(l, c)
