#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int counterString(char palavra[256], char letra[2]){
    int count = 0;
    int i = strlen(palavra);
    if (palavra[i] == letra){
        i--;
        return 1;
    }
    count += counterString(palavra, letra);
    return count;
}

int main(){
    char palavra[256];
    char letra[2];
    scanf("%s %s", palavra, letra);
    printf("A palavra %s tem %d letras %s", palavra, counterString(palavra, letra), letra);


    return 0;}
