package ativ9e10.ativ10;

public class ContaPoupanca implements Conta{
	
	private double saldo;
	
	@Override
	public void atualizar(double taxa){
		this.saldo += this.saldo * taxa * 3;
	}
	
	@Override
	public void depositar(double valor){
		this.saldo += valor;
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
