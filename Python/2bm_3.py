lista = [6, 3, 4, 1, 5, 7, 9, 10, 2, 8]
def bubbleSort(lista):
	for i in range(len(lista)):
		for i in range(len(lista)-1):
			if lista[i] > lista[i+1]:
				a = lista[i+1]
				lista[i+1] = lista[i]
				lista[i] = a
	return lista

print bubbleSort(lista)
