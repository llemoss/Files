import java.util.Scanner;

public class exercicio10{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int i = 0;
		int[] lista = new int[5];

		for(int a = 0; a < 5; a++){
			lista[a] = input.nextInt();
			input.nextLine();
			if(lista[a]%2 == 0){i++;}
		}

		System.out.format("%d valores pares", i);

	}
}