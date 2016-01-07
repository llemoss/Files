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

void mostrar(){
    int i;
    for(i = 0; i < pos; i++){
        printf("\nNome da conta = %s // Saldo = %d // Limite = %d // Numero = %d\n", banco[i].nomeCliente, banco[i].saldoCartao, banco[i].limiteCartao, banco[i].numeroCartao);
    }
    printf("\n");
}

Cliente maiorLimite(){
    int i, d;
    while(d<5){
        for(i = 0;i < pos;i++){
                if (banco[i].limiteCartao < banco[i].limiteCartao){
                    int holder = banco[i+1].limiteCartao;
                    banco[i+1].limiteCartao = banco[i].limiteCartao;
                    banco[i].limiteCartao = holder;
                    }
        }
        d++;
        }
    return banco[0];
}

Cliente menorSaldo(){
    int i, d;
    while(d<5){
        for(i = 0;i < pos;i++){
                if (banco[i].saldoCartao > banco[i].saldoCartao){
                    int holder = banco[i+1].saldoCartao;
                    banco[i+1].saldoCartao = banco[i].saldoCartao;
                    banco[i].saldoCartao = holder;
                    }
        }
        d++;
        }
    strcpy(banco[0].nomeCliente, banco[pos].nomeCliente);
    return banco[0];
}

int main(){

    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar cliente\n2 - Mostrar clientes\n3 - Maior limite\n4 - Menor saldo\n5 - Sair\n");
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
            break;
        }
    }

        return 0;
}
