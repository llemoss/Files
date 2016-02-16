package trabalhoSO;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AlgoritmoCircular {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int quantum, trocaContexto;
		String[] listaProgramas;
		String[] vetorString;
		
		String str = lerString("Digite os tempos de processador dos programas separando por espaço:");
		listaProgramas = str.split(" ");
		str = lerString("Digite quantum e fator de troca de contexto separados por espaço:\nQuantidade de programas a serem computados: " + listaProgramas.length);
		vetorString = str.split(" ");
		quantum = Integer.parseInt(vetorString[0]);
		trocaContexto = Integer.parseInt(vetorString[1]);
		int turnaround = tempoMedioTurnaround(listaProgramas, quantum, trocaContexto);
		msg("Tempo medio de turnaround: " + turnaround);
	}
	
	static int tempoMedioTurnaround(String[] lista, int quantum, int trocaContexto){
		
		int i;
		int tempo = 0;
		int[] listaProgramas = new int[lista.length];
		
		for (i = 0; i < lista.length; i++) {
			listaProgramas[i] = Integer.parseInt(lista[i]);
		}
		
		while(true){
			
			int count = 0;
			for (int j = 0; j < listaProgramas.length; j++)
				{if (listaProgramas[j] == 0){count++;}}
			System.out.println("Count: " + count);
			if (count == listaProgramas.length){break;}
			
			for (i = 0; i < listaProgramas.length; i++) {
				
				System.out.println("P" + i + " // Tempo: " + tempo + " // Valor: " + listaProgramas[i]);
				
				if(trocaContexto == 0){trocaContexto = 1;}
				
				if(listaProgramas[i] > 0){
					tempo += quantum + trocaContexto;
					if((listaProgramas[i] - quantum) < 0){
						listaProgramas[i] = Math.abs(listaProgramas[i] - quantum);
						quantum = listaProgramas[i];
					}else{
						listaProgramas[i] = listaProgramas[i] - quantum;
					}
				}
			}
		}
		
		System.out.println("Tempo = " + tempo + " // Tempo - Troca de Contexto = " + (tempo - trocaContexto));
		tempo = ((tempo - trocaContexto) / listaProgramas.length);
		
		return tempo;
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
