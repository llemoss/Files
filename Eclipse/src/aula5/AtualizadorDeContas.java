package aula5;

public class AtualizadorDeContas {
	private double saldoTotal = 0;
	private double selic;
	
	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}
	public void roda(Conta c) {
		double saldoAnterior = c.getSaldo();
		System.out.println("Saldo anterior: " + saldoAnterior);
		double saldo = c.getSaldo();
		saldo += this.selic;
		System.out.println("Saldo final: " + saldo + "\n");
		this.saldoTotal += saldo;
	}
	
	public double getSaldoTotal() {
		return saldoTotal;
	}
}
