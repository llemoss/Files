import java.util.Scanner;

public class uri1042{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		scanner.nextLine();
		int b = scanner.nextInt();
		scanner.nextLine();
		int c = scanner.nextInt();
		scanner.nextLine();

		int lista [] = {a, b, c};
    
		int d = 0;
		
		while(d<2){
			for(int i = 0;i < 2;i++){
				if (lista[i] > lista[i+1]){
					int holder = lista[i+1];
					lista[i+1] = lista[i];
					lista[i] = holder;
				}
			}
			d++;
		}

		System.out.println(lista[0] + "\n" + lista[1] + "\n" + lista[2] + "\n\n" + a + "\n" + b + "\n" + c);
	}
}