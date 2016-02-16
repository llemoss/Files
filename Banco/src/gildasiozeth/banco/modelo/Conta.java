package gildasiozeth.banco.modelo;

public class Conta{
	private int numero;
	private Cliente cliente;
	private double saldo;
	private static int contador;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
		this.numero = Conta.getProximoNumero();
	}
	
	public static int getProximoNumero(){
		return ++contador;
	}
	
	public void sacar(double valor) throws InsufficientBalanceException, DailyLimitException{
		
		if (valor >= 1000){
			throw new DailyLimitException("Limite diário de saque excedido");
		}
		
		if (valor <= saldo){
			saldo -= valor;
		}else{
			throw new InsufficientBalanceException("Saldo insuficiente");
			//App deve seguir um fluxo adequado, não só mostrar erro
			
		}	
	}

	public void transferir(double valor, Conta contaDestino) throws InsufficientBalanceException, DailyLimitException, InvalidValueException{
		try{
			this.sacar(valor);
			contaDestino.depositar(100);
		}catch(InvalidValueException e){
			System.out.println(e.getMessage());
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void depositar(double valor) throws InvalidValueException{
		if (valor < 0){
			throw new InvalidValueException(valor);
		}else{
			saldo += valor;
		}
	}

	public String toString(){
		String str = " Telefones: ";
		for (Telefone telefone : cliente.getTelefones()) {
			str += telefone.getTipo()+ ": "+ telefone.getTelefone() + ", ";
		}
		return "Conta: " + numero + " //" + cliente + " // Saldo: " + saldo; 
	}

}
