#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int listaFib[200];

//O(n²)
int fibRec(int n){
	int result = 0;
	if (n == 0 || n == 1){
		return n;
	}else{
		result = fibRec(n-1) + fibRec(n-2);
		return result;
	}
}

//O(n)
void fibNonRec(int n){
	int aux, ant, i;
	aux = 0;
	ant = 1;
	for (i = 0; i < 10; i++){
		aux += ant;
		ant = aux - ant;
		listaFib[i] = aux;
	}
	
}


int main(){
	int i, n;
	scanf("%d", &n);
	fibNonRec(n);
	printf("Nao recursiva: ");
	for(i = 0; i < n; i++){
		printf("%d ", listaFib[i]);
	}
	
	//main() só está executando o não recursivo, o recursivo precisa de printf("%d", fibRec(n))
	//e não mostra lista
}