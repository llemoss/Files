import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrimeirosPassos {
	public static void main(String[] args){

		int matricula = 123;
		double nota = 3;
		double nota2= 8;
		float media = (float)(nota+nota2);
		String nome = "Rogerio da Silva";
		boolean passou = false;
		int idade = 17;
		String sexo = "M";

		/*for(int i=0;i<10;i++){
			System.out.println("Parabens de numero: " + (i+1));
		}

		int qtd = 0;
		while(qtd < 13){
			qtd++;
			System.out.println("Aprovado! No." + qtd);
		}

		if (idade < 18 && sexo == "M"){
			System.out.println("SAI");
		}else{
			System.out.println("ENTRA");
		}

		String teste = (idade > 18) ? "Sim" : "Nao";
		System.out.println(teste);

		int [] numeros = new int[5];
		for (int i = 0; i < 5; i++){
			numeros[i] = i*7;
		}


		for(int i : numeros){
			System.out.println(i);
		}*/

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite sua idade: ");
		idade = scanner.nextInt();
		scanner.nextLine();

		String n2 = JOptionPane.showInputDialog("Digite seu nome: ");
		JOptionPane.showMessageDialog(null, n2);
		//String n = scanner.nextLine();

		//System.out.println("Nome digitado: " + n);
		System.out.println("Idade: " + idade);

	}
}