#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

typedef struct produto{
	int codigo;
	int unidade;
	int quantidade;
	char descricao[20];
	produto *prox;
}Produto;

Produto *inicio, *fim, *input;

void addInicio(int codigo, char descricao[20]){

	input = (Produto *)malloc(sizeof(Produto));
	input->codigo=codigo;
	strcpy(input->descricao, descricao);
	input->prox=NULL;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		input->prox = inicio;
		inicio = input;
	}
}


void addFinal(int codigo, char descricao[20]){

	input = (Produto *)malloc(sizeof(Produto));
	input->codigo=codigo;
	strcpy(input->descricao, descricao);
	input->prox=NULL;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		fim->prox = input;
		fim = input;
	}
}

void addElementoCod(int codigo, char descricao[20]){
	
	int entrou = 0;
	
	input = (Produto *)malloc(sizeof(Produto));
	input->codigo=codigo;
	strcpy(input->descricao, descricao);
	input->prox = NULL;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		
		Produto *atual = inicio;
		Produto *anterior = NULL;
		
		while(atual != NULL){
			if(input->cod < atual->cod){
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

void addElemento(int codigo, char descricao[20]){
	
	int entrou = 0;
	
	input = (Produto *)malloc(sizeof(Produto));
	input->codigo=codigo;
	strcpy(input->descricao, descricao);
	input->prox = NULL;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		
		Produto *atual = inicio;
		Produto *anterior = NULL;
		int retorno = strcmp(input->descricao, atual->descricao);
		
		while(atual != NULL){
			if(retorno < 0){
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

void rmvElemento(int codigo){
	
	Produto *atual = inicio;
	Produto *anterior = NULL;
	
	while(true){
		if(atual->codigo == codigo){
			break;
		}else{
			anterior = atual;
			atual = atual->prox;
		}
	}
	
	if(atual == inicio){
		inicio = atual->prox;
		atual = NULL;
	}else{
		anterior->prox = atual->prox;
		atual = NULL;
	}
	
}

void buscar(int codigo){
	
	Produto *atual = inicio;
	Produto *anterior = NULL;
	
	int achou = 0;
	
	do{
		if(atual->codigo == codigo){
			achou = 1;
			cout << "Resultado encontrado:\n" << "Descricao: " << atual->descricao << " // Codigo: " << atual->codigo << " // Prox: " << atual->prox << endl;
			break;
		}else{
			anterior = atual;
			atual = atual->prox;
		}
	}while(atual != NULL);
	
	if(achou == 0){
		cout << "Resultado nao encontrado!" << endl;
	}
}

Produto *buscaRtn(int codigo){
	
	Produto *atual = inicio;
	
	while(atual != NULL){
		if(atual->codigo == codigo){
			return atual;
		}
		atual = atual->prox;
	}
	
	return NULL;
}

void furaFila(Produto *input, int posicao){
	
	int contador = 0;
	
	Produto *atual = inicio;
	Produto *anterior = NULL;
	
	while(atual != NULL){
		if(contador == posicao){
			break;
		}else{
			anterior = atual;
		   	atual = atual->prox;
			contador++;
		}
	}
	
	if(contador == 0){
		input->prox = inicio;
		inicio = input;
	}else if (anterior == fim){
		fim->prox = input;
		fim = input;
	}else{
		anterior->prox = input;
		input->prox = atual;
	}
}

void mostrarLista(){
	Produto *atual;
	atual = inicio;
	while(atual != NULL){
		cout << "Descricao: " << atual->descricao << " // Codigo: " << atual->codigo << " // Prox: " << atual->prox << endl;
		atual = atual->prox;
	}
	cout << endl;
}

void quantidade(){
	Produto *atual;
	int contador = 0;
	atual = inicio;
	while(atual != NULL){
		contador++;
		atual = atual->prox;
	}
	cout << "Quantidade de elementos: " << contador << endl;
}

int main(){
	
	inicio = NULL;
	fim = NULL;

	addElemento(2, "Biscoito");
	addElemento(1, "Suco");
	addElemento(5, "Oreo");
	addElemento(3, "Teste");
	
	int opcao;
	
	do{
		cout << "Opcoes:\n1 - Mostrar elementos\n2 - Adicionar elemento (ordenado)\n3 - Adicionar elemento no comeco\n4 - Adicionar elemento no final\n5 - Remover elemento\n6 - Buscar elemento\n7 - Furar a fila\n8 - Quantidade de produtos\n9 - Destruicao da lista\n0 - Sair\nDigite uma opcao: ";
		int codigo;
		char descricao[20];
		Produto *resultado;
		cin >> opcao;
		switch(opcao){
		case 1:
			system("cls");
			mostrarLista();
			break;
		case 2:
			cout << "Digite codigo e descricao a serem adicionados: ";
			cin >> codigo >> descricao;
			resultado = buscaRtn(codigo);
			if(resultado == NULL){
				addElemento(codigo, descricao);
				system("cls");
				cout << "Produto adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Codigo ja existente!\n\n";
				break;
			}
		case 3:
			cout << "Digite codigo e descricao a serem adicionados: ";
			cin >> codigo >> descricao;
			resultado = buscaRtn(codigo);
			if(resultado == NULL){
				addInicio(codigo, descricao);
				system("cls");
				cout << "Produto adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Codigo ja existente!\n\n";
				break;
			}
		case 4:
			cout << "Digite codigo e descricao a serem adicionados: ";
			cin >> codigo >> descricao;
			resultado = buscaRtn(codigo);
			if(resultado == NULL){
				addFinal(codigo, descricao);
				system("cls");
				cout << "Produto adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Codigo ja existente!\n\n";
				break;
			}
		case 5:
			cout << "Digite codigo a ser deletado: ";
			cin >> codigo;
			resultado = buscaRtn(codigo);
			if (resultado == NULL){
				system("cls");
				cout << "Erro: Codigo nao existe!\n\n";
				break;}
            else{
				rmvElemento(resultado->codigo);
				system("cls");
				cout << "Produto deletado com sucesso!\n";
				mostrarLista();
				break;}
		case 6:
			cout << "Digite codigo a ser buscado: ";
			cin >> codigo;
			resultado = buscaRtn(codigo);
			system("cls");
			if (resultado == NULL){
				system("cls");
				cout << "Erro: Resultado nao encontrado!\n\n";
				break;}
			else{
				cout << "Resultado:\n" << "Descricao: " << resultado->descricao << " // Codigo: " << resultado->codigo << " // Prox: " << resultado->prox << endl << endl;
				break;}
        case 7:
        	int posicao;
			cout << "Digite codigo e descricao a serem adicionados: ";
			cin >> codigo >> descricao;
			cout << "Digite a posicao onde quer adicionar: ";
			cin >> posicao;
			resultado = buscaRtn(codigo);
			if(resultado == NULL){
				resultado = (Produto *)malloc(sizeof(Produto));
				resultado->codigo = codigo;
				strcpy(resultado->descricao, descricao);
				resultado->prox = NULL;
				furaFila(resultado, posicao);
				system("cls");
				cout << "Produto adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Codigo ja existente!\n\n";
				break;
			}
		case 8:
			system("cls");
			quantidade();
			break;
		case 9:
			system("cls");
			inicio = NULL;
			cout << "Lista destruida!" << endl;
			opcao = 0;
			break;
		default:
			break;}
	}while(opcao!=0);
	
	return 0;
}