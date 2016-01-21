package ativ9e10.ativ10;

public class Teste {

	public static void main(String[] args) {
		AreaCalculavel a = new Retangulo(2,3);
		System.out.println(a.calcularArea());
		AreaCalculavel b = new Circulo(4);
		System.out.println(b.calcularArea());
	}

}
