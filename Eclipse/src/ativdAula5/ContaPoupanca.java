package ativdAula5;

public class ContaPoupanca extends Conta{
	
	@Override
	public void atualizar(double taxa){
		super.atualizar(taxa*3);
	}
	
	@Override
	public void depositar(double valor){
		double saldo = this.getSaldo();
		saldo += valor - 0.10;
		this.setSaldo(saldo);
	}

}
