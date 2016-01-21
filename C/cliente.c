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
        printf("Digite limite do cartao: ");
        scanf("%d", &banco[pos].limiteCartao);
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
        printf("Digite limite do cartao: ");
        scanf("%d", &input.limiteCartao);
		
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
}

void mostrar(){
    int i;
    for(i = 0; i < pos; i++){
        printf("Nome da conta = %s // Saldo = %d // Limite = %d // Numero = %d\n", banco[i].nomeCliente, banco[i].saldoCartao, banco[i].limiteCartao, banco[i].numeroCartao);
    }
    printf("\n");
}

Cliente maiorLimite(){ //Bubble Sort
    int i, j, troca;
    for(i = pos-1; i >= 1; i--){
    	troca = 0;
        for(j = 0; j < i; j++){
                if (banco[j].limiteCartao < banco[j+1].limiteCartao){
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

int main(){

    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar cliente\n2 - Mostrar clientes\n3 - Maior limite\n4 - Menor saldo\n5 - Deletar cliente\n0 - Sair\n");
        scanf("%d", &opcao);
        if(opcao == 1){
            incluir();
        }
        else if(opcao == 2){
            mostrar();
        }
        else if(opcao == 3){
            Cliente maiorLimiteCliente;
            maiorLimiteCliente = maiorLimite();
            printf("O cliente %s tem o maior limite de: %d\n", maiorLimiteCliente.nomeCliente, maiorLimiteCliente.limiteCartao);
        }
        else if(opcao == 4){
            Cliente menorCliente;
            menorCliente = menorSaldo();
            printf("O cliente %s tem o menor saldo de: %d\n", menorCliente.nomeCliente, menorCliente.saldoCartao);
        }
        else if(opcao == 5){
			mostrar();
			char n[50];
			printf("Digite nome do cliente a ser deletado: ");
			fflush(stdin);
			gets(n);
			deletarSubs(n);
			printf("\nNova lista de clientes:\n");
			mostrar();
		}
		else if(opcao == 6){
			int posicao;
			printf("Digite posicao a ser deletada: ");
			scanf("%d", &posicao);
			deletarMov(posicao);
			mostrar();
			
		}
        else if(opcao == 10){
            printf("POS: %d\n", pos);
        }
        else if(opcao == 0){
            break;
        }
    }

        return 0;
}
