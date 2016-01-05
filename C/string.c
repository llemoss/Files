#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int counterString(char palavra[256], char letra[2], int i){
    i = strlen(palavra);
    int count = 0;
    if (palavra[i] == letra){
        return 1;
    }
    count += counterString(palavra, letra, i--);
    return count;
}

int main(){
    char palavra[256];
    char letra[2];
    scanf("%s %s", palavra, letra);
    printf("A palavra %s tem %d letras %s", palavra, counterString(palavra, letra, 1), letra);


    return 0;}
