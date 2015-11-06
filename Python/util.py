N = input()
i = 0
f = range(N)
while i < N:
	if i != N:
		f[i] = input()
	i = i + 1
i = 0
while i < N:
	#inserir codigo a ser usado com f[i]
	i =  i + 1
'''	
#OU
'''
for i in range(N):
	f[i] = input()
	#inserir codigo a ser usado com f[i]
	
#LISTA DE CODIGOS UTEIS

h1, m1, s1 = [int(i) for i in raw_input("").split(" ")]	#codigo para receber mais de um input na mesma linha
"%d, abc, %d" % (variavel, variavel2) #para mais de uma variavel em uma linha
#Codigos GIT-HUB
git push origin master
git remote add origin <servidor>

#Codigo para percorrer vetor de tras pra frente
for i in p[::-1]:
        print i
