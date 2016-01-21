package ativ9e10.ativ10;

public class Retangulo implements AreaCalculavel {

	private int largura;
	private int altura;
	
	public Retangulo(int largura, int altura){
		this.largura = largura;
		this.altura = altura;
	}
	
	@Override
	public double calcularArea() {
		return this.largura * this.altura;
	}

}
