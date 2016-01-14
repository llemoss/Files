#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct nome{
    /*int algumacoisa
    char algumacoisa[50]
    float algumacoisa*/
    }Nome;

int pos = 0;
Nome vetor[10];

void incluir(){
    char resp;
    while(1==1){
        if(pos<5){
  	    Nome input;
  	    int i = 0, p = -1;
        
		/*
		Exemplos de inputs de acordo com struct
		
		printf("Digite nome do cliente: ");
        fflush(stdin);
        gets(input.nomeCliente);
        printf("Digite numero do cartao: ");
        scanf("%d", &input.numeroCartao);
        printf("Digite saldo do cartao: ");
        scanf("%d", &input.saldoCartao);
        printf("Digite limite do cartao: ");
        scanf("%d", &input.limiteCartao);
		
		*/
        
        //Comparacao para manter a lista ordenada
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


        //Fim da comparacao e ordenacao
        
        //Comeco do loop do input
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
        	
  	    //Fim do loop de input do incluir()
		}
    }
}


//Funcao para mostrar conteudo do vetor
void mostrar(){
    int i;
    for(i = 0; i < pos; i++){
        printf("Nome da conta = %s // Saldo = %d // Limite = %d // Numero = %d\n", banco[i].nomeCliente, banco[i].saldoCartao, banco[i].limiteCartao, banco[i].numeroCartao);
    }
    printf("\n");
}

//Funcao para encontrar o maior item do vetor, especificando o atributo
Cliente maiorLimite(){
    int i, d;
    while(d<5){
        for(i = 0;i < pos;i++){
                if (banco[i].limiteCartao < banco[i+1].limiteCartao){
                    int holder = banco[i+1].limiteCartao;
                    banco[i+1].limiteCartao = banco[i].limiteCartao;
                    banco[i].limiteCartao = holder;
					}
        }
        d++;
        }
    return banco[0];
}

//Funcao para encontrar o menor item do vetor, especificando o atributo
Cliente menorSaldo(){
    int i, d;
    while(d<5){
        for(i = 0;i < pos;i++){
                if (banco[i].saldoCartao > banco[i+1].saldoCartao){
                    int holder = banco[i+1].saldoCartao;
                    banco[i+1].saldoCartao = banco[i].saldoCartao;
                    banco[i].saldoCartao = holder;
                    }
        }
        d++;
        }
    return banco[pos-1];
}

//Funcao para deletar um item, substituindo pelo ultimo
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

//Funcao para deletar um item, organizando/movendo o vetor
void deletarMov(char nome[50]){
	int i, p;
	for (i = 0; i < pos; i++){
		if (strcmp(banco[i].nomeCliente, nome) == 0){
			p = i;
		}
	}
	for (i = p; i < pos - 1; i++)
	{banco[i] = banco[i+1];}
	pos--;
}

int main(){
	//Menu de opcoes com cada funcao
    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar cliente\n2 - Mostrar clientes\n3 - Maior limite\n4 - Menor saldo\n5 - Deletar cliente\n0 - Sair\n");
        scanf("%d", &opcao);
        if(opcao == 1){
            incluir2();
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
        else if(opcao == 10){
            printf("POS: %d\n", pos);
        }
        else if(opcao == 0){
            break;
        }
    }

        return 0;
}
