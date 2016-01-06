class TestaConta{
	public static void main(String[] args){
		Conta conta1 = new Conta();
		conta1.titular = "Rogerio Silva";
		conta1.numero = 123;

		Conta conta2 = new Conta();
		conta2.titular = "Valeria Costa";
		conta2.numero = 124;

		conta1.depositar(1000);
		conta2.depositar(1000);

		conta2.transferir(500, conta1);

		System.out.print(conta1 + "\n");
		System.out.print(conta2 + "\n");

		conta1.extrato();
	}
}