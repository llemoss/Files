x = raw_input("First number: ")
y = raw_input("Second number: ")

while(True):

    resto = []
    resultado = []

    t = range(len(x))

    for i in t:
        if x[i] == "1" and y[i] == "1":
            resto += "1"
            resultado += "0"
        if x[i] == '1' and y[i] == '0' or x[i] == '0' and y[i] == '1':
            resto += "0"
            resultado += "1"
        if x[i] == '0' and y[i] == '0':
            resto += "0"
            resultado += "0"
            
    print "Resto:", resto
    print "Resultado:", resultado

    c = 0
    for item in resto:
        if item == "0":
            c += 1

    if c == len(resto):
        break

    x = resultado
    y = resto
    
