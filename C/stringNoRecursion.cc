/*
 * File:   string.cc
 * Author: Gildásio Zeth
 *
 * Created on December 23th, 2015
 */

#include <iostream>
#include <stdio.h>
#include <string>

using namespace std;

int main()
{
    string c, l, cmp;
    int i = 0, qtd = 0, sizeStr;
    cin >> c >> l;
    sizeStr = c.length();
    while (i < sizeStr){
        cmp = c[i];
        if(cmp == l){
            qtd++;}
        i++;}
    cout << c << " tem " << l << " repetida " << qtd << " vezes " << "\n" ;

    return 0;
}
