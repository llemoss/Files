package ativ2601.forca;
import java.util.Scanner;

public class Jogo {
	
	static Scanner input = new Scanner(System.in);
	static String nome;
	static int score = 0;
	static Boneco boneco = new Boneco();
	static Tema animais = new Tema("Animais", "Cachorro Gato Passarinho Ornintorrinco");
	static Tema frutas  = new Tema("Frutas", "Maçã Banana Abacaxi Limão");
	static Tema[] temas = new Tema[10];
	static Tema tema = new Tema();
	static String[] palavra;
	static String[] asteriscos;
	static String letrasErradas = "";
	static String letrasAcertadas = "";
	static int vida = 6;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < temas.length; i++) {
			temas[i] = new Tema();
		}
		
		temas[0] = animais;
		temas[1] = frutas;
		
		//Menu
		while(true){
			int opcao;
			System.out.println("Bem vindo ao Jogo da Forca!\n1 - Começar jogo\n2 - Incrementar\n0 - Sair");
			System.out.print("Opção escolhida: ");
			opcao = input.nextInt();
			if (opcao == 1){
				System.out.print("Digite seu nome: ");
				nome = input.next();
				clear();
				jogo(); break;}
			else if (opcao == 2){
				System.out.println("\n");
				incrementarTemas();}
			else if (opcao == 0){break;}
			else{System.out.print("Digite uma opção válida!: "); opcao = input.nextInt();}	
		}
	}
	
	public static void jogo(){
		
		int n = 0 + (int)(Math.random() * ((temas.length-1 - 0) + 1));
		while(temas[n].getNome() == null){
			n = 0 + (int)(Math.random() * ((temas.length-1 - 0) + 1));
		}
		
		tema = temas[n];

		n = 0 + (int)(Math.random() * ((tema.getConjuntoPalavras().length - 0) + 1));
		
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
				letrasErradas += " " + letra;
				System.out.println("Você errou!" + " Letras erradas:" + letrasErradas);
			}else{
				clear();
				contador--;
				if (letrasAcertadas.contains(letra)){
					score += 0;
				}else{
					score += 100 + (contador * 15);
					letrasAcertadas += letra;
				}
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
	
	public static void incrementarTemas(){
		int count = -1;
		System.out.println("Temas disponíveis para incremento: ");
		for (int i = 0; i < temas.length; i++) {
			if (temas[i].getNome() != null){System.out.println(i+1 + " - " + temas[i].getNome() + " // Qtd. palavras: [" + temas[i].getConjuntoPalavras().length + "]"); count++;}
		}
		
		if (count == -1){count++;}
		else if(count == 0){count++;}
		
		while(true){
			int opcao;
			System.out.println("\nOpções:\n1 - Adicionar palavra\n2 - Adicionar tema\n0 - Sair");
			System.out.print("Opção escolhida: ");
			opcao = input.nextInt();
			if (opcao == 1){
				String nomeTema, novaPalavra;
				String str = "";
				int i;
				System.out.println("Digite o nome do tema a ser incrementado: ");
				nomeTema = input.next();
				for (i = 0; i < temas.length; i++) {
					if (temas[i].getNome().equals(nomeTema)){
						break;
					}
				}
				System.out.println("Digite palavra a adicionar: ");
				novaPalavra = input.next();
				for (String p : temas[i].getConjuntoPalavras()) {
					str += p + " ";
				}
				str += novaPalavra;
				temas[i] = new Tema(temas[i].getNome(), str);
			}
			else if (opcao == 2){
				String nomeTema, conjuntoTema;
				System.out.println("Digite o nome do tema:");
				nomeTema = input.next();
				input.nextLine();
				System.out.println("Digite o conjunto de palavras (separadas por espaço): ");
				conjuntoTema = input.nextLine();
				Tema novoTema = new Tema(nomeTema, conjuntoTema);
				temas[count] = novoTema;
				System.out.println("Tema adicionado com sucesso!\n");
				break;
			}
			else if (opcao == 0){break;}
			else {System.out.print("Digite uma opção válida!: "); opcao = input.nextInt();}
		}
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
