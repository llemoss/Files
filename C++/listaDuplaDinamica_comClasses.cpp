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
		No *ante;
		
		No(int m, char n[23]){
			mat = m;
			strcpy(nome, n);
			ante = NULL;
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
				inicio->ante = input;
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
				input->ante = fim;
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
				
				while(atual != NULL){
					if(input->mat < atual->mat){
						entrou = 1;
						if(atual == inicio){
							this->addInicio(mat, nome);
						}else{
							input->prox = atual;
							input->ante = atual->ante;
							atual->ante->prox = input;
							atual->ante = input;
						}
						break;
					}
					atual = atual->prox;
				}
				
				if (entrou == 0){
					this->addFinal(mat, nome);
				}
			}
		}
		
		void rmvElemento(int mat){
			No *atual = inicio;
			No *anterior = NULL;
			while(atual != NULL){
				if(atual->mat == mat){break;}
                anterior = atual->ante;
				atual = atual->prox;
			}
			
			if(atual == inicio){
				inicio = atual->prox;
				atual = NULL;
			}else{
				anterior->prox = atual->prox;
				atual = NULL;}
			
		}
		
		void mostrarLista(bool reverse = false){
			if(reverse == false){
				No *atual = inicio;
				while(atual != NULL){
					cout << "Nome: " << atual->nome << " // Matricula: " << atual->mat << " // Prox: " << atual->prox << endl;
					atual = atual->prox;
				}
				cout << endl;
			}else{
				No *atual = fim;
				while(atual != NULL){
					cout << "Nome: " << atual->nome << " // Matricula: " << atual->mat << " // Prox: " << atual->prox << endl;
					atual = atual->ante;
				}
				cout << endl;
			}
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
	lista->addFinal(3, "testeFinal");
	lista->addFinal(4, "testeFinal2");
	lista->addElemento(2, "aaaaaa");
	lista->mostrarLista();
	
	/*int a;
	cout << "Remover elemento de matricula: ";
	cin >> a;
	system("cls");
	if(lista->buscar(a) == NULL){
		cout << "Elemento não existente!" << endl;
		lista->mostrarLista();
	}else{
		lista->rmvElemento(a);
		cout << "Elemento " << a << " removido!" << endl;
		lista->mostrarLista();}*/
}