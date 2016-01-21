package ativ9e10.ativ10;

import ativ9e10.ativ9.ContaCorrente;

public class TestaTributavel {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		cc.depositar(100);
		System.out.println(cc.calcularTributos());
	
		Tributavel t = cc;
		System.out.println(t.calcularTributos());
		//System.out.println(t.getSaldo()); Não funciona porque Tributavel não tem como usar getSaldo()
	}

}
