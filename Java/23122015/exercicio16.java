import java.util.Scanner;

public class exercicio16{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//String ossos, filo, alim;
		
		String ossos = input.nextLine();
		String filo = input.nextLine();
		String alim = input.nextLine();

		if (ossos.equals("vertebrado")){
			if (filo.equals("ave")){
				if (alim.equals("carnivoro")){
					System.out.println("aguia");
				}
				else if (alim.equals("onivoro")){
					System.out.println("pomba");
				}
			}
			else if (filo.equals("mamifero")){
				if (alim.equals("onivoro")){
					System.out.println("homem");
				}
				else if (alim.equals("herbivoro")){
					System.out.println("vaca");
				}
			}
		}else if(ossos.equals("invertebrado")){
			if (filo.equals("inseto")){
				if (alim.equals("hematofago")){
					System.out.println("pulga");
				}
				else if (alim.equals("herbivoro")){
					System.out.println("lagarta");
				}
			}
			else if (filo.equals("anelideo")){
				if (alim.equals("hematofago")){
			 		System.out.println("sanguessuga");
				}
				else if (alim.equals("onivoro")){
					System.out.println("minhoca");
				}
			}
		}
	}
}
