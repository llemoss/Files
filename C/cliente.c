#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct cliente{
    int numeroCartao;
    int saldoCartao;
    int limiteCartao;
    char nomeCliente[50];
    }Cliente;

int pos = 0;
Cliente banco[5];

void incluir(){
    char resp;
    while(1==1){
        if(pos<5){
        printf("Digite nome do cliente: ");
        fflush(stdin);
        gets(banco[pos].nomeCliente);
        printf("Digite numero do cartao: ");
        scanf("%d", &banco[pos].numeroCartao);
        printf("Digite saldo do cartao: ");
        scanf("%d", &banco[pos].saldoCartao);
        pos++;
        printf("Deseja continuar? Y/N: ");
        scanf("%s", &resp);}else{break;}

        while(1==1){
            if(resp == 'N' || resp == 'n'){break;}
            else if(resp == 'Y' || resp == 'y'){
                    break;}
            else{
                printf("Deseja continuar? Y/N: ");
                scanf("%s", &resp);
            }
        }

        if(resp == 'N' || resp == 'n'){break;}
    }
}

void incluir2(){
    char resp;
    while(1==1){
        if(pos<5){
  	    Cliente input;
  	    int i = 0, p = -1;
        
		printf("Digite nome do cliente: ");
        fflush(stdin);
        gets(input.nomeCliente);
        printf("Digite numero do cartao: ");
        scanf("%d", &input.numeroCartao);
        printf("Digite saldo do cartao: ");
        scanf("%d", &input.saldoCartao);
		
		for (i = 0; i < pos; i++){
			if (input.numeroCartao < banco[i].numeroCartao){
				p = i;
				break;
			}
		}
		
		if (p == -1){
			banco[pos] = input;
			pos++;
		}else{
			for (i = pos; i > p; i--){banco[i] = banco[i-1];}
        	banco[p] = input;
			pos++;}

        printf("Deseja continuar? Y/N: ");
        scanf("%s", &resp);

        while(1==1){
            if(resp == 'N' || resp == 'n'){printf("\n\n"); break;}
            else if(resp == 'Y' || resp == 'y'){
                    break;}
            else{
                printf("Deseja continuar? Y/N: ");
                scanf("%s", &resp);
            }
        }
		
        if(resp == 'N' || resp == 'n'){
			printf("\n\n");
			break;}
		}
    }
}

void mostrar(){
    int i;
    for(i = 0; i < pos; i++){
        printf("Nome da conta = %s // Saldo = %d // Numero = %d\n", banco[i].nomeCliente, banco[i].saldoCartao, banco[i].numeroCartao);
    }
    printf("\n");
}

Cliente maiorSaldo(){ //Bubble Sort
    int i, j, troca;
    for(i = pos-1; i >= 1; i--){
    	troca = 0;
        for(j = 0; j < i; j++){
                if (banco[j].saldoCartao < banco[j+1].saldoCartao){
                	troca = 1;
                    Cliente holder = banco[j];
                    banco[j] = banco[j+1];
                    banco[j+1] = holder;
				}
        }
        if(troca == 0){break;}
	}
    return banco[0];
}

Cliente menorSaldo(){ //Bubble Sort
    int i, j, troca;
    for(i = pos-1; i >= 1; i--){
    	troca = 0;
        for(j = 0;j < i;j++){
                if (banco[j].saldoCartao > banco[j+1].saldoCartao){
                	troca = 1;
                    Cliente holder = banco[j];
                    banco[j] = banco[j+1];
                    banco[j+1] = holder;
				}
        }
        if(troca == 0){break;}
	}
	
    return banco[0];
}

void deletarSubs(char nome[50]){
	int i, p;
	for (i = 0; i < pos; i++){
		if (strcmp(banco[i].nomeCliente, nome) == 0){
			p = i;
		}
	}
	
	banco[p] = banco[pos-1];
	pos--;
}

void deletarMov(int p){
	int i = 0;
	for (i = p; i < pos; i++){
		banco[i] = banco[i+1];
	}
	pos--;
}

void pesquisaBinaria(Cliente *vet, int elem){
	int ini = 0;
	int fim = pos-1;
	
	while(ini <= fim){
		int meio = (ini + fim) / 2;
		if (elem < vet[meio].numeroCartao){
			fim = meio - 1;
		}
		else if (elem > vet[meio].numeroCartao){
			ini = meio + 1;
		}
		else{
			printf("O nome do cliente com numero %d, eh: %s\n", elem, vet[meio].nomeCliente);
			break;
		}
		
		printf("Cliente nao encontrado");
	}
}



int main(){

    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar cliente\n2 - Mostrar clientes\n3 - Ordenar maior -> menor saldo\n4 - Ordenar menor -> maior saldo\n5 - Deletar cliente por nome\n6 - Deletar cliente por posicao\n7 - Pesquisar cliente por numero de cartao\n0 - Sair\nQual opcao? - ");
        scanf("%d", &opcao);
        if(opcao == 1){
        	printf("\n");
            incluir();
        }
        else if(opcao == 2){
        	printf("\n");
            mostrar();
        }
        else if(opcao == 3){
        	printf("\n");
            Cliente maiorCliente;
            maiorCliente = maiorSaldo();
            printf("O cliente %s tem o maior saldo de: %d\n", maiorCliente.nomeCliente, maiorCliente.saldoCartao);
        }
        else if(opcao == 4){
        	printf("\n");
            Cliente menorCliente;
            menorCliente = menorSaldo();
            printf("O cliente %s tem o menor saldo de: %d\n", menorCliente.nomeCliente, menorCliente.saldoCartao);
        }
        else if(opcao == 5){
        	printf("\n");
			mostrar();
			char n[50];
			printf("Digite nome do cliente a ser deletado: ");
			fflush(stdin);
			gets(n);
			deletarSubs(n);
			printf("\nNova lista de clientes:\n");
			mostrar();
			printf("\n");
		}
		else if(opcao == 6){
			int posicao;
			printf("Digite posicao a ser deletada: ");
			scanf("%d", &posicao);
			deletarMov(posicao);
			mostrar();
			printf("\n");
		}
		else if(opcao == 7){
			int n;
			printf("Digite numero do cartao a ser encontrado: ");
			scanf("%d", &n);
			pesquisaBinaria(banco, n);
		}
        else if(opcao == 10){
            printf("POS: %d\n", pos);
            printf("\n");
        }
        else if(opcao == 0){
            break;
        }
    }

        return 0;
}
