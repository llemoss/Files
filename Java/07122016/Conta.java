package aula;

class Conta{
	private int numero;
	private Cliente cliente;
	private double saldo;
	private String extrato;
	private static int contador;
	
	public static int getNextCounter(){
		return ++contador;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public Conta(){}
	public Conta(Cliente cliente){
		this.cliente = cliente;
		this.numero = Conta.getNextCounter();
		if(this.numero > 0){
			extrato = "Extrato da conta " + this.numero + ":\n";
		}
	}
	public Conta(Cliente cliente, double saldoInicial){
		this.numero = Conta.getNextCounter();
		this.cliente = cliente;
		this.saldo = saldoInicial;
		if(this.numero > 0){
			extrato = "Extrato da conta " + this.numero + ":\n";
		}
	}
	
	public void depositar(double valor){
		this.saldo += valor;
		String info = valor + " foi depositado em " + this.numero + "\n";
		this.extrato += info;}

	public boolean sacar(double valor){
		if(valor <= saldo){
			this.saldo -= valor;
			String info = valor + " foi sacado de " + this.numero + "\n";
			this.extrato += info;
			return true;
		}
		else{
			return false;}
	}

	public void transferir(double valor, Conta destino){
		if(sacar(valor)){
			destino.depositar(valor);
		}
	}

	public String extrato(){
		return extrato;
	}

	public String toString(){
		return "Conta: " + this.numero + " // Saldo: " + this.saldo + " // Cliente: " + this.cliente;
	}
	

}