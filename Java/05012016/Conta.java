class Conta{
	private int numero;
	private String titular;
	private String cpf;
	private double saldo;
	private String extrato;
	
	public Conta(){}
	public Conta(int numero, String titular){
		this.numero = numero;
		this.titular = titular;
		if(this.numero > 0){
			extrato = "Extrato da conta " + this.numero + ":\n";
		}
	}
	public Conta(int numero, String titular, double saldoInicial){
		this.numero = numero;
		this.titular = titular;
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
		return "Conta: " + this.numero + " // Saldo: " + this.saldo;
	}
}