package ativ2601.festaInfantil;

public class Castelo implements Item {

	private String nome = "Castelo";
	private double valor = 250;
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public double getValor() {
		return this.valor;
	}

}
