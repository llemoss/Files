import java.util.Scanner;

public class exercicio15{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n, m;
		n = input.nextInt();
		for(int i = 1; i < 11; i++){
			m = n*i;
			System.out.format("%d x %d = %d\n", i, n, m);
		}

		
	}
}
