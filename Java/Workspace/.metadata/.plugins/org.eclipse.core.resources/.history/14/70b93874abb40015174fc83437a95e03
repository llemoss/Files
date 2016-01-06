class Conta{
	int numero;
	String titular;
	String cpf;
	private double saldo;
	String extrato = "Extrato:\n";

	public void depositar(double valor){
		saldo += valor;
		String info = valor + " foi depositado em " + numero + "\n";
		extrato += info;}

	public boolean sacar(double valor){
		if(valor <= saldo){
			saldo -= valor;
			String info = valor + " foi sacado de " + numero + "\n";
			extrato += info;
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

	public void extrato(){
		System.out.println(extrato);
	}

	public String toString(){
		return "Conta: " + numero + " // Saldo: " + saldo;
	}
}