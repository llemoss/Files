#include <stdio.h>
#include <stdlib.h>

int main(){
    char c[256], l[1];
    scanf ("%[^\n]%*c", c);
    //scanf ("%s", l);
    printf("Palavra: %s // Letra: %s", c, l);

    return 0;}