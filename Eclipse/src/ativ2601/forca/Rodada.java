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
			Jogo.msg("Você errou!" + " Letras erradas:" + letrasErradas);
		}else{
			clear();
			contador--;
			if (letrasAcertadas.contains(letra)){
				Jogo.msg("Você já digitou essa letra!" + " Letras acertadas: " + letrasAcertadas);
				score += 0;
				jogador.setPontos(score);
			}else{
				score += 100 + (contador * 15);
				jogador.setPontos(score);
				letrasAcertadas += letra;
				Jogo.msg("Você acertou!");
			}
		}
		
		if (strPalavra.equals(strAsteriscos)){
			clear();
			boneco.setDead(true);
			Jogo.msg("Você ganhou!\nJogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos() + "\nTema: " + tema.getNome() + " // Palavra: " + strPalavra);}
		else if (vida == 0){
			boneco.setDead(true);
			Jogo.msg("Você morreu!\nJogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos() + "\nTema: " + tema.getNome() + " // Palavra: " + strPalavra);}
			}
	
	public static void inputLetra(){
			String letra = Jogo.lerString(mostrar() + "\nDigite uma letra!");
			letra = letra.toUpperCase();
			adicionarLetra(letra);
	}
	
	public static String mostrar(){
		String str = "";
		String strAsteriscos = "";
		for (int i = 0; i < asteriscos.length; i++) {
			strAsteriscos += asteriscos[i];
		}
		str = "Jogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos() + "\nTema: " + tema.getNome() + "\n__\n   |\n" + boneco.mostrar() + "\n\nPalavra: " + strAsteriscos;
		return str;
	}

	public static void incrementarTemas(){
		while(true){
			
			int count = 0;
			String strTemas = "Temas disponíveis para incremento: ";
			
			for (int i = 0; i < temas.length; i++) {
				if (temas[i].getNome() != null){
					strTemas += "\n" + (i+1) + " - " + temas[i].getNome() + " // Qtd. palavras: [" + temas[i].getConjuntoPalavras().length + "]"; 
					count++;}
			}
			
			String menu = strTemas + "\nOpções:\n1 - Adicionar palavra\n2 - Adicionar tema\n0 - Sair\nEscolha uma opção!";
			
			int opcao = Jogo.lerInteiro(menu);
			
			if (opcao == 1){
				String nomeTema, novaPalavra;
				int i;
				nomeTema = Jogo.lerString(strTemas + "\nDigite o nome do tema a ser incrementado: ");
				for (i = 0; i < temas.length; i++) {
					if (temas[i].getNome().equals(nomeTema)){
						break;
					}
				}
				novaPalavra = Jogo.lerString("Digite palavra a adicionar: ");
				temas[i].adicionarPalavra(novaPalavra);
				Jogo.msg("Palavra adicionada com sucesso!\n");
			}
			else if (opcao == 2){
				String nomeTema, conjuntoTema;
				nomeTema = Jogo.lerString("Digite nome do tema:");
				conjuntoTema = Jogo.lerString("Digite o conjunto de palavras (separadas por espaço): ");
				Tema novoTema = new Tema(nomeTema, conjuntoTema);
				temas[count] = novoTema;
				Jogo.msg("Tema adicionado com sucesso!\n");
				break;
			}
			else if (opcao == 0){break;}
			else {Jogo.msg("Digite uma opção válida!");}
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
