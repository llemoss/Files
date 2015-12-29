import java.util.Scanner;

public class exercicio14{
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
