import java.util.Scanner;

public class uri1018{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		int [] ced = {100, 50, 20, 10, 5, 2, 1};

		int v = scanner.nextInt();
		scanner.nextLine();

		while(v < 0 || v > 1000000){
			v = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.println(v);

		while(i < 7){
			int notas = (int)(v/ced[i]);
			v = v%ced[i];
			System.out.format("%d notas de R$ %d,00\n", notas, ced[i]);
			i++;
			if(i==7){break;}
		}
	}
}