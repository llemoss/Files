package ativ2601.forca;
import java.util.Scanner;

public class Jogo {
	
	static Scanner input = new Scanner(System.in);
	static String nome;
	static int score = 0;
	static Boneco boneco = new Boneco();
	static Tema animais = new Tema("Animais", "Cachorro Gato Passarinho Ornintorrinco");
	static Tema frutas  = new Tema("Frutas", "Maçã Banana Abacaxi Limão");
	static Tema[] temas = new Tema[5];
	static Tema tema = new Tema();
	static String[] palavra;
	static String[] asteriscos;
	static String letrasErradas = "";
	static int vida = 6;
	
	public static void main(String[] args) {
		
		temas[0] = animais;
		temas[1] = frutas;
		
		menu();	
		
		//int n = 0 + (int)(Math.random() * ((temas.length - 0) + 1));
		
		tema = temas[0];

		int n = 0 + (int)(Math.random() * ((tema.getConjuntoPalavras().length - 0) + 1));
		
		palavra = tema.getConjuntoPalavras()[n].split("");
		asteriscos = new String[palavra.length];
		
		for (int i = 0; i < palavra.length; i++) {
			asteriscos[i] = "*";
		}
		
		mostrar();
		
		while(true){
			
			String letra;
			int contador = 0;
			boolean acertou = false;
			System.out.print("\nDigite uma letra: ");
			letra = input.next();
			letra = letra.toUpperCase();
			
			for (int i = 0; i < palavra.length; i++) {
				if (letra.equals(palavra[i])){
					asteriscos[i] = letra;
					acertou = true;
					contador++;}
			}
			
			String strPalavra = "";
			String strAsteriscos = "";
			for (int i = 0; i < palavra.length; i++) {
				strPalavra += palavra[i];
				strAsteriscos += asteriscos[i];
			}
			
			if (acertou == false){
				clear();
				vida--;
				boneco.removerParte(vida);
				System.out.println("Você errou!");
			}else{
				clear();
				contador--;
				score += 100 + (contador * 15);
			}
			
			if (strPalavra.equals(strAsteriscos)){
				clear();
				System.out.println("Você ganhou!");
				System.out.println("Jogador: " + nome + " // Pontuação: " + score);
				System.out.println("Tema: " + tema.getNome() + " // Palavra: " + strPalavra);
				break;}
			else if (vida == 0){
				System.out.println("Você morreu!");
				System.out.println("Jogador: " + nome + " // Pontuação: " + score);
				System.out.println("Tema: " + tema.getNome() + " // Palavra: " + strPalavra);
				break;
			}
			else{
				mostrar();
			}
			
		}
	}

	public static void menu(){
		System.out.print("Digite seu nome: ");
		nome = input.next();
	}
	
	public static void mostrar(){
		System.out.println("Jogador: " + nome + " // Pontuação: " + score);
		System.out.print("Tema: " + tema.getNome());
		System.out.println("\n___\n  |");
		System.out.println(boneco.mostrar() + "\n");
		for (int i = 0; i < asteriscos.length; i++) {
			System.out.print(asteriscos[i]);
		}
		System.out.println("\n");
	}
	
	public static void clear(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}
}
