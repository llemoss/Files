#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

using namespace std;

/*int matriz[6][5]  = {{1, 2, 3, 4, 5}, 
                     {1, 2, 3, 4, 5}, 
					 {1, 2, 3, 4, 5}, 
					 {1, 2, 3, 4, 5}, 
					 {2, 2, 2, 2, 2},
					 {2, 2, 2, 2, 2}};*/

int somar(int matriz[1][5]){
	int sum = 0;
	for(int i = 4; i < sizeof(matriz); i++){
		for(int j = 0; j < 5; j++){
			sum += matriz[i][j];
		}
	}
	return sum;
}			 
					 
					 
int main(){
	
	int n = 0;
	cout << "Digite n: ";
	cin >> n;
	int matriz[n][5];
	for (int i = 0; i < n; i++){
		for (int j = 0; j < 5; j++){
			matriz[i][j] = 1;
		}
	}
	cout << "Soma: " << somar(matriz[n][5]) << endl;
	
	return 0;
}