package ativ9e10.ativ10;

public interface Conta {
	
	public void depositar(double valor);
	
	public void sacar(double valor);
	
	public abstract void atualizar(double taxa);
		
	public double getSaldo();
	
}
