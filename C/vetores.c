#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct aluno{
    int matricula;
    float nota;
    char nome[30];
    }Aluno;

int pos = 0;
Aluno vet_aluno[10];

void incluir(){
    char resp;
    while(1==1){
        vet_aluno[pos].matricula = pos+1;
        printf("Digite a nota: ");
        scanf("%f", &vet_aluno[pos].nota);
        printf("Digite o nome: ");
        scanf("%s",vet_aluno[pos].nome);
        printf("Deseja continuar? Y/N: ");
        scanf("%s", &resp);

        while(1==1){
            if(resp == 'N' || resp == 'n'){break;}
            else if(resp == 'Y' || resp == 'y'){
                    if(pos<9){pos++;}
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
    for(i = 0; i < pos+1; i++){
        printf("\nNome = %s // Matricula = %d // Nota = %.2f\n", vet_aluno[i].nome, vet_aluno[i].matricula, vet_aluno[i].nota);
    }
    printf("\n");
}

void maior_nota(){
    int i, d;
    char maiorNota[] = "";
    while(d<5){
        for(i = 0;i < pos;i++){
                if (vet_aluno[i].nota < vet_aluno[i+1].nota){
                    int holder = vet_aluno[i+1].nota;
                    vet_aluno[i+1].nota = vet_aluno[i].nota;
                    vet_aluno[i].nota = holder;
                    }
        }
        d++;
        }
    strcpy(maiorNota, vet_aluno[0].nome);
    printf("A maior nota e %.2f, do aluno %s\n", vet_aluno[0].nota, maiorNota);
}

void menor_nota(){
    int i, d;
    char menorNota[] = "";
    while(d<5){
        for(i = 0;i < pos;i++){
                if (vet_aluno[i].nota > vet_aluno[i+1].nota){
                    int holder = vet_aluno[i+1].nota;
                    vet_aluno[i+1].nota = vet_aluno[i].nota;
                    vet_aluno[i].nota = holder;
                    }
        }
        d++;
        }

    strcpy(menorNota, vet_aluno[pos].nome);
    printf("A menor nota e %.2f, do aluno %s\n", vet_aluno[0].nota, menorNota);
}


int main(){

    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar alunos\n2 - Mostrar alunos\n3 - Maior nota\n4 - Menor nota\n5 - Sair\n");
        scanf("%d", &opcao);
        if(opcao == 1){
            incluir();
        }
        else if(opcao == 2){
            mostrar();
        }
        else if(opcao == 3){
            maior_nota();
        }
        else if(opcao == 4){
            menor_nota();
        }
        else if(opcao == 5){
            break;
        }
    }

        return 0;
}
