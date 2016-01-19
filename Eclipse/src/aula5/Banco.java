package aula5;

public class Banco {
	
	Conta[] contas;
	private int count = 0;
	
	public void adicionar(Conta c){
		contas[count++] = c;
	}
	
	public Conta pegarConta(int x){
		return contas[x];
	}
	
	public void pegarTotalDeContas(){
		double total = 0;
		for (Conta c : contas) {
			total += c.getSaldo();
		}
		System.out.println("Total: " + total);
	}
}
