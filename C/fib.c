#include <stdio.h>
#include <stdlib.h>

int fib(n){
	int result = 0;
	if (n == 0 || n == 1){
		return n;
	}else{
		result = fib(n-1) + fib(n-2);
		return result;
	}
}

int main(){
	int n;
	scanf("%d", &n);
	printf("%d", fib(n));
}