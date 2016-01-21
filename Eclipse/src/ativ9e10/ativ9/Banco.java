package ativ9e10.ativ9;

public class Banco {
	
	private Conta[] contas;
	private int count = 0;
	
	public Banco(){
		this.contas = new Conta[10];
		for (int i = 0; i < contas.length; i++) {
			contas[i] = new ContaCorrente();
		}
	}
	
	public Conta[] getContas() {
		return contas;
	}
	
	public void adicionar(Conta c){
		contas[count++] = c;
	}
	
	public Conta pegarConta(int x){
		return contas[x];
	}
	
	public int pegarTotalDeContas(){
		return this.count;
	}
}
