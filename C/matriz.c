#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*int matriz[6][5]  = {{1, 2, 3, 4, 5}, 
                     {1, 2, 3, 4, 5}, 
					 {1, 2, 3, 4, 5}, 
					 {1, 2, 3, 4, 5}, 
					 {2, 2, 2, 2, 2},
					 {2, 2, 2, 2, 2}};*/
					 
void somar(int matriz[][5], int n){
	int soma = 0, i = 0, j = 0;
	for (i = 5; i < n; i++){
		for (j = 0; j < 5; j++){
			soma += matriz[i][j];
			//printf("%d", matriz[i][j]);
		}
	}
	printf("%d", soma);
}

int main(){
	
	//N deve ser maior que 5
	int n = 0, i = 0, j = 0;
	scanf("%d", &n);
	int matriz[n][5];
	//O(n)
	for(i = 0; i < n; i++){
		for(j = 0; j < 5; j++){
			matriz[i][j] = j;
		}
	}
	
	somar(matriz, n);
	
	return 0;
}