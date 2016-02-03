package ativ2601.forca;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Jogo {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String nome = JOptionPane.showInputDialog("Digite seu nome:");
		Rodada rodada = new Rodada(new Jogador(nome));
		clear();
		
		while(true){
			String menu = "Bem vindo ao Jogo da Forca, " + rodada.getJogador().getNome() + "!\n1 - Jogar\n2 - Incrementar\n0 - Sair\nOpção escolhida: ";
			int opcao = lerInteiro(menu);
			switch(opcao){
			case 1:
				rodada.mostrar();
				while(rodada.getBoneco().isDead() == false){
					inputLetra(rodada);
				}
				rodada.gameOver();
				opcao = 0;
				break;
			case 2:
				System.out.println("\n");
				incrementar(rodada);
				break;
			case 0:
				break;
			default:
				msg("Digite uma opção válida!");
				break;
			}
			
			if (opcao == 0){break;}
		}
	}

	public static void incrementar(Rodada rodada){
		while(true){
			int count = 0;
			
			String strTemas = "Temas disponíveis para incremento:";
			for (int i = 0; i < rodada.getTemas().length; i++) {
				if (rodada.getTemas()[i].getNome() != null){
					strTemas += "\n" + (i+1) + " - " + rodada.getTemas()[i].getNome() + " // Qtd. palavras: [" + rodada.getTemas()[i].getConjuntoPalavras().length + "]"; 
					count++;}
			}
			
			String menu = strTemas + "\n\nOpções:\n1 - Adicionar palavra\n2 - Adicionar tema\n0 - Voltar ao menu\n\nEscolha uma opção!";

			int opcao = lerInteiro(menu);
			if (opcao == 1){
				String novaPalavra;
				int idTema;
				idTema = lerInteiro(strTemas + "\nDigite o número do tema a ser incrementado:");
				if (idTema < 0 || idTema > count){
					msg("Tema inválido ou inexistente!");
				}else{
					novaPalavra = lerString("Digite palavra a adicionar: ");
					rodada.getTemas()[idTema-1].adicionarPalavra(novaPalavra);
					msg("Palavra adicionada com sucesso!\n");
				}
			}else if (opcao == 2){
				String nomeTema, conjuntoTema;
				nomeTema = lerString("Digite nome do tema:");
				conjuntoTema = lerString("Digite o conjunto de palavras (separadas por espaço): ");
				Tema novoTema = new Tema(nomeTema, conjuntoTema);
				rodada.getTemas()[count] = novoTema;
				msg("Tema adicionado com sucesso!\n");
			}else if (opcao == 0){break;}
			else {msg("Digite uma opção válida!");}
			}
		}
	
	public static void inputLetra(Rodada rodada){
		String letra = lerLetra(rodada.mostrar() + "\nDigite uma letra!");
		rodada.adicionarLetra(letra);
		if(rodada.gameOver() != null){
			msg(rodada.gameOver());
		}
	}

	public static void clear(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	static void msg(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	static int lerInteiro(String str) {
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
	
	static String lerString(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	static String lerLetra(String str) {
		return JOptionPane.showInputDialog(str).toUpperCase();
	}
	
	
}
