#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

typedef struct elemento{
	int mat;
	char nome[20];
	elemento *prox;
}Elemento;

int main(){
	
	Elemento *novo;
	novo = (Elemento *)malloc(sizeof(Elemento));
	novo->mat=1;
	strcpy(novo->nome, "Joao");
	novo->prox=0;
	
	Elemento *novo1;
	novo1 = (Elemento *)malloc(sizeof(Elemento));
	novo1->mat=2;
	strcpy(novo1->nome, "Julia");
	novo1->prox=NULL;
	
	novo->prox=novo1;

	cout << "Nome: " << novo->nome << " // Mat: " << novo->mat << " // Prox: " << novo->prox << endl;
	cout << "Endereco do proximo elemento: " << novo1 << endl;
	cout << "Nome: " << novo1->nome << " // Mat: " << novo1->mat << " // Prox: " << novo1->prox << endl;
	cout << "Endereco do proximo elemento: " << novo1->prox;
	
	return 0;
}