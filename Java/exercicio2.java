import java.util.Scanner;

public class exercicio2{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);

		String nome = scanner.nextLine();
		float salarioBase = scanner.nextFloat();
		scanner.nextLine();
		float vendas = scanner.nextFloat();
		scanner.nextLine();

		float salarioFinal = (float)(salarioBase + (vendas*0.15));

		System.out.format("TOTAL = R$ %.2f", salarioFinal);

	}
}