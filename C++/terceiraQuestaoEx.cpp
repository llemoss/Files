#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>

using namespace std;

class No{
	public:
		char nome;
		No *prox;
		No(char n){
			nome = n;
			prox = NULL;
		}
};


class Fila{
	public:
		No *inicio;
		No *fim;
		
		Fila(){
			inicio = NULL;
			fim = NULL;
		}
		
		void push(char n){
			No *novo = new No(n);
			if(inicio == NULL){
				inicio = novo;
				fim = novo;
			}else{
				fim->prox = novo;
				fim = novo;
			}
		}
		
		char pop(){
			No *temp;
			char popped;
			if(inicio != NULL){
				temp = inicio;
				popped = temp->nome;
				inicio = inicio->prox;
				free(temp);
			}
			return popped;
		}
		
		void showAll(){
			No *atual = inicio;
			while(atual != NULL){
				cout << "End: " << &atual << " // Valor: " << atual->nome << " // Prox: " << atual->prox << endl;
				atual = atual->prox;
			}
		}
		
		void deleteAll(){
			while(inicio != NULL){
				cout << "Retirou a letra: " << this->pop() << endl;
			}
			cout << "Tudo deletado!" << endl;
		}
};

int main(){
	
	Fila *fila = new Fila();
	
	fila->push('A');
	fila->push('B');
	fila->push('C');
	fila->showAll();
	fila->deleteAll();
}