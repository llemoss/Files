#include <iostream>
#include <string>
using namespace std;

int main(){
    
    string line;
    int A, B, C;
    while(getline(cin, line)){
    A = line[0];
    B = line[2];
    C = line[4];
    if (A != B && A != C){cout << "A" << endl;}
    else if (B != A && B != C){cout << "B" << endl;}
    else if (C != A && C != B){cout << "C" << endl;}
    else if (A == B && B == C && A == C){cout << "*" << endl;}
    cin.clear();
    }
    return 0;
}