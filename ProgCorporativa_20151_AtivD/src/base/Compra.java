package base;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	
	private List<Item> itensDaCompra;
	private List<Promocao> promocoes;
	private Cliente cliente;
	
	public Compra(List<Item> itensDaCompra, Cliente cliente) {
		this.setItensDaCompra(itensDaCompra);
		this.setCliente(cliente);
		
		List<Promocao> promocoesPadrao = new ArrayList<>();
		promocoesPadrao.add(new DescontoPorPreco());
		promocoesPadrao.add(new DescontoPorQuantidade());
		
		this.setPromocoes(promocoesPadrao);
	}
	
	public double calcularValorDaCompra(){
		double valorDaCompra = 0.0;
		
		for (Item item : getItensDaCompra()) {
			valorDaCompra += item.getValor();
		}
		
		return valorDaCompra;
	}
	
	public double calcularValorTotal(){
		
		double valorTotal = calcularValorDaCompra();
		
		for (Promocao promocao : getPromocoes()) {
			valorTotal -= valorTotal * promocao.obterDesconto(this);
		}
		
		valorTotal -= valorTotal * getCliente().obterDescontoPorFidelidade();
		
		
		return valorTotal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}

	public List<Item> getItensDaCompra() {
		return itensDaCompra;
	}

	public void setItensDaCompra(List<Item> itensDaCompra) {
		this.itensDaCompra = itensDaCompra;
	}
	
}
