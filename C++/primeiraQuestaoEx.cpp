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

class Pilha{
	public:
		No *topo;
		
		Pilha(){
			topo = NULL;
		}
		
		void push(char n){
			No *novo = new No(n);
			if(topo == NULL){
				topo = novo;
			}else{
				novo->prox = topo;
				topo = novo;
			}
		}
		
		char nomeTopo(){
			return topo->nome;
		}
		
		char pop(){
			No *temp;
			char popped;
			if(topo != NULL){
				temp = topo;
				popped = temp->nome;
				topo = topo->prox;
				free(temp);
			}
			return popped;
		}
		
		int isEmpty(){
			return (topo == NULL);
		}
		
		void showAll(){
			No *atual = topo;
			while(atual != NULL){
				cout << "End: " << &atual << " // Valor: " << atual->nome << " // Prox: " << atual->prox << endl;
				atual = atual->prox;
			}
		}
};

void verify(string str){
	
	char par[3][2];
	strcpy(par[0], "()");
	strcpy(par[1], "[]");
	strcpy(par[2], "{}");
	
	Pilha *pilha = new Pilha();	
	
	for(int i = 0; i < str.length(); i++){
		if(str[i] == par[0][0]){
			pilha->push(str[i]);
			cout << "Inseriu " << str[i] << endl;
		}
		if(str[i] == par[1][0]){
			pilha->push(str[i]);
			cout << "Inseriu " << str[i] << endl;
		}
		if(str[i] == par[2][0]){
			pilha->push(str[i]);
			cout << "Inseriu " << str[i] << endl;
		}
	}
	
	for(int i = 0; i < str.length(); i++){
		if(str[i] == par[0][1]){ // )
			if(pilha->isEmpty() != 1 && pilha->nomeTopo() == par[0][0]){
				cout << "Retirou " << pilha->nomeTopo() << endl;
				pilha->pop();
			}
		}
		if(str[i] == par[1][1]){ // ]
			if(pilha->isEmpty() != 1 && pilha->nomeTopo() == par[1][0]){}{
				cout << "Retirou " << pilha->nomeTopo() << endl;
				pilha->pop();
			}
		}
		if(str[i] == par[2][1]){ // }
			if(pilha->isEmpty() != 1 && pilha->nomeTopo() == par[2][0]){
				cout << "Retirou " << pilha->nomeTopo() << endl;
			   	pilha->pop();
			}
		}
	}
	
	if(pilha->isEmpty() == 1 && erro == 0){
		cout << "Sua equacao esta correta!" << endl;
	}else{
		cout << "Existe algum erro na sua equacao!" << endl;
	}
		
}

int main(){
	
	string str("{a + [2 + (2 + 2)]}");
	verify(str);
	
}