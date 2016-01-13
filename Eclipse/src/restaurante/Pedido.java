package restaurante;

public class Pedido {

	private double valor;
	private String descricao;
	
	public Pedido(String descricao, double valor){
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public String toString() {
		return this.descricao + " // " + this.valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
