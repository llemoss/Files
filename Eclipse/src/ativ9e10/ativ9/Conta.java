package ativ9e10.ativ9;

public abstract class Conta {
	
	private double saldo;
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		this.saldo -= valor;
	}
	
	public abstract void atualizar(double taxa);
	
	//this.atualizar(100); // � poss�vel utilizar um m�todo abstrato dentro da pr�pria classe abstrata
	
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
