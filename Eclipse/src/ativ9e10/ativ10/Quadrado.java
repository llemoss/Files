package ativ9e10.ativ10;

public class Quadrado implements AreaCalculavel {

	private int lado;
	
	public Quadrado(int lado){
		this.lado = lado;
	}
	
	@Override
	public double calcularArea() {
		return this.lado * this.lado;
	}

}
