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
    char c[256], l[1];
    int i, qtd;
    cin >> c >> l;
    while (i < c.length()){if(c[i] == l){qtd++;} i++;}
    cout << c << "\n" << l;


    return 0;
}
