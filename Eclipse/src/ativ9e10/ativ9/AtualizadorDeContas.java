package ativ9e10.ativ9;

import ativ9e10.ativ9.Conta;

public class AtualizadorDeContas extends Conta {
	
	private double saldoTotal = 0;
	private double selic;
	
	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}
	
	public void roda(Conta c) {
		double saldoAnterior = c.getSaldo();
		System.out.println("Saldo anterior: " + saldoAnterior);
		c.atualizar(this.selic);
		System.out.println("Saldo final: " + c.getSaldo() + "\n");
		this.saldoTotal += c.getSaldo();
	}
	
	public double getSaldoTotal() {
		return saldoTotal;
	}

	@Override
	public void atualizar(double taxa) {
		// TODO Auto-generated method stub
		
	}
}
