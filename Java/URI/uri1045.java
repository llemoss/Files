import java.util.Scanner;

public class uri1045{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);

		float a = scanner.nextFloat();
		scanner.nextLine();
		float b = scanner.nextFloat();
		scanner.nextLine();
		float c = scanner.nextFloat();
		scanner.nextLine();

		while(a < 0.0 && b < 0.0 && c < 0.0){
			a = scanner.nextFloat();
			scanner.nextLine();
			b = scanner.nextFloat();
			scanner.nextLine();
			c = scanner.nextFloat();
			scanner.nextLine();
		}

		float l [] = {a, b, c};

		int d = 0;
		
		while(d<2){
			for(int i = 0;i < 2;i++){
				if (l[i] < l[i+1]){
					float holder = l[i+1];
					l[i+1] = l[i];
					l[i] = holder;
				}
			}
			d++;
		}

		if(l[0] >= l[1] + l[2]){System.out.println("NAO FORMA TRIANGULO");}
		else{
			if((l[0]*l[0]) == (l[1]*l[1] + l[2]*l[2])){System.out.println("TRIANGULO RETANGULO");}
			else if((l[0]*l[0]) > (l[1]*l[1] + l[2]*l[2])){System.out.println("TRIANGULO OBTUSANGULO");}
			else if((l[0]*l[0]) < (l[1]*l[1] + l[2]*l[2])){System.out.println("TRIANGULO ACUTANGULO");}
			if (l[0] == l[1] && l[1] == l[2] && l[0] == l[2]){System.out.println("TRIANGULO EQUILATERO");}
			else if((l[0] == l[1] && (l[2] != l[1] && l[2] != l[0])) || (l[1] == l[2] && (l[0] != l[1] && l[0] != l[2])) || (l[0] == l[2] && (l[1] != l[0] && l[1] != l[2]))
){System.out.println("TRIANGULO ISOSCELES");}
		}
	}
}