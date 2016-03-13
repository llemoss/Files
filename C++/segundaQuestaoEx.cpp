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
				cout << "End: " << atual << " // Valor: " << atual->nome << " // Prox: " << atual->prox << endl;
				atual = atual->prox;
			}
		}
};

void verify(string str){
	
	Pilha *pilha = new Pilha();
	
	string s = "";
	
	int i = 0;
	
	while(true){
		if(str[i] == 'C'){
			break;}
		pilha->push(str[i]);
		i++;
	}
	
	s = str.substr(i+1, str.length());
	
	cout << s << endl;
	
	pilha->showAll();
	
	
	for(int j = 0; j < s.length(); j++){
		if(s[j] == pilha->topo->nome){
			pilha->pop();
		}
	}
	
	
	if(pilha->isEmpty() == 1){
		cout << "Deu certo!" << endl;
	}else{
		cout << "Algum erro!" << endl;
	}
	
		
}

int main(){
	
	string str("ABABABCBABABA");
	verify(str);
	
}