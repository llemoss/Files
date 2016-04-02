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
		
		int isEmpty(){
			if(this->inicio == NULL){
				return 1;
			}else{
				return 0;
			}
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
    Fila *fila2 = new Fila();
    
    char letra;
	int resp;
    do{
		cout << "Digite a letra\n";
		cin >> letra;
		
		if(fila1->isEmpty() == 1){
			fila1->push(letra);
		}else{
			while(fila1->isEmpty() != 1){
				fila2->push(fila1->pop());
			}
			fila1->push(letra);
			while(fila2->isEmpty() != 1){
				fila1->push(fila2->pop());
			}
		}
	
		fila1->showAll();
		
		cout << "Continuar? // 1 - Sim // 2 - Nao\n";
		cin >> resp;
	}while(resp == 1);
}