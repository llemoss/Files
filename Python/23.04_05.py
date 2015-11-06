def cutChar(w, char):
    if len(char) != 1:
        return -1
    wordArray = w.split(char)
    wordVar = ""
    for i in wordArray:
        wordVar += i
    return wordVar

def cutSelf(w):
    cont = 0
    wA = w
    wordB = ""
    for i in w:
        for f in w:
            if i == w:
                cont += 1
                if cont > 1:
                    wordB = cutChar(wA, i)
        cont = 0
    return wordB

w = raw_input("Word: ")
char = raw_input("Char: ")

print cutChar(w, char)
print cutSelf(w)
