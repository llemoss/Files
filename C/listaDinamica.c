#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct elemento{
	int mat;
	char nome[20];
	elemento *prox;
}Elemento;

int main(){
	
	Elemento *novo;
	//Alocar memoria ao elemento
	novo = (Elemento *)malloc(sizeof(Elemento));
	novo->mat=1;
	strcpy(novo->nome, "Joao");
	novo->prox=NULL;
	
	return 0;
}