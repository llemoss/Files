#include <stdio.h>
#include <stdlib.h>

double fat(int n){
    if(n==0){
        return 1;
    }
    else if (n<0){
        printf("Numero negativo nao tem fatorial");

    }
    return n*fat(n-1);
}

int main() {

    int n;
    do{
        printf("Digite um numero ou negativo (ou 0) para sair: ");
        scanf("%d", &n);
        if(n<=0){break;}
        else{printf("O fatorial de %d eh %.2f\n", n, fat(n));}
    }while(1==1);

    return 0;
}
