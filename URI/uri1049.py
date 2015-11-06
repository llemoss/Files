print "URI 1049"
ossos = raw_input()
filo = raw_input()
alim = raw_input()
if ossos == "vertebrado":
    if filo == "ave":
        if alim == "carnivoro":
            print "aguia"
        if alim == "onivoro":
            print "pomba"
    if filo == "mamifero":
        if alim == "onivoro":
            print "homem"
        if alim == "herbivoro":
            print "vaca"
elif ossos == "invertebrado":
    if filo == "inseto":
        if alim == "hematofago":
            print "pulga"
        if alim == "herbivoro":
            print "lagarta"
    if filo == "anelideo":
        if alim == "hematofago":
            print "sanguessuga"
        if alim == "onivoro":
            print "minhoca"
