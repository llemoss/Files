package ativ9e10.ativ10;

public class TestaContas {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		
		Conta c = new ContaCorrente();
		banco.adicionar(c);
		Conta c1 = new ContaCorrente();
		banco.adicionar(c1);
		Conta c2 = new ContaPoupanca();
		banco.adicionar(c2);
		Conta c3 = new ContaCorrente();
		banco.adicionar(c3);
		Conta c4 = new ContaCorrente();
		banco.adicionar(c4);
		Conta c5 = new ContaPoupanca();
		banco.adicionar(c5);

		for (Conta conta : banco.getContas()) {
			conta.depositar(1000);
			System.out.println(conta.getSaldo());
		}

		
	}
}
