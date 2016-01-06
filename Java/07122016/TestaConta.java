package aula;

class TestaConta{
	public static void main(String[] args){
		Cliente c1 = new Cliente("Rogerio Silva", "123456789", "Teresina");
		Cliente c2 = new Cliente("Valeria Costa", "123456788", "Teresina");
		Conta conta1 = new Conta(c1);
		Conta conta2 = new Conta(c2);

		conta1.depositar(1000);
		conta2.depositar(1000);

		conta2.transferir(600, conta1);
		
		System.out.println(conta1.getCliente().getNome());
		
		System.out.print(conta1 + "\n");
		System.out.print(conta2 + "\n");

		System.out.println(conta1.extrato());
		System.out.println(conta2.extrato());
	}
}