memoriaSecundaria = []
memoriaPrincipal = []
tamanhoSecundaria = input("Tamanho da memoria secundaria: ")
tamanhoPrimaria = input("Tamanho da memoria primaria: ")
tamanhoPagina = input("Tamanho da pagina: ")

for i in range(tamanhoPrimaria):
    r = [i, i*tamanhoPagina]
    memoriaPrincipal += [r]

for i in range(tamanhoSecundaria):
    r = [i, i*tamanhoPagina]
    memoriaSecundaria += [r]

def mostrarMemoriaReal():
    str = "Memoria real:\n"
    for i in range(len(memoriaPrincipal)):
        str += "[Frame: %d, Endereco: %d ~ %d]\n" % (memoriaPrincipal[i][0], memoriaPrincipal[i][1], (memoriaPrincipal[i][1] + tamanhoPagina - 1))

    print str

def mostrarMemoriaVirtual():
    str = "Memoria virtual:\n"
    for i in range(len(memoriaSecundaria)):
        str += "[Pagina: %d, Endereco: %d ~ %d]\n" % (memoriaSecundaria[i][0], memoriaSecundaria[i][1], (memoriaSecundaria[i][1] + tamanhoPagina - 1))

    print str

def mostrar():
    mostrarMemoriaReal()
    mostrarMemoriaVirtual()

def calcularDeslocamento(end1, endPag):
    return end1 - endPag

def calcularEnderecoReal(endPag, deslocamento):
    return endPag + deslocamento

def calcularPagina(end):
    return end/tamanhoPagina

def enderecoPagina(pagina):
    return tamanhoPagina * pagina

while(True):
    inpt = raw_input()
    if(inpt == ""):
        memoriaSecundaria = []
        memoriaPrincipal = []
        tamanhoSecundaria = input("Tamanho da memoria secundaria: ")
        tamanhoPrimaria = input("Tamanho da memoria primaria: ")
        tamanhoPagina = input("Tamanho da pagina: ")
    else:
        exec(inpt)
