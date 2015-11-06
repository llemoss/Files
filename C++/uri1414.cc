#include <iostream>
#include <string>
using namespace std;

int main(){
    
    int T, N;
    int empates;
    do{
        cin >> T >> N;
        char time[10];
        int partidas;
        int pontos = 0;
        empates = 0;
        
        for(int i = 0;i < T;i++){
            cin >> time >> partidas;
            pontos = pontos + partidas;
            }
        
        empates = (3*N) - pontos;
        if (T>0){cout << empates << endl;}
    }while(T != 0);
    return 0;
}