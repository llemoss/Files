#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

class No{
	public:
		int mat;
		char nome[23];
		No *prox;
		
		No(int m, char n[23]){
			mat = m;
			strcpy(nome, n);
			prox = NULL;
		}
};

class Lista{
	public:
		No *inicio;
		No *fim;
		
		Lista(){
			inicio = NULL;
			fim = NULL;
		}
		
		void addInicio(int mat, char nome[20]){
			No *input = new No(mat, nome);
			if (inicio == NULL){
				inicio = input;
				fim = input;
			}else{
				input->prox = inicio;
				inicio = input;
			}
		}

		void addFinal(int mat, char nome[20]){
			No *input = new No(mat, nome);
			if (inicio == NULL){
				inicio = input;
				fim = input;
			}else{
				fim->prox = input;
				fim = input;
			}
		}
		
		void addElemento(int mat, char nome[20]){
			int entrou = 0;
			No *input = new No(mat, nome);
			if (inicio == NULL){
				inicio = input;
				fim = input;
			}else{
				No *atual = inicio;
				No *anterior = NULL;
				
				while(atual != NULL){
					if(input->mat < atual->mat){
						if(atual == inicio){
							input->prox = inicio;
							inicio = input;
							entrou = 1;
						}else{
							input->prox = anterior->prox;
							anterior->prox = input;
							entrou = 1;
						}
					}
					
					anterior = atual;
					atual = atual->prox;
				}
				
				if (entrou == 0){
					fim->prox = input;
					fim = input;
				}
			}
		}
		
		void rmvElemento(int mat){
			No *atual = inicio;
			No *anterior = NULL;
			while(atual != NULL){
				if(atual->mat == mat){break;}
                anterior = atual;
				atual = atual->prox;
			}
			
			if(atual == inicio){
				inicio = atual->prox;
				atual = NULL;
			}else{
				anterior->prox = atual->prox;
				atual = NULL;}
			
		}
		
		void mostrarLista(){
			No *atual = inicio;
			while(atual != NULL){
				cout << "Nome: " << atual->nome << " // Matricula: " << atual->mat << " // Prox: " << atual->prox << endl;
				atual = atual->prox;
			}
			cout << endl;
		}
		
		No *buscar(int mat){
			No *atual = inicio;
			while(atual != NULL){
				if(atual->mat == mat){
					return atual;}
				atual = atual->prox;
			}
			return NULL;
		}
};

main(){
	Lista *lista = new Lista();
	lista->addInicio(1, "testeInicio");
	lista->addFinal(10, "testeFinal");
	lista->addElemento(4, "aaaaaa");
	lista->mostrarLista();
	int a;
	cout << "Remover elemento de matricula: ";
	cin >> a;
	system("cls");
	if(lista->buscar(a) == NULL){
		cout << "Elemento não existente!" << endl;
		lista->mostrarLista();
	}else{
		lista->rmvElemento(a);
		cout << "Elemento " << a << " removido!" << endl;
		lista->mostrarLista();}
}