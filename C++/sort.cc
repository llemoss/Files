/* 
 * File:   sort.cc
 * Author: Gildásio Zeth
 *
 * Created on September 9, 2015, 11:15 AM
 */

#include <string>
#include <iostream>
#include <cstdlib>
#include <cmath>
#include <stdio.h>

using namespace std;

int main()
{
    int A, B, C;
    int a, b, c;
    
    cin >> A >> B >> C;
    int holder [] = {A, B, C};
    
    for(int i = 0;i < 2;i++){
        if (holder[i] < holder[i+1]){
            a = holder[i];
            holder[i] = holder[i+1];
            holder[i+1] = a;
        }
    }
    
    cout << holder[2] << endl << holder[1] << endl << holder[0] << endl;
    cout << endl;
    cout << A << endl << B << endl << C << endl;
    
    return 0;
}


