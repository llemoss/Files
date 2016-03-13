//Leôncio

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
};

int main(){
	
	Fila *fila1 = new Fila();

    fila1->push('A');
    fila1->push('E');
    fila1->push('I');
    fila1->push('O');
    fila1->push('U');
 
    
    No *inicio=fila1->inicio;
    No *atual=fila1->inicio;
    No *loopbreak=fila1->fim;
	No *fim=fila1->fim;
	No *anterior;
    while(fila1->fim!=inicio){
    	while(atual!=loopbreak){
    		anterior=atual;
			atual=atual->prox;		
			}
		atual->prox=anterior;
		anterior->prox=NULL;
		loopbreak=anterior;
		fila1->fim=loopbreak;
		atual=fila1->inicio;	
		}
	fila1->inicio=fim;
	
	fila1->showAll();
}