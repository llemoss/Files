#include <stdio.h>
#include <stdlib.h>

int main(){

    int var;
    int *ptr;
    var = 10;
    ptr = &var;
    int newVar = *ptr;
    *ptr = 20;

    printf("var: %d // &var: %d\n", var, &var);
    printf("newVar: %d // &newVar: %d\n", newVar, &newVar);
    printf("*ptr: %d // ptr: %d\n", *ptr, ptr);

    return 0;
}
