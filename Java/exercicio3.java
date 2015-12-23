import java.util.Scanner;

public class exercicio3{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a, b, c, d;
		a = input.nextInt();
		input.nextLine();
		b = input.nextInt();
		input.nextLine();
		c = input.nextInt();
		input.nextLine();
		d = input.nextInt();
		input.nextLine();

		if ((b>c) && (d>a) && (c+d > a+b) && (c>0) && (d>0) && (a%2 == 0)){
			System.out.println("Valores aceitos");
		}else{
			System.out.println("Valores nao aceitos");
		}
	}
}