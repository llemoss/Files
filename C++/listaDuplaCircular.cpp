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
				fim->prox = inicio;
				inicio->ante = fim;
			}else{
				inicio->ante = input;
				input->prox = inicio;
				inicio = input;
				inicio->ante = fim;
			}
		}

		void addFinal(int mat, char nome[20]){
			No *input = new No(mat, nome);
			if (inicio == NULL){
				inicio = input;
				fim = input;
				fim->prox = inicio;
				inicio->ante = fim;
			}else{
				fim->prox = input;
				input->ante = fim;
				fim = input;
				fim->prox = inicio;
			}
		}
		
		void addElemento(int mat, char nome[20]){
			int entrou = 0;
			No *input = new No(mat, nome);
			if (inicio == NULL){
				inicio = input;
				fim = input;
				fim->prox = inicio;
				inicio->ante = fim;
			}else{
				No *atual = inicio->prox;
				if(input->mat < inicio->mat){
					inicio->ante = input;
					input->prox = inicio;
					inicio = input;
					inicio->ante = fim;
					fim->prox = inicio;
				}else{
					while(atual != inicio){
						if(input->mat < atual->mat){
							entrou = 1;
							input->prox = atual;
							input->ante = atual->ante;
							atual->ante->prox = input;
							atual->ante = input;
							break;
						}
						atual = atual->prox;
					}
					
					if (entrou == 0){
						fim->prox = input;
						input->ante = fim;
						fim = input;
						fim->prox = inicio;
						inicio->ante = fim;
					}
				}
       	   }
        }
		
		void rmvElemento(int mat){
			No *atual = inicio->prox;
			
			if(mat == inicio->mat){
				inicio = atual;
				inicio->ante = fim;
				fim->prox = inicio;
			}else{
				while(atual != inicio){
				if(atual->mat == mat){break;}
				atual = atual->prox;}
				if(atual == fim){
					fim = atual->ante;
					fim->prox = inicio;
					inicio->ante = fim;
				}else{
					atual->ante->prox = atual->prox;
					atual = NULL;}
			}
		}
		
		void mostrarLista(bool reverse = false){
			if(reverse == false){
				No *atual = inicio;
				do{
					cout << "End: " << atual << " // Nome: " << atual->nome << " // Matricula: " << atual->mat << " // Prox: " << atual->prox << " // Ante: " << atual->ante << endl;
					//system("pause");
					atual = atual->prox;
				}while(atual != inicio);
				
				//cout << "End: " << fim << " // Nome: " << fim->nome << " // Matricula: " << fim->mat << " // Prox: " << fim->prox << " // Ante: " << fim->ante << endl;
				cout << endl;
			}else{
				No *atual = fim;
				do{
					cout << "End: " << atual << " // Nome: " << atual->nome << " // Matricula: " << atual->mat << " // Prox: " << atual->prox << " // Ante: " << atual->ante << endl;
					atual = atual->ante;
				}while(atual != fim);
				cout << endl;
			}
		}
		
		No *buscar(int mat){
			No *atual = inicio->prox;
			if(mat == inicio->mat){
				return inicio;
			}else{
				while(atual != inicio){
					if(atual->mat == mat){
						return atual;}
					atual = atual->prox;
				}
			}
			return NULL;
		}
};

main(){
	Lista *lista = new Lista();
	//lista->addInicio(1, "testeInicio");
	//lista->addFinal(3, "testeFinal");
	//lista->addFinal(4, "testeFinal2");
	lista->addElemento(1, "um");
	lista->addElemento(3, "tres");
	lista->addElemento(2, "dois");
	lista->addElemento(4, "quatro");
	//lista->addElemento(1, "testeInicio");
	lista->mostrarLista(true);
	cout << endl;
	//lista->mostrarLista(false);
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