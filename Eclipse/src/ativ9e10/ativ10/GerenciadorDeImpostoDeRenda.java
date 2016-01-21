package ativ9e10.ativ10;

public class GerenciadorDeImpostoDeRenda {
	
	private double total;
	
	void adicionar(Tributavel t){
		System.out.println("Adicionando tributavel: " + t.calcularTributos());
		this.total += t.calcularTributos();
	}
	
	public double getTotal(){
		return this.total;
	}

}
