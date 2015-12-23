import java.util.Scanner;

public class exercicio5{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int inp, i = 0;
		while(1==1){
			inp = input.nextInt();
			if(inp == 2002){
				System.out.println("Acesso Permitido");
				break;}
			else if(i == 2 && inp != 2002){
				System.out.println("Acesso Negado");
				break;}
			inp = 0;
			i++;
		}
		
	}
}
