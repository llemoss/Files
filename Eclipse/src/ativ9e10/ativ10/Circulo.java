package ativ9e10.ativ10;

public class Circulo implements AreaCalculavel {

	private double raio;
	
	public Circulo(double raio){
		this.raio = raio;
	}
	
	@Override
	public double calcularArea() {
		return Math.PI * this.raio * this.raio;
	}

}
