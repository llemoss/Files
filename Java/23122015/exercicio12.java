import java.util.Scanner;

public class exercicio12{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		float nota1, nota2, media;
		while(true){
			nota1 = input.nextFloat();
			if(nota1 < 0.0 || nota1 > 10.1){
				System.out.println("nota invalida");
				nota1 = input.nextFloat();
			}
			nota2 = input.nextFloat();
			if(nota2 < 0.0 || nota2 > 10.1){
				System.out.println("nota invalida");
				nota2 = input.nextFloat();
			}
			media = (float)((nota1 + nota2)/2.0);
			System.out.format("media = %.2f", media);
			break;
		}
	}
}

