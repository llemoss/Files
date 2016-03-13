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
			return (this->topo == NULL);
		}
		
		void showAll(){
			No *atual = topo;
			while(atual != NULL){
				cout << "End: " << atual << " // Valor: " << atual->nome << " // Prox: " << atual->prox << endl;
				atual = atual->prox;
			}
		}
};

void calcString(string str){
	Pilha *numeros = new Pilha();
	Pilha *resultados = new Pilha();
	int i = 0;
	while(true){
		
		if(i == str.length()){
			break;
		}
		
		cout << "Volta (" << i << ")" << endl;
		if(str[i] != '+' && str[i] != '-' && str[i] != '*' && str[i] != '/'){
			numeros->push(str[i]);
			numeros->showAll();
		}else{
			int result = numeros->pop() - 48;
			char operationSignal = str[i];
			cout << "Sinal: " << operationSignal << endl;
			while(numeros->isEmpty() != 1){
				cout << "result = " << result << endl;
				if(operationSignal == '+'){
					result += (int) numeros->pop() - 48;}
				if(operationSignal == '-'){
					result -= (int) numeros->pop() - 48;}
				if(operationSignal == '*'){
					result *= (int) numeros->pop() - 48;}
				if(operationSignal == '/'){
					result /= (int) numeros->pop() - 48;}	
			}
			cout << "result = " << result << endl;
			resultados->push(result);
		}
		
		i++;
		
	}
	
	resultados->showAll();
}

int main(){
	
	string str = "12-45+";
	calcString(str);

}