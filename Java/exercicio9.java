import java.util.Scanner;

public class exercicio9{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		double [] ced = {100.00, 50.00, 20.00, 10.00, 5.00, 2.00};
		double [] mod = {1.00, 0.50, 0.25, 0.10, 0.05, 0.01};

		double v = scanner.nextFloat();
		scanner.nextLine();

		while(v < 0 || v > 1000000.00){
			v = scanner.nextFloat();
			scanner.nextLine();
		}
		
		System.out.println("NOTAS:");

		while(i < 6){
			float notas = (float)(v/ced[i]);
			int n = (int)(notas);
			v = v%ced[i];
			System.out.format("%d notas de R$ %.2f\n", n, ced[i]);
			i++;
		}

		System.out.println("MOEDAS:");

		i = 0;

		while(i < 6){
			double moedas = (double)(v/mod[i]);
			float n = (float)(moedas);
			v = v%mod[i];
			System.out.format("%.0f moedas de R$ %.2f\n", n, mod[i]);
			i++;
		}
	}
}