#include <stdio.h>
#include <stdlib.h>


int counterString(char palavra[], char letra){
    if(palavra[0] == '\0'){
        return 0;
    }
    if(palavra[0] == letra){
        return 1 + counterString(++palavra, letra);
    }
    return counterString(++palavra, letra);
}

int main(){
    char palavra[30];
    char letra;
    gets(palavra);
    letra = getchar();
    printf("String: %s // Letra: %c // Vezes repetida: %d", palavra, letra, counterString(palavra, letra));


    return 0;}
