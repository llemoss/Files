package ativ2601.forca;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Jogo {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String nome = JOptionPane.showInputDialog("Digite seu nome:");
		Rodada rodada = new Rodada(new Jogador(nome));
		Rodada.clear();
		
		while(true){
			String menu = "Bem vindo ao Jogo da Forca, " + rodada.getJogador().getNome() + "!\n1 - Jogar\n2 - Incrementar\n0 - Sair\nOpção escolhida: ";
			int opcao = lerInteiro(menu);
			switch(opcao){
			case 1:
				Rodada.mostrar();
				while(Rodada.getBoneco().isDead() == false){
					Rodada.inputLetra();
				}
				opcao = 0;
				break;
			case 2:
				System.out.println("\n");
				Rodada.incrementarTemas();
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

	static void msg(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	static int lerInteiro(String str) {
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
	
	static String lerString(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	
}
