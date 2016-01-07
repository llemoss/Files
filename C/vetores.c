#include <stdio.h>
#include <stdlib.h>


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
        printf("Digite a matricula: ");
        scanf("%d", &vet_aluno[pos].matricula);
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
}

int main(){

    while(1==1){
            int opcao;
        printf("Opcoes:\n1 - Cadastrar alunos\n2 - Mostrar alunos\n3 - Sair\n");
        scanf("%d", &opcao);
        if(opcao == 1){
            incluir();
        }
        else if(opcao == 2){
            mostrar();
        }
        else if(opcao == 3){
            break;
        }
    }

        return 0;
}
