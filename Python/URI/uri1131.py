novo = 1
j = 0
InV = 0
GrV = 0
Em = 0
while novo == 1:
    In, Gr = [int(i) for i in raw_input("").split(" ")]
    j = j + 1
    if In > Gr:
        InV = InV + 1
    elif In == Gr:
        Em = Em + 1
    else:
        GrV = GrV + 1
    novo = input("Novo grenal (1-sim 2-nao)\n")
    while (novo > 1 and novo != 2) or novo < 1:
        novo = input("Novo grenal (1-sim 2-nao)\n")
    if novo == 2:
        print "%d grenais" % j
        print "Inter:%d" % InV
        print "Gremio:%d" % GrV
        print "Empates:%d" % Em
        if InV > GrV:
            print "Inter venceu mais"
        elif InV == GrV:
            print "Nao houve vencedor"
        else:
            print "Gremio venceu mais"
        
