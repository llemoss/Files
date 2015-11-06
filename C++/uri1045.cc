/* 
 * File:   triangles.cc
 * Author: Gildásio Zeth
 *
 * Created on September 9, 2015, 11:50 AM
 */

#include <string>
#include <iostream>
#include <cstdlib>
#include <cmath>
#include <stdio.h>

using namespace std;

int main()
{
    float A, B, C, a;
    cin >> A >> B >> C;
    float l [] = {A, B, C};
    
    for(int i = 0;i < 2;i++){
        if (l[i] > l[i+1]){
            a = l[i];
            l[i] = l[i+1];
            l[i+1] = a;
        }
    }
    cout << fixed;
    cout.precision(1);
    if (l[2] >= (l[0] + l[1])){cout << "NAO FORMA TRIANGULO" << endl;}
    else{
        if ((l[2]*l[2]) == (l[1]*l[1] + l[0]*l[0])){cout << "TRIANGULO RETANGULO" << endl;}
        else if ((l[2]*l[2]) > (l[1]*l[1] + l[0]*l[0])){cout << "TRIANGULO OBTUSANGULO" << endl;}
        else if ((l[2]*l[2]) < (l[1]*l[1] + l[0]*l[0])){cout << "TRIANGULO ACUTANGULO" << endl;}
        if (A == B && A == C && B == C){cout << "TRIANGULO EQUILATERO" << endl;}
        if ((l[0] == l[1] && (l[2] != l[1] && l[2] != l[0])) || (l[1] == l[2] && (l[0] != l[1] && l[0] != l[2])) || (l[0] == l[2] && (l[1] != l[0] && l[1] != l[2]))){
        cout << "TRIANGULO ISOSCELES" << endl;}
       }
    
return 0;
}

