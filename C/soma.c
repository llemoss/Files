#include <stdio.h>
#include <stdlib.h>

int soma(int n){
    if(n==1){
        return 1;
    }
    return n + soma(n-1);
}

int main() {

    int n;
    //do{
    //printf("Digite um numero (0 para encerrar): ");
    scanf("%d", &n);
    //if(n==0){break;}
    //else{printf(soma(n));}
    //}while(1);
    printf("%d", soma(n));

    return 0;
}
