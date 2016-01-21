package ativ9e10.ativ10;

import ativ9e10.ativ9.ContaCorrente;

public class TestaGerenciador {

	public static void main(String[] args) {
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adicionar(sv);
		
		ContaCorrente cc = new ContaCorrente();
		cc.depositar(1000);
		gerenciador.adicionar(cc);
		
		System.out.println(gerenciador.getTotal());
	}

}
