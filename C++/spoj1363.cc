#include <iostream>
#include <string>
using namespace std;

int main(){
    
    int N=1, testes = 0, i = 0;
    do{
        cin >> N;
        testes++;
        char j1[10];
        char j2[10];
        string resultados[N];
        if(N>0){cin >> j1 >> j2;}
        for(i = 0;i < N;i++){
            int A, B;
            cin >> A >> B;
            if ((A+B)%2 == 0){resultados[i] = j1;}else{resultados[i] = j2;}
        }
        
        if(N>0){cout << "Teste " << testes << endl;}
        for(i=0;i<N;i++){cout << resultados[i] << endl;}
        
    }while(N!=0);
    return 0;
}