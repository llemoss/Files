package ativ9e10.ativ9;

import ativ9e10.ativ10.Tributavel;

public class ContaCorrente extends Conta implements Tributavel{
	
	@Override
	public void atualizar(double taxa){
		this.setSaldo(this.getSaldo() + (this.getSaldo() * taxa * 2));
	}
	
	@Override
	public void depositar(double valor){
		super.depositar(valor - 0.10);
	}

	@Override
	public double calcularTributos() {
		return this.getSaldo() * 0.01;
	}

}
