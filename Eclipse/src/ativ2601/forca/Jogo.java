package ativ2601.forca;
import java.util.Scanner;

public class Jogo {
	
	static Scanner input = new Scanner(System.in);
	static String nome;
	static Rodada rodada;
		
	public static void main(String[] args) {
		
		System.out.print("Digite seu nome: ");
		nome = input.next();
		rodada = new Rodada(new Jogador(nome));
		Rodada.clear();
		while(true){
			int opcao;
			System.out.println("Bem vindo ao Jogo da Forca, " + rodada.getJogador().getNome() + "!\n1 - Jogar\n2 - Incrementar\n0 - Sair");
			System.out.print("Opção escolhida: ");
			opcao = input.nextInt();
			if (opcao == 1){
				Rodada.mostrar();
				while(Rodada.getBoneco().isDead() == false){
					Rodada.adicionarLetra();
				}
				break;}
			else if (opcao == 2){
				System.out.println("\n");
				Rodada.incrementarTemas();}
			else if (opcao == 0){break;}
			else{System.out.print("Digite uma opção válida!: "); opcao = input.nextInt();}	
		}
	}
	
	
}
