package ativ2601.forca;
import java.util.Scanner;

public class Rodada {
	
	private static Boneco boneco = new Boneco();
	static Scanner input = new Scanner(System.in);
	private static int vida = 6;
	private static int score = 0;
	private static Tema tema;
	private static Tema[] temas = new Tema[10];
	private static Tema animais = new Tema("Animais", "Cachorro Gato Passarinho Ornintorrinco");
	private static Tema frutas  = new Tema("Frutas", "Maçã Banana Abacaxi Limão");
	private static Jogador jogador;
	private static String[] palavra;
	private static String[] asteriscos;
	private static String letrasErradas = "";
	private static String letrasAcertadas = "";

	Rodada(Jogador jogador){
		
		Rodada.jogador = jogador;
		
		for (int i = 0; i < temas.length; i++) {
			temas[i] = new Tema();
		}
		
		temas[0] = animais;
		temas[1] = frutas;
			
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
	}
	
	public static void adicionarLetra(String letra){
		
		boolean acertou = false;
		int contador = 0;
		
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
			getBoneco().setVida(--vida);;
			getBoneco().removerParte();
			letrasErradas += " " + letra;
			System.out.println("Você errou!" + " Letras erradas:" + letrasErradas);
		}else{
			clear();
			contador--;
			if (letrasAcertadas.contains(letra)){
				System.out.println("Você já digitou essa letra!" + " Letras acertadas: " + letrasAcertadas);
				score += 0;
				jogador.setPontos(score);
			}else{
				score += 100 + (contador * 15);
				jogador.setPontos(score);
				letrasAcertadas += letra;
				System.out.println("Você acertou!");
			}
		}
		
		if (strPalavra.equals(strAsteriscos)){
			clear();
			boneco.setDead(true);
			System.out.println("Você ganhou!");
			System.out.println("Jogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos());
			System.out.println("Tema: " + tema.getNome() + " // Palavra: " + strPalavra);}
		else if (vida == 0){
			boneco.setDead(true);
			System.out.println("Você morreu!");
			System.out.println("Jogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos());
			System.out.println("Tema: " + tema.getNome() + " // Palavra: " + strPalavra);}
		else{
			mostrar();
		}
	}
	
	public static void adicionarLetra(){
			String letra;
			System.out.print("\nDigite uma letra: ");
			letra = input.next();
			letra = letra.toUpperCase();
			adicionarLetra(letra);
	}
	
	public static void mostrar(){
		System.out.println("Jogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos());
		System.out.print("Tema: " + tema.getNome());
		System.out.println("\n___\n  |");
		System.out.println(boneco.mostrar() + "\n");
		for (int i = 0; i < asteriscos.length; i++) {
			System.out.print(asteriscos[i]);
		}
		System.out.println("\n");
	}

	public static void incrementarTemas(){
		int count = 0;
		
		System.out.println("Temas disponíveis para incremento: ");
		
		for (int i = 0; i < temas.length; i++) {
			if (temas[i].getNome() != null){System.out.println(i+1 + " - " + temas[i].getNome() + " // Qtd. palavras: [" + temas[i].getConjuntoPalavras().length + "]"); count++;}
		}
		
		while(true){
			int opcao;
			System.out.println("\nOpções:\n1 - Adicionar palavra\n2 - Adicionar tema\n0 - Sair");
			System.out.print("Opção escolhida: ");
			opcao = input.nextInt();
			if (opcao == 1){
				String nomeTema, novaPalavra;
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
				temas[i].adicionarPalavra(novaPalavra);
				System.out.println("Palavra adicionada com sucesso!\n");
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
		
	public static void clear(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		Rodada.jogador = jogador;
	}

	public static Boneco getBoneco() {
		return boneco;
	}

	public void setBoneco(Boneco boneco) {
		Rodada.boneco = boneco;
	}
}
