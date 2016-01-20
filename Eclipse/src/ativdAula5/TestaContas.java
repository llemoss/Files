package ativdAula5;

public class TestaContas {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		
		Conta c = new Conta();
		banco.adicionar(c);
		Conta c1 = new ContaCorrente();
		banco.adicionar(c1);
		Conta c2 = new ContaPoupanca();
		banco.adicionar(c2);
		Conta c3 = new Conta();
		banco.adicionar(c3);
		Conta c4 = new ContaCorrente();
		banco.adicionar(c4);
		Conta c5 = new ContaPoupanca();
		banco.adicionar(c5);

		for (Conta conta : banco.getContas()) {
			conta.depositar(1000);
		}
		
		AtualizadorDeContas adc = new AtualizadorDeContas(0.01);
		
		for (Conta conta : banco.getContas()) {
			adc.roda(conta);
		}
		
		System.out.println("Saldo Total: " + adc.getSaldoTotal());

		/*System.out.println(c.getSaldo());
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());*/

	}
}
