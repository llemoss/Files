import java.util.Scanner;

public class exercicio7{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n > 0){
			int[] lista = new int[n];
			int d = 0;
			for(int i = 0; i < n; i++){
				lista[i] = input.nextInt();
				input.nextLine();
			}
			while(d<n){
				for(int a = 0;a < n-1;a++){
					if (lista[a] < lista[a+1]){
							int holder = lista[a+1];
							lista[a+1] = lista[a];
							lista[a] = holder;}
					}
				d++;
			}
			if(lista[0] < 10){System.out.println("1");}
			if(lista[0] > 10 && lista[0] < 20){System.out.println("2");}
			if(lista[0] >= 20){System.out.println("3");}
		n = input.nextInt();
		if (n < 0){break;}
		}
	}
}
