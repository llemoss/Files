import java.util.Scanner;

public class exercicio11{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int tipo, a=0, g=0, d=0;
		while(true){
			tipo = input.nextInt();
			if(tipo == 1){a++;}
			if(tipo == 2){g++;}
			if(tipo == 3){d++;}
			if(tipo == 4){break;}
			if(tipo < 1 && tipo > 4){tipo = input.nextInt();}
		}
		System.out.format("MUITO OBRIGADO\nAlcool: %d\nGasolina: %d\nDiesel: %d", a, g, d);

	}
}

