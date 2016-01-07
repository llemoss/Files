#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct livro{
    int numPag;
    char nomeDoLivro[50];
    char nomeDoAutor[30];
    }Livro;

int pos = 0;
Livro livros[5];

void incluir(){
    char resp;
    while(1==1){
        if(pos<5){
        printf("Digite nome do livro: ");
        fflush(stdin);
        gets(livros[pos].nomeDoLivro);
        printf("Digite nome do autor: ");
        fflush(stdin);
        gets(livros[pos].nomeDoAutor);
        printf("Digite a quantidade de paginas: ");
        fflush(stdin);
        scanf("%d", &livros[pos].numPag);
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
        printf("\nNome do livro = %s // Nome do autor = %s // Qtd. pags = %d\n", livros[i].nomeDoLivro, livros[i].nomeDoAutor, livros[i].numPag);
    }
    printf("\n");
}

Livro maior(){
    int i, d;
    while(d<5){
        for(i = 0;i < pos;i++){
                if (livros[i].numPag < livros[i].numPag){
                    int holder = livros[i+1].numPag;
                    livros[i+1].numPag = livros[i].numPag;
                    livros[i].numPag = holder;
                    }
        }
        d++;
        }
    return livros[0];
}

int main(){

    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar livro\n2 - Mostrar livros\n3 - Maior qtd. de paginas\n4 - Sair\n");
        scanf("%d", &opcao);
        if(opcao == 1){
            incluir();
        }
        else if(opcao == 2){
            mostrar();
        }
        else if(opcao == 3){
            Livro maiorLivro;
            maiorLivro = maior();
            printf("O livro %s tem a maior quantia de pag: %d\n", maiorLivro.nomeDoLivro, maiorLivro.numPag);
        }
        else if(opcao == 4){
            break;
        }
    }

        return 0;
}
