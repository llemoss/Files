package ativ2601.forca;
import java.util.Scanner;

public class Rodada {
	
	private Boneco boneco = new Boneco();
	static Scanner input = new Scanner(System.in);
	private int vida = 6;
	private int score = 0;
	private Tema tema;
	private static Tema[] temas = new Tema[10];
	private static Tema animais = new Tema("Animais", "Cachorro Gato Passaro Ornintorrinco");
	private static Tema frutas  = new Tema("Frutas", "Manga Banana Abacaxi Limao");
	private Jogador jogador;
	private String[] palavra;
	private String[] asteriscos;
	private String letrasErradas = "";
	private String letrasAcertadas = "";
	private String status = "";

	Rodada(Jogador jogador){
		
		this.jogador = jogador;
		
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
	
	public void adicionarLetra(String letra){
		
		this.status = "";
		
		boolean acertou = false;
		int contador = 0;
		
		for (int i = 0; i < palavra.length; i++) {
			if (letra.equals(palavra[i])){
				asteriscos[i] = letra;
				acertou = true;
				contador++;}
		}
		
		if (acertou == false){
			getBoneco().setVida(--vida);
			getBoneco().removerParte();
			letrasErradas += " " + letra;
			this.status = "Você errou!" + " Letras erradas:" + letrasErradas + "\n";
		}else{
			contador--;
			if (letrasAcertadas.contains(letra)){
				score += 0;
				jogador.setPontos(score);
				this.status = "Você já digitou essa letra!\n";
			}else{
				score += 100 + (contador * 15);
				jogador.setPontos(score);
				letrasAcertadas += letra;
				this.status = "Você acertou!" + "\n";
			}
		}
	}
	
	public String gameOver(){
		
		String strPalavra = "";
		String strAsteriscos = "";
		
		for (int i = 0; i < palavra.length; i++) {
			strPalavra += palavra[i];
			strAsteriscos += asteriscos[i];
		}
		
		if (strPalavra.equals(strAsteriscos)){
			boneco.setDead(true);
			return "Você ganhou!\nJogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos() + "\nTema: " + tema.getNome() + " // Palavra: " + strPalavra;}
		else if (vida == 0){
			boneco.setDead(true);
			return "Você morreu!\nJogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos() + "\nTema: " + tema.getNome() + " // Palavra: " + strPalavra;}
		else{
			return null;
		}
	}
		
	public String mostrar(){
		String str = "";
		String strAsteriscos = "";
		for (int i = 0; i < asteriscos.length; i++) {
			strAsteriscos += asteriscos[i];
		}
		str = this.status + "Jogador: " + jogador.getNome() + " // Pontuação: " + jogador.getPontos() + "\nTema: " + tema.getNome() + "\n__\n   |\n" + boneco.mostrar() + "\n\nPalavra: " + strAsteriscos;
		return str;
	}
		
	public Tema[] getTemas() {
		return temas;
	}

	public void setTemas(Tema[] temas) {
		Rodada.temas = temas;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Boneco getBoneco() {
		return this.boneco;
	}

	public String getStatus() {
		return status;
	}

	public void setBoneco(Boneco boneco) {
		this.boneco = boneco;
	}
}
