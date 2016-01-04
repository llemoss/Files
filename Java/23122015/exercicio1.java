import java.util.Scanner;

public class exercicio1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int km;
		float liters;

		km = input.nextInt();
		input.nextLine();
		liters = input.nextFloat();
		input.nextLine();

		System.out.format("%.3f km/l", km/liters);
	}
}

