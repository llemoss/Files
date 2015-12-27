/*print "Ex. 8"
N = input()
i = 1
soma = 0
while N > 0:
	soma = soma + N
	N = input()
	i = i + 1
else:
	i = i - 1
	i = float(i)
	med = soma/i
	print "%.2f" % med*/

import java.util.Scanner;

public class exercicio8{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n, soma, i;
		n = input.nextInt();
		i = 1;
		soma = 0;
		while(n > 0){
			soma += n;
			n = input.nextInt();
			i++;
			if(n < 0){
				i--;
				float f = (float)(i);
				float med = soma/f;
				System.out.format("%.2f", med);
			}
		}

		
	}
}
