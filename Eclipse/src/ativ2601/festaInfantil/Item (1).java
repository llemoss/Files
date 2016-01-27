package ativ2601.festaInfantil;

public class Item {
	
	private String nome;
	private double valor;
	
	Item(String nome, double valor){
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return this.nome;
	}

	public double getValor() {
		return this.valor;
	}

}
