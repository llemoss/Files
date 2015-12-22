import java.util.Scanner;

public class uri1013{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		int b = scanner.nextInt();
		scanner.nextLine();
		int c = scanner.nextInt();
		scanner.nextLine();

		int maiorAB = (a+b+Math.abs(a-b))/2;
		int maiorABC = (c+maiorAB+Math.abs(c-maiorAB))/2;

		System.out.format("%d eh o maior", maiorABC);
	}
}