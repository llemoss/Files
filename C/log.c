#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//log de n na base 2
double lg(int n){
	double x = 2, y = 0, piso;
	while (n >= pow(x, y)){
 	   piso = y;
 	   y++;
	}
	return piso;
}

int main(){
	int n;
	scanf("%d", &n);
	printf("%.0f", lg(n));
}