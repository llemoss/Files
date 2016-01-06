class TestaConta{
	public static void main(String[] args){
		Conta conta1 = new Conta(1, "Rogerio da Silva");
		Conta conta2 = new Conta(2, "Valeria Costa");

		conta1.depositar(1000);
		conta2.depositar(1000);

		conta2.transferir(600, conta1);

		System.out.print(conta1 + "\n");
		System.out.print(conta2 + "\n");

		System.out.println(conta1.extrato());
		System.out.println(conta2.extrato());
	}
}