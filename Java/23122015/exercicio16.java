import java.util.Scanner;

public class exercicio16{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String ossos, filo, alim;
		ossos = input.nextLine();
		filo = input.nextLine();
		alim = input.nextLine();
		if (ossos == "vertebrado"){
			if (filo == "ave"){
				if (alim == "carnivoro"){
					System.out.println("aguia");
				}
				else if (alim == "onivoro"){
					System.out.println("pomba");
				}
			}
			else if (filo == "mamifero"){
				if (alim == "onivoro"){
					System.out.println("homem");
				}
				else if (alim == "herbivoro"){
					System.out.println("vaca");}
				}
			}
		else if(ossos == "invertebrado"){
			if (filo == "inseto"){
				if (alim == "hematofago"){
					System.out.println("pulga");
				}
				else if (alim == "herbivoro"){
					System.out.println("lagarta");
				}
			}
			else if (filo == "anelideo"){
				if (alim == "hematofago"){
			 		System.out.println("sanguessuga");
				}
				else if (alim == "onivoro"){
					System.out.println("minhoca");
				}
			}
		}
	}
}
