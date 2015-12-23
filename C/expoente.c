#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int expo(int x, int y){
    if(y==0){return 1;}
    return (x * expo(x, y-1));
}

int main() {

    int x, y;
    //do{
    //printf("Digite x e y: ");
    scanf("%d %d", &x, &y);
    //if(x==0 && y == 0){break;}
    //else{printf("O resultado de %d elevado a %d: %d\n", x, y, expo(x, y));}
    printf("%d", expo(x, y));
    //}while(1);

    return 0;
}
