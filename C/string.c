#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int counterString(char palavra[256], char letra){
    if(palavra[0] == '\0'){
        return 0;
    }
    if(palavra[0] == letra){
        return 1 + counterString(++palavra, letra);
    }
    return counterString(++palavra, letra);
}

int main(){
    char palavra[256];
    char letra;
    gets(palavra);
    fflush(stdin);
    letra = getchar();
    printf("A palavra: %s // letra: %c // repetidas: %d", palavra, letra, counterString(palavra, letra));


    return 0;}
