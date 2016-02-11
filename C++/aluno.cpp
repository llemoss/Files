#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

typedef struct elemento{
	int mat;
	char nome[20];
	float nota;
	elemento *prox;
}Elemento;

Elemento *inicio, *fim, *input;

void inserir_InicioLista(Elemento *input){
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		input->prox = inicio;
		inicio = input;
	}
	
}


void inserir_FinalDaLista(Elemento *input){
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		fim->prox = input;
		fim = input;
	}
	
}

void inserir_Ordenada(Elemento *input){
	
	int entrou = 0;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		
		Elemento *atual = inicio;
		Elemento *anterior = NULL;
		
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

void rmvElemento(Elemento *input){
	
	Elemento *atual = inicio;
	Elemento *anterior = NULL;
	
	while(true){
		if(atual == input){
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


Elemento *buscar(int mat){
	
	Elemento *atual = inicio;
	
	while(atual != NULL){
		if(atual->mat == mat){
			return atual;
		}
		atual = atual->prox;
	}
	
	return NULL;
}

void furaFila(Elemento *input, int posicao){
	
	int contador = 0;
	
	Elemento *atual = inicio;
	Elemento *anterior = NULL;
	
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
	Elemento *atual;
	atual = inicio;
	while(atual != NULL){
		cout << "Nome: " << atual->nome << " // Mat: " << atual->mat << " // Prox: " << atual->prox << endl;
		atual = atual->prox;
	}
	cout << endl;
}

int main(){
	
	inicio = NULL;
	fim = NULL;

	input =(Elemento *)malloc(sizeof(Elemento));
	input->mat = 2;
	strcpy(input->nome, "Julia");
	input->prox = NULL;
	
	inserir_Ordenada(input);
	
	int opcao;
	
	do{
		cout << "Opcoes:\n1 - Mostrar elementos\n2 - Adicionar elemento (ordenado)\n3 - Adicionar elemento no comeco\n4 - Adicionar elemento no final\n5 - Remover elemento\n6 - Buscar elemento\n7 - Furar a fila\n0 - Sair\nDigite uma opcao: ";
		int mat;
		char nome[20];
		Elemento *resultado;
		cin >> opcao;
		switch(opcao){
		case 1:
			system("cls");
			mostrarLista();
			break;
		case 2:
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			resultado = buscar(mat);
			if(resultado == NULL){
				resultado =(Elemento *)malloc(sizeof(Elemento));
				resultado->mat = mat;
				strcpy(resultado->nome, nome);
				resultado->prox = NULL;
				inserir_Ordenada(resultado);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 3:
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			resultado = buscar(mat);
			if(resultado == NULL){
				resultado = (Elemento *)malloc(sizeof(Elemento));
				resultado->mat = mat;
				strcpy(resultado->nome, nome);
				resultado->prox = NULL;
				inserir_InicioLista(resultado);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 4:
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			resultado = buscar(mat);
			if(resultado == NULL){
				resultado =( Elemento *)malloc(sizeof(Elemento));
				resultado->mat = mat;
				strcpy(resultado->nome, nome);
				resultado->prox = NULL;
				inserir_FinalDaLista(resultado);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 5:
			cout << "Digite matricula a ser deletada: ";
			cin >> mat;
			resultado = buscar(mat);
			if (resultado == NULL){
				system("cls");
				cout << "Erro: Matricula nao existe!\n\n";
				break;}
            else{
				rmvElemento(resultado);
				system("cls");
				cout << "Elemento deletado com sucesso!\n";
				mostrarLista();
				break;}
		case 6:
			cout << "Digite matricula a ser buscada: ";
			cin >> mat;
			resultado = buscar(mat);
			system("cls");
			if (resultado == NULL){
				system("cls");
				cout << "Erro: Resultado nao encontrado!\n\n";
				break;}
			else{
				cout << "Resultado:\n" << "Nome: " << resultado->nome << " // Mat: " << resultado->mat << " // Prox: " << resultado->prox << endl << endl;
				break;}
        case 7:
        	int posicao;
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			cout << "Digite a posicao onde quer adicionar: ";
			cin >> posicao;
			resultado = buscar(mat);
			if(resultado == NULL){
				resultado =( Elemento *)malloc(sizeof(Elemento));
				resultado->mat = mat;
				strcpy(resultado->nome, nome);
				resultado->prox = NULL;
				furaFila(resultado, posicao);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista();
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		default:
			break;
		}
	}while(opcao!=0);
	
	return 0;
}