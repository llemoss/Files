import java.util.Scanner;

public class uri1010{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int id1 = scanner.nextInt();
		scanner.nextLine();
		int qtd1 = scanner.nextInt();
		scanner.nextLine();
		float preco1 = scanner.nextFloat();
		scanner.nextLine();
		int id2 = scanner.nextInt();
		scanner.nextLine();
		int qtd2 = scanner.nextInt();
		scanner.nextLine();
		float preco2 = scanner.nextFloat();
		scanner.nextLine();

		float valor = (float)(qtd1*preco1 + qtd2*preco2);
		System.out.format("VALOR A PAGAR: R$ %.2f", valor);
	}
}