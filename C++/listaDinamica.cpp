#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>

using namespace std;

typedef struct elemento{
	int mat;
	char nome[20];
	elemento *prox;
}Elemento;

Elemento *inicio, *fim, *input;

void addInicio(int mat, char nome[20]){

	input = (Elemento *)malloc(sizeof(Elemento));
	input->mat=mat;
	strcpy(input->nome, nome);
	input->prox=NULL;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		input->prox = inicio;
		inicio = input;
	}
}


void addFinal(int mat, char nome[20]){

	input = (Elemento *)malloc(sizeof(Elemento));
	input->mat=mat;
	strcpy(input->nome, nome);
	input->prox=NULL;
	
	if (inicio == NULL){
		inicio = input;
		fim = input;
	}else{
		fim->prox = input;
		fim = input;
	}
}

void addElemento(int mat, char nome[20]){
	
	int entrou = 0;
	
	input = (Elemento *)malloc(sizeof(Elemento));
	input->mat=mat;
	strcpy(input->nome, nome);
	input->prox = NULL;
	
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

void rmvElemento(int mat){
	
	Elemento *atual = inicio;
	Elemento *anterior = NULL;
	
	while(true){
		if(atual->mat == mat){
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

void buscar(int mat){
	
	Elemento *atual = inicio;
	Elemento *anterior = NULL;
	
	int achou = 0;
	
	do{
		if(atual->mat == mat){
			achou = 1;
			cout << "Resultado encontrado:\n" << "Nome: " << atual->nome << " // Mat: " << atual->mat << " // Prox: " << atual->prox << endl;
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

Elemento *buscaRtn(int mat){
	
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

void inverterLista(){
	Elemento *atual = inicio;
	Elemento *anterior = NULL;
	Elemento *proximo;
	
	while(atual != NULL){
		proximo = atual->prox;
		atual->prox = anterior;
		anterior = atual;
		atual = proximo;
	}
	
	inicio = fim;
	fim = anterior;
}

void mostrarLista(Elemento *input){
	Elemento *atual;
	atual = input;
	while(atual != NULL){
		cout << "Nome: " << atual->nome << " // Mat: " << atual->mat << " // Prox: " << atual->prox << endl;
		atual = atual->prox;
	}
	cout << endl;
}

void criarListaInvertida(){
	Elemento *atual = inicio;
	Elemento *anterior = NULL;
	
	Elemento *novoInicio = NULL, *novoFim = NULL, *novo;
	
	while(atual!=NULL){
		novo = (Elemento *)malloc(sizeof(Elemento));
		novo->mat=atual->mat;
		strcpy(novo->nome, atual->nome);
		if (novoInicio == NULL){
			novoInicio = novo;
			novoFim = novo;
		}else{
			novo->prox = novoInicio;
			novoInicio = novo;
		}
		anterior = atual;
		atual = atual->prox;
	}
	
	atual = novoInicio;
	anterior = NULL;
	
	while(atual->mat != inicio->mat){
		anterior = atual;
		atual = atual->prox;
	}
	
	atual->prox = NULL;
	
	mostrarLista(novoInicio);
}



int main(){
	
	inicio = NULL;
	fim = NULL;

	addElemento(2, "Julia");
	addElemento(1, "Gil");
	addElemento(5, "Quarto");
	addElemento(3, "Sexto");
	
	int opcao;
	int opcao2;
	
	do{
		cout << "Opcoes:\n1 - Mostrar elementos\n2 - Adicionar elemento (ordenado)\n3 - Adicionar elemento no comeco\n4 - Adicionar elemento no final\n5 - Remover elemento\n6 - Buscar elemento\n7 - Furar a fila\n8 - Inverter a lista atual\n9 - Criar uma nova lista invertida\n10 - Escolher qual tipo de lista mostrar\n0 - Sair\nDigite uma opcao: ";
		int mat;
		char nome[20];
		Elemento *resultado;
		cin >> opcao;
		switch(opcao){
		case 1:
			system("cls");
			mostrarLista(inicio);
			break;
		case 2:
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			resultado = buscaRtn(mat);
			if(resultado == NULL){
				addElemento(mat, nome);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista(inicio);
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 3:
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			resultado = buscaRtn(mat);
			if(resultado == NULL){
				addInicio(mat, nome);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista(inicio);
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 4:
			cout << "Digite matricula e nome a serem adicionados: ";
			cin >> mat >> nome;
			resultado = buscaRtn(mat);
			if(resultado == NULL){
				addFinal(mat, nome);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista(inicio);
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 5:
			cout << "Digite matricula a ser deletada: ";
			cin >> mat;
			resultado = buscaRtn(mat);
			if (resultado == NULL){
				system("cls");
				cout << "Erro: Matricula nao existe!\n\n";
				break;}
            else{
				rmvElemento(resultado->mat);
				system("cls");
				cout << "Elemento deletado com sucesso!\n";
				mostrarLista(inicio);
				break;}
		case 6:
			cout << "Digite matricula a ser buscada: ";
			cin >> mat;
			resultado = buscaRtn(mat);
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
			resultado = buscaRtn(mat);
			if(resultado == NULL){
				resultado =(Elemento *)malloc(sizeof(Elemento));
				resultado->mat = mat;
				strcpy(resultado->nome, nome);
				resultado->prox = NULL;
				furaFila(resultado, posicao);
				system("cls");
				cout << "Elemento adicionado com sucesso!\n";
				mostrarLista(inicio);
				break;}
			else{
				system("cls");
				cout << "Erro: Matricula ja existente!\n\n";
				break;
			}
		case 8:
			system("cls");
			cout << "Lista invertida (sem criar uma nova):" << endl;
			inverterLista();
			mostrarLista(inicio);
			break;
		case 9:
			system("cls");
			cout << "Lista invertida (criando uma nova):" << endl;
			criarListaInvertida();
			break;
		case 10:
			do{
				cout << "Opcoes:\n1 - Normal\n2 - Invertida\n0 - Voltar ao menu principal\nQual lista deseja ver?: ";
				cin >> opcao2;
				switch(opcao2){
					case 1:
						system("cls");
						mostrarLista(inicio);
						break;
					case 2:
						system("cls");
						criarListaInvertida();
						break;
					default:
						system("cls");
						break;
				}
			}while(opcao2!=0);
			break;
		default:
			break;
		}
	}while(opcao!=0);
	
	return 0;
}