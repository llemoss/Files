package ativ9e10.ativ10;

public class ContaCorrente implements ContaTributavel{
	
	private double saldo;
	
	@Override
	public void atualizar(double taxa){
		this.saldo += this.saldo * taxa * 2;
	}
	
	@Override
	public void depositar(double valor){
		this.saldo += valor - 0.10;
	}

	@Override
	public double calcularTributos() {
		return this.saldo * 0.01;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}

}
