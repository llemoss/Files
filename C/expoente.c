#include <stdio.h>
#include <stdlib.h>

int expo(int x, int y){
    if(y==0){return 1;}
    return (x * expo(x, y-1));
}

int main() {

    int x, y;
    scanf("%d %d", &x, &y);
    printf("%d", expo(x, y));

    return 0;
}
